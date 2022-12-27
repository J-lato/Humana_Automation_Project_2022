package Practice;

import java.util.ArrayList;

public class forLoopSortingList {

    public static void main(String[] args) {
        //create an ArrayList and iterate through the list from highest to lowest number
        //only print odd numbers

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(12);
        nums.add(25);
        nums.add(30);
        nums.add(3);
        nums.add(123);
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = 0; j < nums.size() - 1; j++) {
                //create conditional statement that will sort numbers
                if (!(nums.get(j) < nums.get(j + 1))) {
                    int a = nums.get(j);
                    nums.set(j, nums.get(j + 1));
                    nums.set(j + 1, a);
                }
            }
        }

        for (int b : nums) {
            if (!(b % 2 == 0)) {
                System.out.println("The num is: " + b);
            }
        }

    }

}

