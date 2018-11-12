package WJ.factory;

public class InstruGeneration {

    public static String disassemblyTransfer(String input) {

        String s = null;
        if (input.charAt(0) == '1') {
            s = category2Transfer(input);
        } else {
            category1Transfer(input);
        }
        return s;
    }

    private static void category1Transfer(String input) {

        if (input.matches("0{6}[0-9]{5}0{10}[0-9]{5}001000")) {
            System.out.println("hhh");
        }
    }

    //register-immediate model
    private static String category2Transfer(String input) {

        String result;
        String instruction = instructionCategory(input);
        String[] register = whichRegister(input);
        String immediate = whichImmediate(input);
        if ("LW".equals(instruction) || "SW".equals(instruction)) {
            result = generateAnswer1(instruction, register, immediate);
        } else {
            result = generateAnswer2(instruction, register, immediate);
        }
        return result;
    }

    private static String generateAnswer1(String instruction, String[] register, String immediate) {

        return instruction + " " + register[0] + ", " + immediate + "(" + register[1] + ")";
    }

    private static String generateAnswer2(String instruction, String[] register, String immediate) {

        return instruction + " " + register[0] + "," + register[1] + ", #" + immediate;
    }

    private static String whichImmediate(String input) {
        String substring = input.substring(21, 32);
        int num = Integer.valueOf(substring, 2);
        return String.valueOf(num);

    }

    private static String[] whichRegister(String input) {

        String substring1 = input.substring(11, 16);
        String substring2 = input.substring(6, 11);
        int num1 = Integer.valueOf(substring1, 2);
        int num2 = Integer.valueOf(substring2, 2);
        String register1 = "R" + num1;
        String register2 = "R" + num2;
        return new String[]{register1, register2};
    }

    private static String instructionCategory(String input) {
        String instructions = null;
        String substring = input.substring(1, 6);
        switch (substring) {
            case "10000":
                instructions = "ADD";
                break;
            case "10001":
                instructions = "SUB";
                break;
            case "00001":
                instructions = "MUL";
                break;
            case "10010":
                instructions = "AND";
                break;
            case "10011":
                instructions = "NOR";
                break;
            case "10101":
                instructions = "SLT";
                break;
            case "01011":
                instructions = "SW";
                break;
            case "00011":
                instructions = "LW";
                break;

        }
        return instructions;
    }
}
