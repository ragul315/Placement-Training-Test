package Sol3;
/*
3. Given an integer array input1[], function transformCodes returns a String array by following the below steps:
Step A) For each number in the array, do the following and produce a string equivalent:
Let "answer" be an empty string.
Let 'n' be the current element from the array.

Step A1) Check whether the length of n is 6. if so, concatnate "C" to answer, Else concatenate "W" to answer.
Step A2) Check whether n satifies any of the following four conditions:
if n is 0, then concatenate alphabets "Z" to answer,
if n is 1, then concatenate alphabets "O" to answer,
if n is a Prime number, concatenate alphabet "P" to answer,
if n is not a Prime number, concatenate alphabet "N" to answer.
Step A3) Find the sum of all the individual digits in "n", till the sum becomes a "single digit"
Concatenate that single digit sum to the answer.
Step A4) If n is "even number, find (n/2) and concat it to the answer.
Else find (n-1)/2 and concat it to the answer.
Step B) Now we need to accumulate all the answers from step 4 in one String Array and return the same.
Assumptions:
1) All the numbers in the input1 array will be >=2.
2) input1 array will have minimum one element in it.
3) Output array size should be equal to input array size.
4) input and output are case sensitive.

Note:
1) Prime number series is 2,3,5,7,11,13,etc.
2) 0 and 1 are neither prime nor composite.

Function Prototype: String[] transformCodes(int[] input1)
Sample Input/Output-1:
input1[]={12}
output[]={"WN36"}
Explanation: Lets consider the first number from the input1 array.
    Step A1: Initially answer="" and n=12. Length of n is not 6. So, answer="W",
    Step A2: 12 is not a prime number. So, concatenate "N" to the answer. Now answer="WN"
    Step A3: Lets find the sum of digits till it becomes a single digit.
    Step A4: n=12 is an even number. so n/2=6. Concatenate this value to answer.
        Now answer="WN36"
    Finally the resulting string array is ["WN36"]. We need to return this array.

Sample Input/Output-2:
input1[]={123456,1234567}
output[]={"CN361728","WN1617283"}

Explanation: Lets consider the first number from the input1 array.

    Step A1: Initially answer="" and n=123456. Length of n is 6. So, answer="C",
    Step A2: n is not a prime number. So, concatenate "N" to the answer. Now answer="CN"
    Step A3: Lets find the sum of digits till it becomes a single digit.
        1+2+3+4+5+6=21 Which is a two digit number. So, let us find the sum of the digit in 21.
    Step A4: n=123456 is an even number. so n/2=61728. Concatenate this value to answer.
        Answer for the first number is "CN361728".
Lets consider the second number from the input1 array.

    Step A1: Initially answer="" and n=1234567. Length of n is 7. So, answer="W",
    Step A2: n is not a prime number. So, concatenate "N" to the answer. Now answer="WN"
    Step A3: Lets find the sum of digits till it becomes a single digit.
        1+2+3+4+5+6+7=28 Which is a two digit number. So, let us find the sum of the digit in 28.
    Step A4: n=1234567 is an odd number. so (n-1)/2=617283. Concatenate this value to answer.
        Answer for the second number is "WN1617283".
Finally, We need to accumulate result for each of the input number. Hence, the resulting string array is {"CN361728","WN1617283"}. We need to return this array.
*

*/

import java.util.Scanner;

public class Sol3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        String ans="";
        String res = ""+n;
        if(res.length()==6){
            ans+="C";
        }
        else{
            ans+="W";
        }
        if (n==0) {
            ans+="Z";
        }else if(n==1){
            ans+="O";
        }
        else if(isPrime(n)){
            ans+="P";
        }
        else{
            ans+="N";
        }
        ans+=sumDig(n);
        if(n%2==0){
            ans+=(n/2);
        }
        else{
            ans+=((n-1)/2);
        }
        System.out.println(ans);

        
    }
    public static boolean isPrime(long n){
        for (long i = 2; i < n/2; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static long sumDig(long n){
        while(n>9){
            int sum=0;
            while (n!=0) {
                sum+=n%10;
                n=n/10;
            }
            n=sum;
        }
        return n;
    }
}
