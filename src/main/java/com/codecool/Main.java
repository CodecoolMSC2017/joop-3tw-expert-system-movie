package com.codecool;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        Scanner scanner = new Scanner(System.in);
        String line;
        ESProvider movieChoose = new ESProvider(new FactParser(), new RuleParser());

        while (true){
            if (System.getProperty("os.name").equals("windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else if (System.getProperty("os.name").equals("linux")){
                System.out.print(ANSI_CLS + ANSI_HOME);
                System.out.flush();
            }

            System.out.println("Expert System: Movies!");
            System.out.println("----------------------");
            System.out.println("1. START");
            System.out.println("2. Show last suggestion");
            System.out.println("3. Exit");
            System.out.println("----------------------\n");
            System.out.println("Please type your choice! (single number)");
            line = scanner.nextLine();

            switch (line){
                case "1":
                    movieChoose.collectAnswers();
                    movieChoose.evaluate();
                    System.out.println();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("\n\n\n\n");
                    break;

                case "2":
                    if (movieChoose.output.equals("")){
                        System.out.println("\n\nNothing here mate! Get a new one first ;)\n\n");
                    }else {
                        System.out.println("\n\nOur last suggestion to you was: " + movieChoose.output + "\n\n");
                    }
                    TimeUnit.SECONDS.sleep(3);
                    break;

                case "3":
                    System.exit(0);

                default:
                    System.out.println("\nNo such choice! In order to choose please type the number of the menu choice you want to use!");

            }
        }
    }
}
