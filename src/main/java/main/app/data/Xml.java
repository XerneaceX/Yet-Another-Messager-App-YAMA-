package main.app.data;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;


public class Xml {
    Document doc;
    public Xml() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(new File("C:\\Users\\Bouch\\OneDrive\\Documents\\YAMA\\data.xml"));
        doc.getDocumentElement().normalize();
    }

    public String getUserName(String id) {
        NodeList nl = doc.getElementsByTagName("user");
        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getAttributes().getNamedItem("id").getNodeValue().equals(id)) {
                return nl.item(i).getAttributes().getNamedItem("name").getNodeValue();
            }
        }
        return "User not found";
    }

    private String getKey(String id, String type) {
        NodeList nl = doc.getElementsByTagName("key");
        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getAttributes().getNamedItem("belongs_to").getNodeValue().equals(id) && nl.item(i).getAttributes().getNamedItem("type").getNodeValue().equals(type)) {
                return nl.item(i).getTextContent();
            }
        }
        return type + " key not found";
    }

    public String getPrivateKey(String id) {
        return getKey(id, "private");
    }

    public String getPublicKey(String id) {
        return getKey(id, "public");
    }

    public String getVersion() {
        NodeList nl = doc.getElementsByTagName("app");
        return nl.item(0).getAttributes().getNamedItem("version").getNodeValue();
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Xml xml = new Xml();
        System.out.println(xml.getPrivateKey("u1"));
        System.out.println(xml.getVersion());
    }
}
