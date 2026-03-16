import java.util.*;

class Analytics {

    HashMap<String,Integer> pageViews = new HashMap<>();
    HashMap<String,Set<String>> uniqueUsers = new HashMap<>();
    HashMap<String,Integer> sources = new HashMap<>();

    public void processEvent(String url, String userId, String source) {

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueUsers.putIfAbsent(url,new HashSet<>());
        uniqueUsers.get(url).add(userId);

        sources.put(source,sources.getOrDefault(source,0)+1);
    }

    public void dashboard() {

        System.out.println("Top Pages");

        for(String page : pageViews.keySet()) {

            System.out.println(page+" views:"+pageViews.get(page)+
                    " unique:"+uniqueUsers.get(page).size());
        }

        System.out.println("Traffic Sources: "+sources);
    }
}