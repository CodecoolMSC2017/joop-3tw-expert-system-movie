package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class XMLParser {

    protected Document document;

    public XMLParser() {

    }

    public void loadXmlDocument(String xmlPath) throws IOException {

        try {

            File fXmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            document = doc;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(xmlPath + " can't be found!");
        }catch (ParserConfigurationException pe){
            pe.printStackTrace();
        }catch (IOException ioe){
            throw new IOException("Could not read file: " + xmlPath);
        }catch (SAXException saxe){
            saxe.printStackTrace();
        }
    }


    protected Element[] getElements(String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        Element[] elements = new Element[nodeList.getLength()];
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            elements[i] = (Element)node;
        }
        return elements;
    }
}
