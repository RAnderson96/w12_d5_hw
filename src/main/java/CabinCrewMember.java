public class CabinCrewMember {
    private String name;
    private CrewRank crewRank;

    public CabinCrewMember(String name, CrewRank crewRank) {
        this.name = name;
        this.crewRank = crewRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCrewRank() {
        return crewRank.getRank();
    }

    public void setCrewRank(CrewRank crewRank) {
        this.crewRank = crewRank;
    }

    public String relayMessage(String s) {
        return s;
    }
}
