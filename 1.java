import java.util.*;

class UsernameChecker {

    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for(int i=1;i<=3;i++)
            suggestions.add(username + i);

        suggestions.add(username.replace("_","."));

        return suggestions;
    }

    public String getMostAttempted() {
        String maxUser = "";
        int max = 0;

        for(String u : attempts.keySet()) {
            if(attempts.get(u) > max) {
                max = attempts.get(u);
                maxUser = u;
            }
        }

        return maxUser;
    }
}
