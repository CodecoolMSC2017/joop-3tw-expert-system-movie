package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    public RuleParser() {
    }

    public RuleRepository getRuleRepository() {
        loadXmlDocument("Rules.xml");
        for (Element ruleElement : getElements("Rule")) {

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