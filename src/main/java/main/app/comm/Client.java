package main.app.comm;

import main.app.Settings;
import main.message.Message;
import main.message.MessageParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Set;

public class Client extends Thread {
    private Socket client;
    private final DataInputStream in;
    private final DataOutputStream out;

    public Client() throws IOException {
        if (setClient(Settings.HOST, Settings.PORT)) {
            System.out.println("Client connected successfully to " + Settings.HOST + ":" + Settings.PORT);
        } else {
            System.out.println("Client could not connect to server at: " + Settings.HOST + ":" + Settings.PORT);
            throw new SocketTimeoutException();
        }

        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
    }

    private boolean setClient(String ip, String port) {
        try {
            this.client = new Socket(ip, Integer.parseInt(port));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean send(Message m) throws IOException {
        out.writeUTF(m.toString());

        return true;
    }

    public Message receive() throws IOException {
        try {
            String transmission = in.readUTF();
            MessageParser messageParser = new MessageParser(transmission);
            return messageParser.getMessage();
        } catch (SocketTimeoutException e) {
            return null;
        }
    }

    public void startListening() {
        System.out.println("Client is listening...");
        Message m;
        do {
            try {
                m = receive();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!m.isClosingMessage());
    }

    @Override
    public void run() {
        startListening();
    }


}
