package main.message;

import main.app.Settings;
import main.app.User;

public class Message {

    public static final String SEND_TO_DEFAULT = "UNKNOWN";
    public static final String SENDER_NAME_DEFAULT = "UNKNOWN";
    public static final String DEFAULT_MESSAGE = "DEFAULT_MESSAGE";


    private String content;
    private String senderName;
    private String meta;
    private String version;
    private String sendToID;

    public Message(String content, String sendToID) {
        this.setContent(content)
                .setSenderName(Settings.USER_ID)
                .setVersion(Settings.VERSION)
                .setDestination(sendToID)
                .build();
    }

    public Message() {
        this.setContent(DEFAULT_MESSAGE)
                .setSenderName(SENDER_NAME_DEFAULT)
                .setVersion(Settings.VERSION)
                .setDestination(SENDER_NAME_DEFAULT)
                .build();
    }

    public String getContent() {
        return content;
    }

    protected Message setVersion(String version) {
        this.version = version;
        return this;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public String getSenderName() {
        return senderName;
    }

    public Message setSenderName(String senderName) {
        this.senderName = senderName;
        return this;
    }

    public boolean isClosingMessage() {
        return content.equals(Header.CLOSE_CONNECTION);
    }

    private Message setMeta() {
        this.meta = Header.START_OF_MESSAGE + Header.SEPARATOR +
                version + Header.SEPARATOR +
                senderName + Header.SEPARATOR +
                sendToID + Header.SEPARATOR +
                Header.END_OF_MESSAGE + Header.SEPARATOR;
        return this;
    }

    public Message setDestination(String sendToID) {
        this.sendToID = sendToID;
        return this;
    }

    public void build() {
        setMeta();
    }

    @Override
    public String toString() {
        return this.meta + this.content;
    }
}
