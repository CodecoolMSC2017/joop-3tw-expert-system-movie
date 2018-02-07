package com.codecool;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        FactParser factParser;
        RuleParser ruleParser;

        ESProvider moviechoose = new ESProvider(factParser = new FactParser(), ruleParser = new RuleParser());

        moviechoose.collectAnswers();

        /*RuleRepository ruleRepository;
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
            System.out.println(facts.get(i).getValueById("funny"));
        }

        System.out.println("------------------------------");
        for (int i=0; i<rules.size();i++){
            System.out.println(rules.get(i).getId());
            System.out.println(rules.get(i).getQuestion());
            System.out.println(rules.get(i).getAnswer());
        }*/
    }
}
