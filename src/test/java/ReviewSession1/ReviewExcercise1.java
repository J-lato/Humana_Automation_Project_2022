package ReviewSession1;

import java.util.ArrayList;

public class ReviewExcercise1 {
    //main start
    public static void main(String[] args) {
        String[] carBrands;
        carBrands= new String[] {"AMG", "Keonigsegg", "BMW", "Porsche", "McLaren"};


        int i= 0;

        while(i< carBrands.length){
            System.out.println("Elite Makes: " + carBrands[i]);
            i++;

        }//end whileLoop
        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("3476785438");
        phoneNumbers.add("2124567345");
        phoneNumbers.add("7183456723");
        phoneNumbers.add("9296789947");
        phoneNumbers.add("7182390732");

        for(int i2=0; i2 < 4; i2++){
            System.out.println(phoneNumbers.get(i2));
        }


    }//end main

}
