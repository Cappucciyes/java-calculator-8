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
            userInput = userInput.substring(5);
        }

        int result = getSum(delimiter, userInput);
        System.out.println(String.format("결과 : %d",result));
        Console.close();
    }

    private static int getSum(String delimiter, String inputBuff) {
        int result = 0;

        if (inputBuff.regionMatches(0, "//", 0, 2) && inputBuff.contains("\\n"))
            throw new IllegalArgumentException("커스텀 구분자 문법 미준수");

        StringTokenizer tokens = new StringTokenizer(inputBuff, delimiter);
        while(tokens.hasMoreTokens()) {
            int toAdd;
            try {
                toAdd = Integer.parseInt(tokens.nextToken());
            } catch (Exception e) {
                throw new IllegalArgumentException("기존 구분자 및 커스텀 구분자 외 다른 문자 사용");
            }
            if (toAdd <= 0)
                throw new IllegalArgumentException("양수가 아닌 숫자 입력");
            result += toAdd;
        }
        return result;
    }
}
