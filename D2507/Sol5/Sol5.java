package Sol5;
/*
5. Find sum of all prime numbers in the array, except the smallest prime number:
Madhav has assigned the task of finding the sum of all prime number in the array, except the smallest prime number in the array. Madhav approaches you to help him do this by writing a program.
Given an array of numbers, you are expected to find the sum of all prime numbers in the given array. You must however exclude the smallest prime number while performing this addition.

For Example:
if input1={10,41,18,50,43,31,29,25,59,96,67} representing the given array and input2=11 representing the number of elements in the array, then the expected output is 241, which is the sum of all prime numbers in this array except the smallest prime number 29.

Explanation: The prime number in this array are 41,43,31,29,59 and 67.
The smallest prime number in this array is 29.
So, let us leave out 29 and add all the other prime numbers to get the output. Therefore, output=41+43+31+59+67=241.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sol5 {
    public static boolean isPrime(long n){
        for (long i = 2; i < n/2; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> prim = new ArrayList<>();
        for (int num : arr) {
            if (isPrime(num)) {
                prim.add(num);
            }
        }
       
        int sp = Integer.MAX_VALUE;
        for (int p : prim) {
            if (p < sp) {
                sp = p;
            }
        }
        int sum = 0;
        for (int p : prim) {
            if (p != sp) {
                sum += p;
            }
        }
        System.out.println("Sum of all p numbers except the smallest p: " + sum);
    }
}
