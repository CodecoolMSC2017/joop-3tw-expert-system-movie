package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    public RuleParser() {
    }

    public RuleRepository getRuleRepository() {
        loadXmlDocument("data/Rules.xml");
        for (Element ruleElement : getElements("Rule")) {

        }
    }
}