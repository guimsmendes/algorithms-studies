package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

class BalancedBrackets {
    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return "NO";
            } else if ((stack.peek() == '[' && ch == ']') ||
                    (stack.peek() == '{' && ch == '}') ||
                    (stack.peek() == '(' && ch == ')')) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty() ? "YES" : "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = isBalanced(s);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

