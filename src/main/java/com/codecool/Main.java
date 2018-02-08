package com.codecool;


public class Main {

    public static void main(String[] args) {

        ESProvider movieChoose = new ESProvider(new FactParser(), new RuleParser());

        movieChoose.collectAnswers();

        movieChoose.evaluate();
    }
}
