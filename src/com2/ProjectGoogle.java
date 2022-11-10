package com2;

import java.util.Scanner;
import java.util.Stack;

public class ProjectGoogle {

    static Stack<String> prevLinks = new Stack<>();
    static Stack<String> nextLinks = new Stack<>();
    static String currentLink = " google ";

    public static void main(String[] args) {

        System.out.println("\n***** Welcome to brouser *****\n");
        while (true){
        Scanner scanner = new Scanner(System.in);
            if(currentLink != null){
                System.out.println("Siz "+ currentLink + " platformadasiz!!!");
            }else {
                System.out.println("Siz hech qanaqa linkga kirmadingiz! sorry morry!!! ");
            }
            System.out.println("Choose menu : " +
                    "1 - prev, 2 - open, 3 - next, 0 - exit");
            try {
                int command = scanner.nextInt();
                switch (command) {
                    case 1:  showPrevLink(); break;
                    case 2:  openNewLink();  break;
                    case 3:  showNextLink(); break;
                    case 4:  System.out.println("See you soon!!!"); return;
                    default: System.out.println("Error comand");
                }
            }catch (Exception e){ System.out.println("Error comand!");
            scanner = new Scanner(System.in);
            }

        }
    }

    private static void openNewLink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter link");
        String link = scanner.next();
        if(currentLink != null ){
            prevLinks.push(currentLink);
            nextLinks.clear();
        }
        currentLink = link;
    }
    private static void showNextLink() {
        if(nextLinks.size()>0){
            prevLinks.push(currentLink);
            currentLink = nextLinks.pop();
        }else {
            System.out.println("No any next link");
        }
    }
    private static void showPrevLink() {
        if(prevLinks.size()>0){
          nextLinks.push(currentLink);
          currentLink = prevLinks.pop();
        }else {
            System.out.println("No any link to prev");
        }


    }


    }

