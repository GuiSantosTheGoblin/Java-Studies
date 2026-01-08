package util;

public enum WorkerLevel {
    JUNIOR("JUNIOR"),
    MID_LEVEL("MID_LEVEL"),
    SENIOR("SENIOR");

    private final String display;

    WorkerLevel(String display){
        this.display = display;
    }

    public String getDisplay(){
        return display;
    }
}
