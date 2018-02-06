package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    String id, question;
    boolean value;
    Question question;

    public RuleRepository getRuleRepository() throws Exception {
        loadXmlDocument("data/Rules.xml");
        RuleRepository ruleRepository = new RuleRepository();
        for (Element ruleElement : getElements("Rule")) {

            Node nNode = ruleElement;
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                id = eElement.getAttribute("id");
                question = eElement.getElementsByTagName("Question").item(0).getAttributes().getNamedItem("value").getNodeValue();
                question = new Question(id, question);
                NodeList answers = eElement.getElementsByTagName("Answer");
                for (int i = 0; i < answers.getLength(); i++) {
                    Node mNode = answers.item(i);
                    if(mNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element answer = (Element)mNode;
                        String value = answer.getAttribute("id");
                        value = Boolean.parseBoolean(eval.getTextContent().trim());
                        fact.setFactValueById(evalId, value);
                    }
                }
                ruleRepository.addRule(Question question);
            }
        }
        return ruleRepository;
    }
}