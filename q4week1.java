import java.util.*;

class PlagiarismDetector {

    private HashMap<String, Set<String>> index = new HashMap<>();

    public void addDocument(String docId, String text) {

        String[] words = text.split(" ");

        for(int i=0;i<words.length-4;i++) {

            String gram = words[i]+" "+words[i+1]+" "+words[i+2]+" "+words[i+3]+" "+words[i+4];

            index.putIfAbsent(gram,new HashSet<>());
            index.get(gram).add(docId);
        }
    }

    public void analyze(String docId, String text) {

        String[] words = text.split(" ");
        HashMap<String,Integer> matchCount = new HashMap<>();

        for(int i=0;i<words.length-4;i++) {

            String gram = words[i]+" "+words[i+1]+" "+words[i+2]+" "+words[i+3]+" "+words[i+4];

            if(index.containsKey(gram)) {

                for(String d : index.get(gram)) {

                    if(!d.equals(docId))
                        matchCount.put(d, matchCount.getOrDefault(d,0)+1);
                }
            }
        }

        System.out.println(matchCount);
    }
}