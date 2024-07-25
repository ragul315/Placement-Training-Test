package Sol4;
/*
4. Place the Alphabets

Given an integer array input1 with N non-repeating elements, generate and return a character array as per the requirement:
1. Size of the character array should be same as that of input1,
2. In the character array,
    alphabet 'a' will be placed in the position of smallest element of input1.
    alphabet 'b' will be placed in the position of second smallest element of input1
    alphabet 'c' will be placed in the position of third smallest element of input1 and so on..
Example-1

input1={10,5,70,1}
output={c,b,d,a}

Explanation:
    1 is the smallest element in the input1, it is in index 3, hence 'a' is placed in index position 3
    5 is the second smallest element in the input1, it is in index 1, hence 'b' is placed in index position 1
    10 is the third smallest element in the input1, it is in index 0, hence 'c' is placed in index position 0
    70 is the fourth smallest element in the input1, it in index 2, hence 'd' is placed in index position 2

Example - 2

input1={4,5,-2,8,99,67}
output={b,c,a,d,f,e}

Explanation:
    -2 is the smallest element in input1, it is in index2, hence 'a' is placed in index position 2
    4 is the second smallest element in input1, it is in index 0, hence 'b' is placed in index position 0
    5 is the third smallest element in input1, it is in index 1, hence 'c' is placed in index position 1
    8 is the fourth smallest element in input1, it is in index 3, hence 'd' is placed in index position 3
    67 is the fifth smallest element in input1, it is in index 5, hence 'e' is placed in index position 5
    99 is the sixth smallest element in input1, it is in index 4, hence 'f' is placed in index position 4.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sol4 {
    public static char[] alphabets(int[] arr) {
        int n = arr.length;
        char[] res = new char[n];
        int[] sarr = Arrays.copyOf(arr, n);
        Arrays.sort(sarr);
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(sarr[i], i);
        }
        for (int i = 0; i < n; i++) {
            int pos = hm.get(arr[i]);
            res[i] = (char) ('a' + pos);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        char[] res = alphabets(arr);
        System.out.println(Arrays.toString(res));
    }
}
