package com.codecool;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String line;
        ESProvider movieChoose = new ESProvider(new FactParser(), new RuleParser());

        while (true){
            if (System.getProperty("os.name").equals("windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else if (System.getProperty("os.name").equals("linux")){
                System.out.print("\\033\\143");
            }
            System.out.println("Expert System: Movies!");
            System.out.println("----------------------");
            System.out.println("1. New help");
            System.out.println("2. Exit");
            System.out.println("----------------------\n");
            System.out.println("Please type your choice! (single number)");
            line = scanner.nextLine();

            switch (line){
                case "1":
                    movieChoose.collectAnswers();
                    movieChoose.evaluate();
                    break;

                case "2":
                    System.exit(0);

                default:
                    System.out.println("\nNo such choice! In order to choose please type the number of the menu choice you want to use!");

            }
        }
    }
}
