/*
 * Driver
 * 
 * Version 1.0
 *
 * 04/17/2024
 * 
 * Copyright notice - Moosems
 */

package Calculator;

import java.util.Scanner;

class Driver {

    public static Boolean yesNoDecision(Scanner myScanner, String question) {
        System.out.println(question);
        String decision = myScanner.nextLine();
        switch (decision) {
            case "yes" -> {
                return true;
            }
            case "no" -> {
                return false;
            }
            default -> {
                throw new Error("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        HistoryManager.createHistoryFile();
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to my simple calculator!");



        Boolean viewHistory = Driver.yesNoDecision(
            myScanner,
            "Would you like to view history (yes/no)?"
        );
        if (viewHistory) {
            HistoryManager.listHistory();
            Boolean clearHistory = Driver.yesNoDecision(
                myScanner,
                "Clear History (yes/no)?"
            );
            if (clearHistory) {
                HistoryManager.clearHistory();
            }
            Boolean exitDecision = Driver.yesNoDecision(
                myScanner,
                "Exit (yes/no)?"
            );
            if (exitDecision) {
                Integer goodExit = 0;
                System.exit(goodExit);
            }
        }

        float firstNum = Calculator.getNum(myScanner, "first");
        float secondNum = Calculator.getNum(myScanner, "second");
        CustomTuple results = Calculator.mainCalculations(
            myScanner,
            firstNum,
            secondNum
        );

        results.print_data();
        HistoryManager.appendLine(results);
    }
}