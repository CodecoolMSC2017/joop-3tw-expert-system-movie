package com.codecool;

import java.util.List;
import java.util.Scanner;

public class ESProvider {

    FactParser factParser;
    RuleParser ruleParser;
    List<Question> rules;
    String line = "";
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

    }

    public boolean getAnswerByQuestion(String questionId) {
        boolean answer = true;
        Scanner scanner;
        scanner = new Scanner(System.in);


        for (int i=0; i<rules.size();i++){

            if (rules.get(i).getId().equals(questionId)){
                System.out.println(rules.get(i).getQuestion());
                line = scanner.nextLine();

                if (line.equals("yes")){
                    answer = true;
                }
                else if (line.equals("no")){
                    answer = false;
                }
            }
        }

        return answer;
    }

    public String evaluate() {
        String string = "";
        return string;
    }
}
