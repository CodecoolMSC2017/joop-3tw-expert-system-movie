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
            line = scanner.nextLine().toLowerCase();
            while (true) {
                if (("yes".equals(line) || "no".equals(line))) {
                    break;
                }
                else{
                    System.out.println("Wrong input! Please type yes or no for the question!");
                }
            }
            qa.put(rules.get(i).getId(), answer.evaluateAnswerByInput(line));
        }
    }

    public boolean getAnswerByQuestion(String questionId) {
        boolean answer;
        answer = qa.get(questionId);
        return answer;
    }

    public String evaluate() {
        String string = "";
        return string;
    }
}
