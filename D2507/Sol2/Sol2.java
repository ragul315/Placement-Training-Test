package Sol2;
/*
2. Encoding Three Strings: Anand was assigned the task of coming up with an encoding mechanism for any given three strings. He has come up with the below plan

STEP ONE: Given any three strings, break each string into 3 parts each,
For Example- If three strings are as below -
input1="John"
input2="Johny"
input3="Janardhan"

"John" should be split into "J","oh","n" as the FRONT, MIDDLE and END parts respectively.
"Johny" should be split into "Jo","h","ny" as the FRONT, MIDDLE and END parts respectively.
"Janardhan" should be split into "Jan","ard","han" as the FRONT, MIDDLE and END parts respectively.
i.e. if the no of characters in the string are in the multiples of 3, then each split part will contain equal no of characters. as seen in the example of "Janardhan".
If the no. of characters in the string are NOT in multiples of 3, then the middle part will get the extra character, as seen in the example of "John".
If the no. of characters in the string are NOT in multiples of 3, and if there are two characters more than multiple of 3, then the FRONT and END parts will get one extra character each, as seen in the example of "Johny"

STEP TWO: Concatenate(join) the FRONT, MIDDLE and END parts of the strings as per the below specified concatenation-rule to form three output strings.
Output1=FRONT part of input1+MIDDLE part of input2+END part of input3
Output2=MIDDLE part of input1+END part of input2+FRONT part of input3
Output3=END part of input1+FRONT part of input2+MIDDLE part of input3
For Example, for the above specified example input strings,
Output1="J"+"h"+"han"="Jhhan"
Output2="oh"+"ny"+"Jan"="ohnyJan"
Output3="n"+"Jo"+"ard"="nJoard"

STEP THREE: Process the resulting output strings based on the output Processing rule.
After the above two steps, we will now have three output strings. Further processing is required only for the third output string as per below rule-"Toggle the case of each character in the string", i.e. in the third output string, all lower-case characters should be made upper-case and vice versa.
For Example, for the above example strings, Output3 is "nJoard", so after applying the toggle rule, Output3 should become "NjOARD".

Final result- The three output strings after applying the above three steps is the final result. i.e. for the above example.
Output1="Jhhan"
Output2="ohnyJan"
Output3="NjOARD"

Anand approaches you to help him write a program that would do the above mentioned processing on any given three strings and generate the resulting three output strings.
The given functions three parameters, input1,input2,input3 represent the three given input strings and return a "Result" object/struct with the three output strings.
*/

import java.util.Scanner;

public class Sol2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = { in.nextLine(), in.nextLine(), in.nextLine() };
        String[] f = new String[3];
        String[] m = new String[3];
        String[] e = new String[3];
        for (int i = 0; i < 3; i++) {
            int n = s[i].length();
            switch (n % 3) {
                case 0:
                    f[i] = s[i].substring(0, n / 3);
                    m[i] = s[i].substring(n / 3, 2 * (n / 3));
                    e[i] = s[i].substring(2 * (n / 3), n);
                    break;
                case 1:
                    f[i] = s[i].substring(0, n / 3);
                    m[i] = s[i].substring(n / 3, 2 * (n / 3) + 1);
                    e[i] = s[i].substring(2 * (n / 3) + 1, n);
                    break;
                case 2:
                    f[i] = s[i].substring(0, n / 3 + 1);
                    m[i] = s[i].substring(n / 3 + 1, 2 * (n / 3) + 1);
                    e[i] = s[i].substring(2 * (n / 3) + 1, n);
                    break;
            }
        }
        String out1 = f[0] + m[1] + e[2];
        String out2 = m[0] + e[1] + f[2];
        String out3 = e[0] + f[1] + m[2];
        String s1 = "";
        for (int i = 0; i < out3.length(); i++) {
            if (Character.isUpperCase(out3.charAt(i)))
                s1 = s1 + Character.toLowerCase(out3.charAt(i));
            else
                s1 = s1 + Character.toUpperCase(out3.charAt(i));
        }
        out3 = s1;
        System.out.println("Output1 :" + out1 + "\nOutput2 :" + out2 + "\nOutput3 :" + out3);
    }
}
