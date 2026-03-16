import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl*1000;
    }
}

class DNSCache {

    private HashMap<String, DNSEntry> cache = new HashMap<>();
    int hits=0, misses=0;

    public String resolve(String domain) {

        DNSEntry entry = cache.get(domain);

        if(entry != null && entry.expiry > System.currentTimeMillis()) {
            hits++;
            return entry.ip;
        }

        misses++;

        String newIP = "192.168.1." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(newIP,300));

        return newIP;
    }

    public void getStats() {
        int total = hits+misses;
        double hitRate = (hits*100.0)/total;

        System.out.println("Hit Rate: " + hitRate + "%");
    }
}
