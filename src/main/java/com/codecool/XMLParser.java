package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public abstract class XMLParser {

    protected Document document;

    public XMLParser() {

    }

    public void loadXmlDocument(String xmlPath) {

        try {

            File fXmlFile = new File(String xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            document = doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Element[] getElements(String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        Element[] elements = new Element[nodeList.getLength()];
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            elements[i] = (Element)node;
        }
        return elements;
    }
}
