package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser{

    String id, description;
    boolean value;
    Fact fact;

    public FactRepository getFactRepository() throws Exception {
        loadXmlDocument("Facts.xml");
        FactRepository factRepository = new FactRepository();
        for (Element ruleElement : getElements("Fact")) {

            Node nNode = ruleElement;
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                id = eElement.getAttribute("id");
                description = eElement.getElementsByTagName("Description").item(0).getAttributes().getNamedItem("value").getNodeValue();
                fact = new Fact(id, description);
                NodeList evals = eElement.getElementsByTagName("Eval");
                for (int i = 0; i < evals.getLength(); i++) {
                    Node mNode = evals.item(i);
                    if(mNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eval = (Element)mNode;
                        String evalId = eval.getAttribute("id");
                        value = Boolean.parseBoolean(eval.getTextContent().trim());
                        fact.setFactValueById(evalId, value);
                    }
                }
                factRepository.addFact(fact);
            }
        }
        return factRepository;
    }
}

