package Day_2;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {
    public static void main(String[] args) {

        //declare and define arraylist for zipcode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("first");
        zipCode.add("3r112");
        zipCode.add("415553");
        zipCode.add("f32452");
        zipCode.add("final");

        //call for loop to print out all values from the arraylist
        for(int i=0; i < zipCode.size();){
            //print out each zipcode automatically
            System.out.println(i +"- Zipcode: " + zipCode.get(i));
            i++;
           // System.out.println("Zip code: " + zipCode.get(i));
        }//end for loop

    }//end of main
}
