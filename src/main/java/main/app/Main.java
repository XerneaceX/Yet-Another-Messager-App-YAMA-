package main.app;

import main.app.comm.Client;
import main.message.Message;
import main.message.MessageParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public void start() throws ParserConfigurationException, IOException, SAXException {
        System.out.println("Client starting...");
        Settings.getInstance();
        System.out.println("Settings loaded!");
        System.out.println("App version: v" + Settings.VERSION);
        System.out.println("Server at: " + Settings.HOST + ":" + Settings.PORT);
        System.out.println("Loaded default user: " + Settings.USERNAME);
        System.out.println(Settings.USERNAME +"'s id: " + Settings.USER_ID);

        Client client1 = new Client();
        client1.start();

    }
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Main main = new Main();
        main.start();
    }
}
