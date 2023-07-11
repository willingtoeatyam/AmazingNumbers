package numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static boolean buzz, duck, even, palindromic, gapful, spy, square, sunny, jumping, happy;
    public static void main(String[] args) {
//        write your code here
        System.out.println("Welcome to Amazing numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("* the first parameter represents a starting number;");
        System.out.println("* the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        boolean stop = false;

        while (!stop){
            System.out.println("Enter a request:");
            Scanner scanner = new Scanner(System.in);
            String data = scanner.nextLine();
            String dataArr[] = data.split(" ");
            long number = Long.parseLong(dataArr[0]);
            if (number < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (number == 0){
                System.out.println("Goodbye");
                stop = true;
            } else {
                options(dataArr);
            }
        }
    }

    public static void singleAmazing(long number){
        isBuzz(number);
        isEven(number);
        isDuck(number);
        isPalindromic(number);
        isGapful(number);
        isSpy(number);
        isSunny(number);
        isSquare(number);
        isJumping(number);
        isHappy(number);

        System.out.println("Properties of " + number);
        System.out.println("buzz: " + buzz);
        System.out.println("duck: " + duck);
        System.out.println("palindromic: " + palindromic);
        System.out.println("gapful: " + gapful);
        System.out.println("spy: "+ spy);
        System.out.println("square: " + square);
        System.out.println("sunny: " + sunny);
        System.out.println("jumping: " + jumping);
        System.out.println("happy: " + happy);
        System.out.println("sad: " + !happy);
        System.out.println("even: " + even);
        System.out.println("odd: " + !even);
    }
    public static void formatAmazing(long number){
        isBuzz(number);
        isEven(number);
        isDuck(number);
        isPalindromic(number);
        isGapful(number);
        isSpy(number);
        isSunny(number);
        isSquare(number);
        isJumping(number);
        isHappy(number);

        System.out.println(number + " is " + ((even)? "even":"odd") + ((buzz)? ", buzz": "") +
                ((duck)?", duck":"") + ((gapful)?", gapful": "") + ((palindromic)?", palindromic":"") + ((spy)?", spy":"") +
                ((sunny)?", sunny":"") + ((square)?", square":"") + ((jumping)?", jumping":"") + ((happy)?", happy":", sad"));
    }
    public static void multipleAmazing(long number, int range){
        for (long i = number; i < number + range; i++){
            formatAmazing(i);
        }
    }
    public static void multipleAmazing(long number, int range, String filter) {
        long[] valid = new long[range];
        int p = 0;
        for (long i = number; valid[range-1] == 0; i++) {
            if (filter(filter,i)) {
                valid[p] = i;
                p++;
            }
        }
        for (long x: valid) {
            formatAmazing(x);
        }
    }
    public static void multipleAmazing(long number, int range, String[] properties) {
        long[] valid = new long[range];
        boolean check = false;
        int p = 0;
        int num = properties.length;
        for (long i = number; valid[range-1] == 0; i++){
            for (int x = 0; x < properties.length; x++) {
                if (filter(properties[x], i)) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
            if (check) {
                valid[p++] = i;
            }
        }
        for (long x: valid) {
            formatAmazing(x);
        }
    }

    public static void isEven(long number){
        if (number%2 == 0) {
            even = true;
        }else {
            even = false;
        }
    }
    public static void isBuzz(long number){
        if (number%7 == 0){
            buzz =  true;
        } else {
            buzz = false;
        }

        if (number%10 == 7){
            buzz = true;
        }
    }
    public static void isDuck(long number){
        String no = Long.toString(number);
        char[] num = no.toCharArray();

        for (char x: num){
            if (x == '0'){
                duck = true;
                break;
            } else {
                duck = false;
            }
        }
    }
    public static void isPalindromic(long number) {
        String x = Long.toString(number);
        char[] xChar = x.toCharArray();
        char[] yChar =  new char[xChar.length];

        for (int i = 0; i < xChar.length; i++) {
            yChar[i] = xChar[xChar.length - 1- i];
        }

        String y = new String(yChar);

        if (x.equals(y)) {
            palindromic = true;
        } else {
            palindromic = false;
        }
    }
    public static void isGapful(long number) {
        String num = Long.toString(number);
        char[] charArray = num.toCharArray();

        if (charArray.length > 2) {
            char a = charArray[0];
            char b = charArray[charArray.length - 1];

            String ab =  a +"" + b;
            int xy = Integer.parseInt(ab);

            if (number % xy == 0){
                gapful = true;
            }else {
                gapful = false;
            }

        } else {
            gapful = false;
        }
    }
    public static void isSpy(long number) {
        String num = Long.toString(number);
        char[] charArray = num.toCharArray();
        long sum = 0, prod = 1;
        for (char c: charArray){
            long numb = Long.parseLong(c+"");
            sum += numb;
            prod *= numb;
        }

        if (sum == prod){
            spy = true;
        } else {
            spy = false;
        }
    }
    public static void isSunny(long number) {
        long sqr = number +  1;
        isSquare(sqr);
        if (square){
            sunny = true;
        } else {
            sunny = false;
        }
    }
    public static void isSquare (long number) {
        double root = Math.sqrt(number);
        if (root == (int)root) {
            square = true;
        } else {
            square = false;
        }
    }
    public static void isJumping (long number) {
        String num = Long.toString(number);
        char[] charArray = num.toCharArray();
        if(charArray.length == 1){
            jumping = true;
        }
        for (int i = 0; i < charArray.length - 1; i++){
            long x = Long.parseLong(charArray[i]+"");
            long y = Long.parseLong(charArray[i + 1]+"");
            if (Math.abs(x-y) == 1) {
                jumping = true;
            } else {
                jumping = false;
                break;
            }
        }
    }
    public static void isHappy (long number){
        long h = happy(number);
        while (h != 1 && h != number && h != 4) {
            h = happy(h);
        }
        if (h == 1){
            happy = true;
        } else {
            happy = false;
        }
    }
    public static long happy (long number) {
        String num = Long.toString(number);
        char[] charArray = num.toCharArray();
        long prod = 0;

        for (char c: charArray){
            long numb = Long.parseLong(c+"");
            prod += (numb * numb);
        }

//        if (prod != 1 && prod != number){
//             prod = happy(prod);
//        }

        return prod;
    }
    public static void options(String[] dataArr){
        long number = Long.parseLong(dataArr[0]);
        int range;
        switch (dataArr.length) {
            case 1:
                singleAmazing(number);
                break;
            case 2:
                range = Integer.parseInt(dataArr[dataArr.length-1]);
                if (range < 0){
                    System.out.println("The second parameter should be a natural number.");
                } else{
                    multipleAmazing(number, range);
                }
                break;
            case 3:
                if (validateInput(dataArr[2])){
                    System.out.println("The property "+dataArr[2]+" is wrong");
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                } else {
                    range = Integer.parseInt(dataArr[1]);
                    multipleAmazing(number, range, dataArr[2]);
                }
                break;
            default:
                String [] props = new String[dataArr.length-2];
                int p = 0;
                for (int i = 2; i <dataArr.length; i++){
                    props[p++] = dataArr[i];
                }
                if (validateInput(props)){
                    if (validateInput(dataArr[2]) && validateInput(dataArr[3])) {
                        System.out.println("The properties "+dataArr[2]+", "+dataArr[3]+" are wrong");
                    }else{
                        System.out.println("The property "+isValidateInput(props) + " is wrong");
                    }
                    System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                } else {
                    if (dataArr[2].equalsIgnoreCase(dataArr[3])) {
                        range = Integer.parseInt(dataArr[1]);
                        multipleAmazing(number, range, props);
                    } else if (validateMutual(props)){
                        //error. mutually exclusive
                        System.out.println("The request contains mutually exclusive properties: " + dataArr[2] + ", " + dataArr[3]);
                        System.out.println("There are no numbers with these properties.");
                    } else {
                        //actually work
                        range = Integer.parseInt(dataArr[1]);
                        multipleAmazing(number, range, props);
                    }
                }
                break;
        }
    }
    public static boolean validateInput(String input) {
        return (!(input.equalsIgnoreCase("even")) &&
                !(input.equalsIgnoreCase("odd")) &&
                !(input.equalsIgnoreCase("buzz")) &&
                !(input.equalsIgnoreCase("duck")) &&
                !(input.equalsIgnoreCase("palindromic")) &&
                !(input.equalsIgnoreCase("gapful")) &&
                !(input.equalsIgnoreCase("spy")) &&
                !(input.equalsIgnoreCase("sunny")) &&
                !(input.equalsIgnoreCase("square")) &&
                !(input.equalsIgnoreCase("jumping")) &&
                !(input.equalsIgnoreCase("happy")) &&
                !(input.equalsIgnoreCase("sad")) &&
                 !(input.equalsIgnoreCase("-even")) &&
                !(input.equalsIgnoreCase("-odd")) &&
                !(input.equalsIgnoreCase("-buzz")) &&
                !(input.equalsIgnoreCase("-duck")) &&
                !(input.equalsIgnoreCase("-palindromic")) &&
                !(input.equalsIgnoreCase("-gapful")) &&
                !(input.equalsIgnoreCase("-spy")) &&
                !(input.equalsIgnoreCase("-sunny")) &&
                !(input.equalsIgnoreCase("-square")) &&
                !(input.equalsIgnoreCase("-jumping")) &&
                !(input.equalsIgnoreCase("-happy")) &&
                !(input.equalsIgnoreCase("-sad")));
    }
    public static boolean validateInput(String[] inpArray) {
        boolean invalid = false;
        for (String input: inpArray) {
            if (validateInput(input)){
                invalid = true;
                break;
            }
        }
        return invalid;
    }
    public static String isValidateInput(String[] inpArray) {
        String prop = "false";
        for (String input: inpArray) {
            if (validateInput(input)){
                prop = input;
            }
        }
        return prop;
    }
    public static boolean validateMutual(String[] properties) {
        boolean flag = false;
        String[] mutual1 = {"even", "odd"}, mutual2 = {"duck", "spy"},  mutual3 = {"sunny", "square"};
        String[] mutual4 = {"-even", "-odd"}, mutual5 = {"-duck", "-spy"}, mutual6 = {"happy", "sad"};
        String[] mutual7 = {"-happy", "-sad"}, mutual8 = {"odd", "-odd"},  mutual9 = {"-happy", "happy"};
        String[] mutual10 = {"even", "-even"}, mutual11 = {"buzz", "-buzz"}, mutual12 = {"duck", "-duck"};
        String[] mutual13 = {"sad", "-sad"}, mutual14 = {"spy", "-spy"}, mutual15 = {"gapful", "-gapful"};
        String[] mutual16 = {"palindromic", "-palindromic"}, mutual17 = {"sunny", "-sunny"}, mutual18 = {"square", "-square"};
        String[] mutual19 = {"jumping", "-jumping"};


        String[] props = new String[properties.length];
        for (int i =0; i < props.length; i++){
            props[i] = properties[i].toLowerCase();
        }

        if (Arrays.asList(props).containsAll(Arrays.asList(mutual1)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual2)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual3)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual4)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual5)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual6)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual7)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual8)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual9)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual10)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual11)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual12)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual13)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual14)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual15)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual16)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual17)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual18)) ||
            Arrays.asList(props).containsAll(Arrays.asList(mutual19))) {
            flag =  true;
        }
        return flag;
    }
    public static boolean filter(String filter, long number) {
        boolean valid = false;
        filter = filter.toLowerCase();
        switch(filter){
            case "even", "-odd":
                isEven(number);
                valid = even;
                break;
            case "odd","-even":
                isEven(number);
                valid = !even;
                break;
            case "buzz":
                isBuzz(number);
                valid = buzz;
                break;
            case "-buzz":
                isBuzz(number);
                valid = !buzz;
                break;
            case "duck":
                isDuck(number);
                valid = duck;
                break;
            case "-duck":
                isDuck(number);
                valid = !duck;
                break;
            case "palindromic":
                isPalindromic(number);
                valid = palindromic;
                break;
            case "-palindromic":
                isPalindromic(number);
                valid = !palindromic;
                break;
            case "gapful":
                isGapful(number);
                valid = gapful;
                break;
            case "-gapful":
                isGapful(number);
                valid = !gapful;
                break;
            case "spy":
                isSpy(number);
                valid = spy;
                break;
            case "-spy":
                isSpy(number);
                valid = !spy;
                break;
            case "sunny":
                isSunny(number);
                valid = sunny;
                break;
            case "-sunny":
                isSunny(number);
                valid = !sunny;
                break;
            case "square":
                isSquare(number);
                valid = square;
                break;
            case "-square":
                isSquare(number);
                valid = !square;
                break;
            case "jumping":
                isJumping(number);
                valid = jumping;
                break;
            case "-jumping":
                isJumping(number);
                valid = !jumping;
                break;
            case "happy","-sad":
                isHappy(number);
                valid = happy;
                break;
            case "sad","-happy":
                isHappy(number);
                valid = !happy;
                break;
        }
        return valid;
    }
}
