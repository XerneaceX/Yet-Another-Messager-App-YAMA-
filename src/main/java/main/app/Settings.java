package main.app;

import main.app.data.Xml;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Settings {

    public static String VERSION;
    public static String HOST;
    public static String PORT;
    public static String USERNAME;
    public static String USER_ID;
    public static String HASHED_PASSWORD;


    private static Settings INSTANCE = null;



    private Settings() throws ParserConfigurationException, IOException, SAXException {
        Xml xml = new Xml();
        VERSION = xml.getVersion();
        HOST = xml.getHost();
        PORT = xml.getPort();
        USERNAME = xml.getDefaultUserName();
        USER_ID = xml.getDefaultUserId();
    }


    public static Settings getInstance() throws ParserConfigurationException, IOException, SAXException {
        if (INSTANCE == null) INSTANCE = new Settings();
        return INSTANCE;
    }
}
