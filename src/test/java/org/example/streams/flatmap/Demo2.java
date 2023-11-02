package org.example.streams.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {

    public static void main(String[] args) {

        List<String> teamA = Arrays.asList("Candi", "Java", "Backend");
        List<String> teamB = Arrays.asList("Spring", "Boot", "Security");
        List<String> teamC = Arrays.asList("London", "Library", "Kitty");

        List<List<String>> playersInWorldCup = new ArrayList<>();
        playersInWorldCup.add(teamA);
        playersInWorldCup.add(teamB);
        playersInWorldCup.add(teamC);

        // before Java8

    /*   for (List<String> team : playersInWorldCup) {
            for (String player : team) {
                System.out.println(player);
            }
        } */

        // using streams flatmap()
        List<String> names = playersInWorldCup.stream().flatMap(team -> team.stream()).collect(Collectors.toList());
        System.out.println(names);
    }
}
