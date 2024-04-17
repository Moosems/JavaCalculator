/*
 * CustomTuple
 * 
 * Version 1.0
 *
 * 04/17/2024
 * 
 * Copyright notice - Moosems
 */

package Calculator;

class CustomTuple {
    float firstNum;
    float secondNum;
    float outputNum;
    String mathematicalOutputType;

    public CustomTuple (
        float firstNum,
        float secondNum,
        float outputNum,
        String mathematicalOutputType
    ) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.outputNum = outputNum;
        this.mathematicalOutputType = mathematicalOutputType;
    }

    public String to_string() {
        return String.format(
            "%f, %f, %f, %s\n",
            firstNum,
            secondNum,
            outputNum,
            mathematicalOutputType
        );
    }

    public static CustomTuple from_string(String historyLine) {
        historyLine = historyLine.trim();
        String[] data = historyLine.split(", ", 4);
        return new CustomTuple(
            Float.parseFloat(data[0]),
            Float.parseFloat(data[1]),
            Float.parseFloat(data[2]),
            data[3]
        );
    }

    public void print_data() {
        System.out.println(
            String.format(
                "The %s of %f and %f is %f",
                this.mathematicalOutputType,
                this.firstNum,
                this.secondNum,
                this.outputNum
            )
        );
    }
}