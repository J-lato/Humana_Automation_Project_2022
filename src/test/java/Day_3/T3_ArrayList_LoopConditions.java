package Day_3;

import java.util.ArrayList;

public class T3_ArrayList_LoopConditions {
    public static void main(String[] args) {

        //create ArrayList countries of datatype String and add elements to countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Bangyladeshy");
        countries.add("Mexicocoa");
        countries.add("Ausssytralia");
        countries.add("Camarooney");

        //create for loop, declare integer i, and iterate
        for (int i = 0; i < countries.size(); i++) {

            if (countries.get(i) =="Mexicocoa"){
                System.out.println("yea babyy");}
            else if(countries.get(i) == "Camarooney"){
                System.out.println("Okayyy");}

            //begin dynamic conditional statement
            if (countries.get(i) == "Ausssytralia" || countries.get(i) == "Bangyladeshy") {
                System.out.println("countryyy is: " + countries.get(i) + " and i is: " + i);
            }//end conditional statement


            ReusableClass.addTwoNumbers(3,5);


        }
    }
}


