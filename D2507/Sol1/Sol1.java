package Sol1;
/*
1. Fix the Formula

Kely has been tricked by her brother to answer a question with a number. She is preplexed. Her is the question "Fo=23+he3*like2+" It took time for her to understand. 
Now she wants to automate it with a program so that any time her brother comes with such tricky String she could answer with lesser efforts.

Here is what we have to do, seperate the math operators (+,*,+) and digits.
Like in the above string you can see the operators(+,*,+) and digits (2,3,3,2).
Rest all the characters are ignored.

Now arrange the digits and operators in the order of the appearance to get the correct result.
2+3*3+2 to be solved as
(2+3)=5
Then,(5*3)=15
Then, (15+2)=17
So for the given string Fo+23the3*like2+ final answer is 17

Help Kely by writing a program to solve the above given problem.
Prototype: public int fixTheFormula(String input1)

Assumptions
    1. Numbers present in the String are always considered as single digits (0-9)
    2. Only operators used in the String are (+,-,*,/)
    3. Always we will have length+1 numbers to operators(in the above example 3 operators and 4 numbers).

Sample Input/Output-1:
input1=we8+you2-7to/*32
output=2
Explanation: Here the operators are [+,-,/,*] and the numbers are [8,2,7,3,2]
Thus we would be getiing 8+2 =>10-=>3/3=>1*2=>2
Final answer is  2.

Sample Input/Output-2:
input1=i*-t5s-t8h1e4birds
output=35
Explanation Here the operators are [*,-,-] and the numbers are [5,8,1,4]
Thus we would be getting 5*8=>40-1=>39-4=>35
Final answer is 35.
 */

import java.util.Scanner;

public class Sol1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replaceAll("[^0-9+*-/]", "");
        String[] arr = s.replaceAll("[0-9]", "").split("");
        String[] n = s.replaceAll("[^0-9]", "").split("");
        int j = 0;
        int sum = Integer.parseInt(n[j++]);
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "+":
                    sum += Integer.parseInt(n[j++]);
                    break;
                case "-":
                    sum -= Integer.parseInt(n[j++]);

                    break;
                case "*":
                    sum *= Integer.parseInt(n[j++]);

                    break;
                case "/":
                    sum /= Integer.parseInt(n[j++]);
                    break;

                default:
                    break;
            }
        }
        System.out.println(sum);
    }

}