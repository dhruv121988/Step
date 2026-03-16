import java.util.*;

class Transaction {

    int id;
    int amount;

    Transaction(int id,int amount){
        this.id=id;
        this.amount=amount;
    }
}

class FraudDetector {

    public void twoSum(List<Transaction> list,int target) {

        HashMap<Integer,Transaction> map = new HashMap<>();

        for(Transaction t : list) {

            int comp = target - t.amount;

            if(map.containsKey(comp)) {

                System.out.println("Match: "+map.get(comp).id+" "+t.id);
            }

            map.put(t.amount,t);
        }
    }
}