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

            System.out.println("\033[37mExpert System: Movies!\033[0m");
            System.out.println("----------------------");
            System.out.println("\033[36m1. START\033[0m");
            System.out.println("\033[36m2. Show last suggestion\033[0m");
            System.out.println("\033[36m3. Exit\033[0m");
            System.out.println("----------------------\n");
            System.out.println("\033[37mPlease type your choice!\033[0m"+"\033[32m(single number)\033[0m");
            line = scanner.nextLine();

            switch (line){
                case "1":
                    movieChoose.collectAnswers();
                    movieChoose.evaluate();
                    System.out.println();
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("\n\n\n\n");
                    break;

                case "2":
                    if (movieChoose.output.equals("")){
                        System.out.println("\n\n\033[31mNothing here mate! Get a new one first ;)\033[0m\n\n");
                    }else {
                        System.out.println("\n\n\033[37mOur last suggestion to you was: \033[0m" + movieChoose.output + "\n\n");
                    }
                    TimeUnit.SECONDS.sleep(3);
                    break;

                case "3":
                    System.exit(0);

                default:
                    System.out.println("\n\033[31mNo such choice! In order to choose please type the number of the menu choice you want to use!\033[0m");

            }
        }
    }
}
