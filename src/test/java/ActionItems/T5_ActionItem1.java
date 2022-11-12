package ActionItems;

import java.util.ArrayList;

public class T5_ActionItem1 {
    public static void main(String[] args) {

         //create and define the ArrayList country, then add the elements.
        ArrayList<String> country = new ArrayList<>();
         country.add("USA");
         country.add("Nigeria");
         country.add("Russia");
         country.add("Grenada");
         country.add("Canada");

         //create integer array with country codes
        int[] countryCode = new int[]{1,234,7,473,1};

        //create for loop with conditions
         for(int i=0; i< country.size(); i++ ){
             System.out.println("when i is "+i+ " My Country is: " + country.get(i) + " with Area code +"+ countryCode[i]);
         }//end for loop

        String[] region = new String[]{"Brooklyn", "Westchester", "Buffalo", "Manhattan"};// element for Area created and defined
         int[] areaCode= new int[]{347, 914, 716, 718};// element for areaCode created and defined
        int i=0;// initializer is set with variable i = 0
         while( i<region.length){// length of Arraylist is not counted started from 0. length of Arraylist starts from 1
             System.out.println("when i is: " + i + ' ' + region[i] +" +"+ areaCode[i]); i++;
         };//end while loop


    }//end main
}//end java class
