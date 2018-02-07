package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    String id, q;
    boolean value;
    Question question;
    Answer answer = new Answer();
    Value singleValue;
    Value multipleValue;

    public RuleRepository getRuleRepository() {

        String selectionValue;
        boolean selectionBool = true;

        loadXmlDocument("data/Rules.xml");
        RuleRepository ruleRepository = new RuleRepository();

        for (Element ruleElement : getElements("Rule")) {
            id = ruleElement.getAttribute("id");

            Node questionElement = ruleElement.getElementsByTagName("Question").item(0);
            q = questionElement.getTextContent();

            Element answerElement = (Element) ruleElement.getElementsByTagName("Answer").item(0);
            NodeList selectionNodes = answerElement.getElementsByTagName("Selection");

            for (int i = 0; i < selectionNodes.getLength(); i++) {
                Element selectionElement = (Element) selectionNodes.item(i);
                selectionValue = selectionElement.getAttribute("value");
                if (selectionValue.equals("true")){
                    selectionBool = true;
                }
                else if (selectionValue.equals("false")){
                    selectionBool = false;
                }

                NodeList singleValueNodes = selectionElement.getElementsByTagName("SingleValue");
                NodeList multipleValueNodes = selectionElement.getElementsByTagName("MultipleValue");

                if (singleValueNodes.getLength() == 0) {
                    Element multipleValueElement = (Element) multipleValueNodes.item(0);
                } else {
                    Element singleValueElement = (Element) singleValueNodes.item(0);
                    String s = singleValueElement.getAttribute("value");
                    answer.addValue(new SingleValue(s, selectionBool));
                }
            }
            this.question = new Question(id, q, answer);
            ruleRepository.addRule(this.question);
        }
        return ruleRepository;
    }
}