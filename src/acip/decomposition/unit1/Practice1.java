package src.acip.decomposition.unit1;

package com.app;

import java.util.*;

public class Practice1 {
    public List<String> organizeInbox(String inboxString) {
        // TODO: Implement this method
        HashMap<String, Integer> emailsMap = new HashMap<>();
        String[] emails = inboxString.split("; ");
        for (String email: emails) {
            String[] address = email.split(",");
            emailsMap.put(address[0], emailsMap.getOrDefault(address[0], 0) +1);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : emailsMap.entrySet()) {
            result.add(entry.getKey() + " " + entry.getValue());
        }
        Collections.sort(result);
        return result;
    }
}
