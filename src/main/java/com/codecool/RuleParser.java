package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    private String id, q;
    private Question question;
    private Answer answer = new Answer();


    public RuleRepository getRuleRepository() {

        String selectionValue;
        boolean selectionBool = true;

        try {
            loadXmlDocument("data/Rules.xml");
        }catch (Exception e){
            e.printStackTrace();
        }

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