import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static List<String> solution(String logs) {
        List<String> logList = new ArrayList<>(Arrays.asList(logs.split(", ")));

        HashMap<Integer, int[]> timeDict = new HashMap<>();  
        TreeMap<Integer, Integer> lifeDict = new TreeMap<>();

        for (String log : logList) {
            String[] parts = log.split(" ");
            int groupId = Integer.parseInt(parts[0]);
            String action = parts[1];
            String time = parts[2];

            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            int currentTime = hour * 60 + minute;

            if (action.equals("borrow")) {
                timeDict.put(groupId, new int[]{hour, minute});
            } else {
                if (timeDict.containsKey(groupId)) {
                    
                    int creationTime = timeDict.get(groupId)[0] * 60 + timeDict.get(groupId)[1];
                    int lifetime = currentTime - creationTime;
                    lifeDict.put(groupId, lifeDict.getOrDefault(groupId, 0) + lifetime);
                    timeDict.remove(groupId);
                }
            }
        }

        int maxLife = Collections.max(lifeDict.entrySet(), Map.Entry.comparingByValue()).getValue();

        List<String> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : lifeDict.entrySet()) {
            if (entry.getValue() == maxLife) {
                int hours = entry.getValue() / 60;
                int minutes = entry.getValue() % 60;
                String timeString = String.format("%02d:%02d", hours, minutes);
                result.add(entry.getKey() + " " + timeString);
            }
        }

        result.sort(Comparator.comparing(s -> Integer.parseInt(s.split(" ")[0])));
        return result;
    }
    }