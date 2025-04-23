package web.codesignal.acip.decomposition.unit1;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static List<String> analyzeLogs(String logs) {
        List<String> logList = new ArrayList<>(Arrays.asList(logs.split(", ")));

        HashMap<Integer, int[]> timeDict = new HashMap<>();  // HashMap to record the creation moment for each group in minutes
        TreeMap<Integer, Integer> lifeDict = new TreeMap<>(); // TreeMap to record the lifetime for each group in minutes

        for (String log : logList) {
            String[] parts = log.split(" ");
            int groupId = Integer.parseInt(parts[0]);
            String action = parts[1];
            String time = parts[2];

            // Parsing the time from HH:MM format
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            int currentTime = hour * 60 + minute; // Time in minutes from start of day

            if (action.equals("create")) {
                timeDict.put(groupId, new int[]{hour, minute}); // If the group is created, log the creation time.
            } else {
                if (timeDict.containsKey(groupId)) {
                    // If the group is deleted, calculate its entire lifetime and remove it from the creation records.
                    int creationTime = timeDict.get(groupId)[0] * 60 + timeDict.get(groupId)[1];
                    int lifetime = currentTime - creationTime;
                    lifeDict.put(groupId, lifeDict.getOrDefault(groupId, 0) + lifetime);
                    timeDict.remove(groupId);
                }
            }
        }

        // Find the longest lifetime
        int maxLife = Collections.max(lifeDict.entrySet(), Map.Entry.comparingByValue()).getValue();

        // Building the result list where each item is a string of "group ID lifetime" if it has the longest lifetime.
        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : lifeDict.entrySet()) {
            if (entry.getValue() == maxLife) {
                int hours = entry.getValue() / 60;
                int minutes = entry.getValue() % 60;
                String timeString = String.format("%02d:%02d", hours, minutes);
                result.add(entry.getKey() + " " + timeString);
            }
        }

        // Sorting the result in ascending order of the group IDs
        result.sort(Comparator.comparing(s -> Integer.parseInt(s.split(" ")[0])));
        return result;
    }

    public static void main(String[] args) {
        String logs = "1 create 09:00, 2 create 10:00, 1 delete 12:00, 3 create 13:00, 2 delete 15:00, 3 delete 16:00";
        List<String> result = analyzeLogs(logs);
        for (String entry : result) {
            System.out.println("Group " + entry.split(" ")[0] + " lifetime: " + entry.split(" ")[1]);
        }
        // Outputs:
        // Group 2 lifetime: 05:00
    }
}