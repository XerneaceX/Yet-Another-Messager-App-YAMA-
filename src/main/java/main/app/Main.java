package main.app;

import main.message.MessageParser;

public class Main {
    public static void main(String[] args) {
        String msg = "!S|1.0|felix|0|!END|Hello World";


        MessageParser parser = new MessageParser(msg);
        parser.setTransmission(msg);
    }
}
