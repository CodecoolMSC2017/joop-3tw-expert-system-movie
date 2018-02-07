package com.codecool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ESProvider {

    FactParser factParser;
    RuleParser ruleParser;
    List<Question> rules;

    Map<String, Boolean> qa = new HashMap<>();
    Answer answer;
    List<Fact> facts;

    RuleRepository ruleRepository;


    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
        ruleRepository = ruleParser.getRuleRepository();
        //facts = factRepository.getFactList();
        rules = ruleRepository.getRuleList();
    }

    public void collectAnswers() {
        Scanner scanner = new Scanner(System.in);
        String line;
        answer = new Answer();

        for (int i=0; i<rules.size();i++){
            System.out.println(rules.get(i).getQuestion());
            line = scanner.nextLine();
            qa.put(rules.get(i).getId(), answer.evaluateAnswerByInput(line));
        }
    }

    public boolean getAnswerByQuestion(String questionId) {
        boolean answer = true;



        for (int i=0; i<rules.size();i++){

            if (rules.get(i).getId().equals(questionId)){
                System.out.println(rules.get(i).getQuestion());

            }
        }

        return answer;
    }

    public String evaluate() {
        String string = "";
        return string;
    }
}
