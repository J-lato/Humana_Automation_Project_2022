package Practice;

import java.util.ArrayList;

public class practicals {
    public static void main(String[] args) {


        //print 5-1
        for (int i= 5; i>=1;i--) {
            System.out.println("The number is: " + i);
        }

        //Write a program that returns “fizz” if the number is a multiple of 3,
        // return buzz if it’s multiple of 5, return “fizzbuzz” if the number is divisible by both 3 and 5.
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(9);
        nums.add(15);
        nums.add(30);
        nums.add(25);

        for(int i=0; i< nums.size();i++) {
           if ((nums.get(i)%3==0)&(nums.get(i)%5!=0)){
               System.out.println(nums.get(i)+" fizz");
           }
           else if ((nums.get(i)%5==0)&(nums.get(i)%3!=0)){
               System.out.println(nums.get(i)+" buzz");
           }
           else if((nums.get(i)%3==0)&(nums.get(i)%5==0)){
               System.out.println(nums.get(i)+" fizzbuzz");

           }
            }
        }
        }



