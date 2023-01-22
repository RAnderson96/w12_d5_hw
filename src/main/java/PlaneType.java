public enum PlaneType {
    BOEING747(4, 240),
    AIRBUSA380(5, 250);

    private final int capacity;
    private final double weight;
    PlaneType(int capacity, double weight){
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getWeight() {
        return weight/2;
    }

    public double getWeightPerPassenger(){ return (weight/2)/capacity; }
}



//BOEING747