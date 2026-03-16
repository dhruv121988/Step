import java.util.*;

class Autocomplete {

    HashMap<String,Integer> queries = new HashMap<>();

    public void addQuery(String q) {
        queries.put(q,queries.getOrDefault(q,0)+1);
    }

    public List<String> search(String prefix) {

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b)->queries.get(b)-queries.get(a));

        for(String q : queries.keySet()) {
            if(q.startsWith(prefix))
                pq.add(q);
        }

        List<String> res = new ArrayList<>();

        int k=10;
        while(!pq.isEmpty() && k-- >0)
            res.add(pq.poll());

        return res;
    }
}