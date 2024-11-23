package main.message;

public class MessageParser {
    private String transmission;
    private Message message;
    private boolean received = false;

    public MessageParser(String transmission) {
        setTransmission(transmission);
    }

    public Message getMessage() {
        buildMessage(this.transmission);
        return this.message;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    private void buildMessage(String transmission) {
        String[] parsed = transmission.split("\\|");
        Message message = new Message();

        if (parsed[0].equals(Header.START_OF_MESSAGE)) {
            received = true;
            message
                    .setVersion(parsed[1])
                    .setSenderName(parsed[2])
                    .setDestination(Integer.parseInt(parsed[3]))
                    .setContent(parsed[5]);
        }
        this.message = message;
    }
}
