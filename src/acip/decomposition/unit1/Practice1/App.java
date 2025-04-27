package com.app;

import java.util.*;

public class App {
    public List<int[]> analyzeCompetition(String logs) {
        // TODO: implement the function
        HashMap<Integer, Integer> scoreMap = new HashMap<>();
        HashMap<Integer, Integer> solvedMap = new HashMap<>();
        HashMap<Integer, Integer> failedMap = new HashMap<>();
        System.out.println(logs);
        for (String log : logs.split(", ")) {
            String[] attempt = log.split(" ");
            int studen = Integer.valueOf(attempt[0]);
            if (attempt[1].equals("solve")) {
                scoreMap.put(studen, scoreMap.getOrDefault(studen, 0) 
                    + Integer.valueOf(attempt[3]));
                solvedMap.put(studen, solvedMap.getOrDefault(studen, 0) +1);
            } else if (attempt[1].equals("fail")){
                failedMap.put(studen, failedMap.getOrDefault(studen, 0) + 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(scoreMap.entrySet());

        Collections.sort(list, (entry1, entry2) -> {
            int valueComparison = entry2.getValue().compareTo(entry1.getValue());
            if (valueComparison != 0) {
                return valueComparison;
            }
            return entry1.getKey().compareTo(entry2.getKey());
        });
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        List<int[]> sortedResult = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            int score = (entry.getValue() == null) ? 0 : entry.getValue();
            int solved = (solvedMap.get(entry.getKey()) == null) ? 0 : solvedMap.get(entry.getKey());
            int fail = (failedMap.get(entry.getKey()) == null) ? 0 : failedMap.get(entry.getKey());
            int[] e = {entry.getKey(), score, solved, fail};
            sortedResult.add(e);
        }
        return sortedResult;
    }
}