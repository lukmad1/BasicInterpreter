package pl.sda.memory;

public class DataMemory extends Memory {
    private static DataMemory instance;


    private DataMemory() {
    }

    public static DataMemory getInstance() {
        if (instance == null) {
            instance = new DataMemory();
        }
        return instance;
    }
}
