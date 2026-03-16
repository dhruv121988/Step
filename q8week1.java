class ParkingLot {

    String[] spots = new String[500];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % spots.length;
    }

    public int park(String plate) {

        int index = hash(plate);

        int probes=0;

        while(spots[index] != null) {
            index = (index+1)%spots.length;
            probes++;
        }

        spots[index] = plate;

        System.out.println("Parked at "+index+" probes:"+probes);

        return index;
    }

    public void exit(String plate) {

        for(int i=0;i<spots.length;i++) {
            if(plate.equals(spots[i])) {
                spots[i]=null;
                System.out.println("Spot freed:"+i);
                return;
            }
        }
    }
}