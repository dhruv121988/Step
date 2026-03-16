import java.util.*;

class TokenBucket {

    int tokens;
    int maxTokens;
    long lastRefill;
    int refillRate;

    TokenBucket(int max, int rate) {
        maxTokens=max;
        tokens=max;
        refillRate=rate;
        lastRefill=System.currentTimeMillis();
    }

    synchronized boolean allowRequest() {

        long now = System.currentTimeMillis();

        int refill = (int)((now-lastRefill)/1000)*refillRate;

        if(refill>0) {
            tokens = Math.min(maxTokens,tokens+refill);
            lastRefill=now;
        }

        if(tokens>0) {
            tokens--;
            return true;
        }

        return false;
    }
}

class RateLimiter {

    HashMap<String,TokenBucket> clients = new HashMap<>();

    public boolean check(String clientId) {

        clients.putIfAbsent(clientId,new TokenBucket(1000,1000/3600));

        return clients.get(clientId).allowRequest();
    }
}