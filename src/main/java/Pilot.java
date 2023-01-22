public class Pilot {
    private String name;
    private CrewRank crewRank;
    private String pilotLicenseNumber;

    public Pilot(String name, String pilotLicenseNumber) {
        this.name = name;
        this.pilotLicenseNumber = pilotLicenseNumber;
        this.crewRank =  CrewRank.CAPTAIN;
    }

    public String flyPlane() {
        return "Hello, my name is Captain " + this.name + " and I will be your pilot for your journey";
    }
}
