package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser{

    String id, description;
    boolean value;
    Fact fact;

    public FactRepository getFactRepository() {
        loadXmlDocument("data/Facts.xml");
        FactRepository factRepository = new FactRepository();
        for (Element factElement : getElements("Fact")) {

            id = factElement.getAttribute("id");
            description = factElement.getElementsByTagName("Description").item(0).getAttributes().getNamedItem("value").getNodeValue();
            fact = new Fact(id, description);
            NodeList evals = factElement.getElementsByTagName("Eval");

            for (int i = 0; i < evals.getLength(); i++) {

                Element eval = (Element) evals.item(i);
                String evalId = eval.getAttribute("id");
                value = Boolean.parseBoolean(eval.getTextContent().trim());
                fact.setFactValueById(evalId, value);
            }
            factRepository.addFact(fact);
        }
        return factRepository;
    }
}

