package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        String delimiter = ":,";

        boolean customDelimiterExist = userInput.regionMatches(0, "//", 0, 2)
                && userInput.regionMatches(3, "\\n", 0, 2);

        if (customDelimiterExist) {
            delimiter += userInput.charAt(2);
            System.out.println(delimiter);
            userInput = userInput.substring(5);
        }

        int result = getSum(delimiter, userInput);
        System.out.println(String.format("결과 : %d",result));
        Console.close();
    }

    private static int getSum(String delimiter, String inputBuff) {
        int result = 0;
        StringTokenizer tokens = new StringTokenizer(inputBuff, delimiter);
        while(tokens.hasMoreTokens()) {
            result += Integer.parseInt(tokens.nextToken());
        }

        return result;
    }
}
