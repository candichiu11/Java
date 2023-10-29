package org.example;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

import org.camunda.bpm.engine.impl.util.json.JSONObject;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.*;


public class App {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.err.println("Invalid number of arguments. Please provide start node and end node.");
                System.exit(-1);
            }

            String startNode = args[0];
            String endNode = args[1];

            URL url = new URL("https://n35ro2ic4d.execute-api.eu-central-1.amazonaws.com/prod/engine-rest/process-definition/key/invoice/xml");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Extract bpmn20Xml from JSON response
            JSONObject jsonObject = new JSONObject(response.toString());
            String bpmnXml = jsonObject.getString("bpmn20Xml");

            // Create an InputStream from bpmn20Xml
            InputStream inputStream = new ByteArrayInputStream(bpmnXml.getBytes());
            BpmnModelInstance modelInstance = Bpmn.readModelFromStream(inputStream);

            List<String> path = findPath(modelInstance, startNode, endNode);

            if (path.isEmpty()) {
                System.out.println("No path found");
                System.exit(-1);
            }

            System.out.println(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // BFS
    private static List<String> findPath(BpmnModelInstance modelInstance, String startNodeId, String endNodeId) {
        List<String> path = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.add(startNodeId);
        visited.add(startNodeId);

        while (!queue.isEmpty()) {
            String currentNodeId = queue.poll();
            FlowNode currentNode = modelInstance.getModelElementById(currentNodeId);

            if (currentNodeId.equals(endNodeId)) {
                String current = endNodeId;
                while (current != null) {
                    path.add(current);
                    current = parentMap.get(current);
                }
                Collections.reverse(path);
                return path;
            }

            Collection<SequenceFlow> outgoingFlows = currentNode.getOutgoing();

            for (SequenceFlow flow : outgoingFlows) {
                FlowNode targetNode = flow.getTarget();
                String targetNodeId = targetNode.getId();
                if (!visited.contains(targetNodeId)) {
                    queue.add(targetNodeId);
                    parentMap.put(targetNodeId, currentNodeId);
                    visited.add(targetNodeId);
                }
            }
        }

        System.out.println("No path found between the nodes.");
        return path;
    }
}
