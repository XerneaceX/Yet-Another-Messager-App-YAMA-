package main.message;

public class MessageParser {
    public static final String DEFAULT_TRANSMISSION = "!S|UNKNOWN|UNKNOWN|UNKNOWN|!END|NO_MESSAGE";

    private String transmission;
    private Message message;

    public MessageParser(String transmission) {
        setTransmission(transmission);
    }

    public MessageParser() {
        setTransmission(DEFAULT_TRANSMISSION);
    }

    public Message getMessage() {
        String[] parsed = transmission.split("\\|");
        Message message = new Message();

        if (parsed[0].equals(Header.START_OF_MESSAGE)) {
            message.setVersion(parsed[1])
                    .setSenderName(parsed[2])
                    .setDestination(parsed[3])
                    .setContent(parsed[5])
                    .build();
        }
        return message;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
