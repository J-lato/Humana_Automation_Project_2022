package Day_2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class T2_ArrayList {
    public static void main(String[] args) {
        //declare and define arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        //add the values for countries array
        countries.add("USA");
        countries.add("Japan");
        countries.add("India");
        countries.add("Africa");

        System.out.println("args = " + Arrays.deepToString(args));
        //print USA from arrayList
        System.out.println("Countries value: " + countries.get(0));
        //print count of the arrayList
        System.out.println("Countries count: " +countries.size());

        //create an integer array list for streetNumber
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(223);
        streetNumber.add(234);
        streetNumber.add(8766);
        System.out.println("street number 2: " + streetNumber.get(1));
    }//end of main
}//end of java class
