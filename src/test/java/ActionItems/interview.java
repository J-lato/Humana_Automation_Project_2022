package ActionItems;

import java.util.ArrayList;

public class interview {
    //Print oul all the vowels of a given string
    public static void main(String[] args) {


        String vowel = "Rum Chata";
        //split the string by common factor
        //String[] vowelsplit = vowel.split("");
        for (int i = 0; i < vowel.length(); i++) {

            if (vowel.charAt(i) == 'a' || vowel.charAt(i) == 'e' || vowel.charAt(i) == 'i' || vowel.charAt(i) == 'o' || vowel.charAt(i) == 'u') {
                System.out.println("The vowels are: " + vowel.charAt(i));
//                if(vowel.charAt(i)=='a' ){
//                    System.out.println("The vowels is: "+ vowelsplit[i]);
//                }
//                else{
//                    System.out.println("failure");
//                }
            }
        }
    }
}







