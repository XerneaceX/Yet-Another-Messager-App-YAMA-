package main.app;

public class Settings {

    public static String VERSION;
    public static String HOST;
    public static int PORT;
    public static String USERNAME;
    public static String USER_ID;
    public static String HASHED_PASSWORD;


    private static Settings INSTANCE = null;



    private Settings() {
    }


    public static Settings getInstance() {
        if (INSTANCE == null) INSTANCE = new Settings();
        return INSTANCE;
    }
}
