package com.greatLearning.dsaLab.problemOne;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancingBrackets {
    public static void main(String arg[]) {
        BalancingBrackets balancingBrackets = new BalancingBrackets();
        boolean cond;
        boolean isBalanced;
        //execute at-least once, ask for user consent if he/she wants to continue
        do {
            //initially cond is false, assuming will execute only at once
            cond = false;
            System.out.println("Please enter input string : ");

            //take user i/p and find if its balanced or not
            Scanner scanner = new Scanner(System.in);
            isBalanced = balancingBrackets.isBalancedBracket(scanner.nextLine());

            //if balanced print appropriate message
            if (isBalanced) {
                System.out.println("The entered String has Balanced Brackets");
            } else {
                System.out.println("The entered Strings do not contain Balanced Brackets");
            }

            //ask user if he want to continue or exit
            System.out.println("\n Do you want to continue, please press 'Y' to confirm : ");

            if (scanner.next().equalsIgnoreCase("Y"))
                cond = true;
        } while (cond);
    }

    //function to find if string is balanced or not
    private boolean isBalancedBracket(String str) {
        /*using ArrayQueue to implement Stack, since officially Java Docs recommend it over Stack
        Deques can also be used as LIFO (Last-In-First-Out) stacks. This interface should be used in preference to the legacy Stack class
        */
        Deque<Character> stack = new ArrayDeque<Character>();

        //if i/p string is of 0 length, exit
        if (str.length() == 0) {
            System.out.println("Entered input is empty, exiting,  Bye!!!");
            System.exit(0);
        }

        char ch;
        //loop through the string to calculate balanced or not
        for (int i = 0; i < str.length(); ++i) {
            ch = str.charAt(i);

            /*
            this condition is put skip space if its present in i/p string
            e.g  ( [ [ { } ] ] )  && ([[{}]])
            both of the above i/p strings as accepted as valid i/p, just giving user liberty to enter space for better visibility of i/p :)
             */
            if (ch == ' ')
                continue;

            //main logic to check for balanced or not
            if (ch == '{' || ch == '[' || ch == '(') {
                // if opening bracket push to stack
                stack.push(str.charAt(i));
            }// if closing bracket check for balanced or not
            else if (ch == '}' || ch == ']' || ch == ')') {

                // while poping if stack becomes empty even before comparing with the next character, return false, string is not balanced
                // e.g ([])))
                if (stack.size() == 0)
                    return false;

                switch (ch) {
                    case ']':
                        if (stack.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if (stack.pop() != '{')
                            return false;
                        break;
                    case ')':
                        if (stack.pop() != '(')
                            return false;
                        break;
                }
            }// if found characters other then allowed one, quit with appropriate message
            else {
                System.out.println("Invalid character found, only expecting :- {,},[,],(,) \nQuitting, Bye!!! ");
                System.exit(0);
            }
        }

        // if stack is empty, string is balanced
        return stack.isEmpty();
    }
}
