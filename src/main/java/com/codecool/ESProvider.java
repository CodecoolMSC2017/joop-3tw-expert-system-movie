package com.codecool;

import java.util.*;

public class ESProvider {

    FactParser factParser;
    RuleParser ruleParser;
    private List<Question> rules;
    private List<Fact> facts;

    protected String output = "";
    private Map<String, Boolean> qa = new LinkedHashMap<>();
    Answer answer;

    private RuleRepository ruleRepository;
    private FactRepository factRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
        ruleRepository = ruleParser.getRuleRepository();
        factRepository = factParser.getFactRepository();
        facts = factRepository.getFactList();
        rules = ruleRepository.getRuleList();
    }

    public void collectAnswers() {
        Scanner scanner = new Scanner(System.in);
        String line;
        answer = new Answer();
        Iterator<Question> questionIterator = ruleRepository.getIterator();

        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            System.out.println(question.getQuestion());
            System.out.println("\033[37mPlease type: "+"\033[32myes/no\033[0m");
            line = scanner.nextLine().toLowerCase();

            while (true){
                if (("yes".equals(line) || "no".equals(line))) {
                    break;
                }
                else{
                    System.out.println("\033[31mWrong input! Please type yes or no for the question!\033[0m");
                    System.out.println(question.getQuestion());
                    line = scanner.nextLine().toLowerCase();
                }
            }
            qa.put(question.getId(), question.getEvaluatedAnswer(line));
        }

    }

    public boolean getAnswerByQuestion(String questionId) {
        boolean answer;
        answer = qa.get(questionId);
        return answer;
    }

    public void evaluate() {

        String factString = "";
        String qaString = "";
        Iterator<Fact> factIterator = factRepository.getIterator();

        while (factIterator.hasNext()) {
            Fact facts = factIterator.next();
            for(String s:qa.keySet()) {
                factString += facts.getValueById(s);
                qaString += getAnswerByQuestion(s);
            }

            if(factString.equals(qaString)) {
                output = facts.getDescription();
                break;
            } else {
                output = "\033[31mGo to Hell\033[0m";
            }
            factString = "";
            qaString = "";
        }
        System.out.println("\033[36mWhat you should try: \033[0m" + output);
    }
}
