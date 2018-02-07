package com.codecool;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();
        RuleRepository ruleRepository;
        FactRepository factRepository;
        List<Question> rules;
        List<Fact> facts;

        factRepository = factParser.getFactRepository();
        ruleRepository =  ruleParser.getRuleRepository();

        facts = factRepository.getFactList();
        rules = ruleRepository.getRuleList();

        for (int i=0; i<facts.size();i++){
            System.out.println(facts.get(i).getDescription());
            System.out.println(facts.get(i).getIdSet());
        }

        System.out.println("------------------------------");
        for (int i=0; i<rules.size();i++){
            System.out.println(rules.get(i).getId());
            System.out.println(rules.get(i).getQuestion());
            System.out.println(rules.get(i).getAnswer());
        }
    }
}
