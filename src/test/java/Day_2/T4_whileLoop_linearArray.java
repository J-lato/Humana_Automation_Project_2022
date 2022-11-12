package Day_2;

public class T4_whileLoop_linearArray {
    public static void main(String[] args) {
        int[] streetNumber = new int[]{111,222,333,444,555,777};

        //iterate though all street numbers using while loop
        //set the initializer
        int i = 0;

        //set condition for the while loop
        //liner arrays get count using .length command
        while(i < streetNumber.length){
            System.out.println("street number: " + streetNumber[i]);
            // incrementation goes at the end of the while loop
            i++;
        }//end of while loop

    }//end of main
}//end of class

