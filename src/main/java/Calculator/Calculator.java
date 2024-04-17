/*
 * Calculator
 * 
 * Version 1.0
 *
 * 04/17/2024
 * 
 * Copyright notice - Moosems
 */

package Calculator;

import java.util.Scanner;

class Calculator{

    public static float getNum(Scanner myScanner, String prefix) {
        System.out.println(
            String.format("Please insert the %s number as a float:", prefix)
        );
        String numPreFloatParse = myScanner.nextLine();
        float returnNum;
        try {
            returnNum = Float.parseFloat(numPreFloatParse);
        } catch (Exception e) {
            throw new Error("Number is invalid!");
        }
        return returnNum;
    }

    public static CustomTuple mainCalculations(
        Scanner myScanner,
        float firstNum,
        float secondNum
    ){
        System.out.println("Please insert the operator (+. -, *, /):");
        String operator = myScanner.nextLine();

        String mathematicalOutputType;
        float outputNum;
        switch (operator) {
            case "/" -> {
                mathematicalOutputType = "quotient";
                if (secondNum == 0) {
                    throw new Error("Cannot divide by zero!");
                }
                outputNum = firstNum/secondNum;
            }
            case "*" -> {
                mathematicalOutputType = "product";
                outputNum = firstNum*secondNum;
            }
            case "+" -> {
                mathematicalOutputType = "sum";
                outputNum = firstNum+secondNum;
            }
            case "-" -> {
                mathematicalOutputType = "difference";
                outputNum = firstNum-secondNum;
            }
            default -> {
                throw new Error("No good operator provided");
            }
        };

        return new CustomTuple(firstNum, secondNum, outputNum, mathematicalOutputType);
    }
}