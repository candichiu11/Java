package org.example;

import org.camunda.bpm.engine.impl.util.json.JSONArray;
import org.camunda.bpm.engine.impl.util.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class hackPractice {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/engine-rest/process-definition");
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

        JSONArray jsonArray = new JSONArray(response.toString());

        List<Process> processList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Process process = new Process(
                    jsonObject.getString("id"),
                    jsonObject.getString("key"),
                    jsonObject.getString("category"),
                    jsonObject.getString("description"),
                    jsonObject.getString("name"),
                    jsonObject.getInt("version"),
                    jsonObject.getString("resource"),
                    jsonObject.getString("deploymentId"),
                    jsonObject.getString("diagram"),
                    jsonObject.getBoolean("suspended"),
                    jsonObject.getString("tenantId"),
                    jsonObject.getString("versionTag"),
                    jsonObject.getInt("historyTimeToLive"),
                    jsonObject.getBoolean("startableInTasklist"));

            processList.add(process);
        }

        System.out.println("Process list: " + processList);

        // Use Java streams to group and collect IDs
        Map<String, List<Process>> groupIds = processList.stream()
                .collect(Collectors.groupingBy(Process::getId));

        // Print the grouped IDs
        groupIds.forEach((id, list) -> {
            System.out.println("id: " + id);
            System.out.println("process: " + list);
        });

    }
}
