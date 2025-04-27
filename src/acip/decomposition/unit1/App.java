package src.acip.decomposition.unit1;

/**
 * 
 */

import java.util.*;

public class App {
    public List<String> organizeInbox(String inboxString) {
        // TODO: Implement this method
        HashMap<String, Integer> emailsMap = new HashMap<>();
        String[] emails = inboxString.split("; ");
        for (String email: emails) {
            String[] address = email.split(",");
            emailsMap.put(address[0], emailsMap.getOrDefault(address[0], 0) +1);
        }
       List<Map.Entry<String, Integer>> list = new ArrayList<>(emailsMap.entrySet());

        Collections.sort(list, (entry1, entry2) -> {
            int valueComparison = entry2.getValue().compareTo(entry1.getValue());
            if (valueComparison != 0) {
                return valueComparison;
            }
            return entry1.getKey().compareTo(entry2.getKey());
        });

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        List<String> sortedResult = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            sortedResult.add(entry.getKey() + " " + entry.getValue());
        }
        return sortedResult;
    }
}