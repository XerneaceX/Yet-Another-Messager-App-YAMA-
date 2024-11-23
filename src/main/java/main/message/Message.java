package main.message;

import main.app.Settings;
import main.app.User;

public class Message {

    public static final int SEND_TO_DEFAULT = 0;
    public static final String SENDER_NAME_DEFAULT = "UNKNOWN";
    public static final String DEFAULT_MESSAGE = "DEFAULT_MESSAGE";


    private String content;
    private String senderName;
    private String meta;
    private String version;
    private int sendToID;


    public Message(String senderName, String content) {
        this.
                setSenderName(senderName)
                .setContent(content)
                .setVersion(Settings.VERSION)
                .build();
    }

    public Message(String senderName) {
        this(senderName, DEFAULT_MESSAGE);
    }

    protected Message() {
        this(SENDER_NAME_DEFAULT, DEFAULT_MESSAGE);
    }

    public Message(User user) {
        this(user.getName(), DEFAULT_MESSAGE);
    }

    public String getContent() {
        return content;
    }

    public Message setVersion(String version) {
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

    private Message setMeta() {
        this.meta = Header.START_OF_MESSAGE + Header.SEPARATOR +
                Settings.VERSION + Header.SEPARATOR +
                senderName + Header.SEPARATOR +
                sendToID + Header.SEPARATOR +
                Header.END_OF_MESSAGE+ Header.SEPARATOR;
        return this;
    }

    public Message setDestination(int sendToID) {
        this.sendToID = sendToID;
        return this;
    }

    public void build() {
        setMeta();
    }

    @Override
    public String toString() {
        return "Message{" +
                "app version='" + version + '\'' +
                "content='" + content + '\'' +
                ", senderName='" + senderName + '\'' +
                ", header='" + meta + '\'' +
                ", sendToID=" + sendToID +
                '}';
    }
}
