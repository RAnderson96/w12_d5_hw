public enum CrewRank {
    FlIGHTATTENDANT(1),
    PURSER(2),
    FIRSTOFFICER(3),
    CAPTAIN(4);

    private final int rank;
    CrewRank(int rank){
        this.rank = rank;

    }

    public int getRank() {
        return rank;
    }
}

//Captain/First Officer/Purser, Flight Attendant)

