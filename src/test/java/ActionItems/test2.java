package ActionItems;

import java.util.ArrayList;

public class test2 {
    public static void main(String[] args) {
        //create arrayList of cities and iterate, only print bk and queens
        ArrayList<String> nyc= new ArrayList<>();
        nyc.add("brooklyn");
        nyc.add("queens");
        nyc.add("manhattan");
        //create for loop for iteration
        for(int i= 0; i<nyc.size(); i++ ){
            if (nyc.get(i)=="brooklyn"||nyc.get(i)=="queens") {
                System.out.println("the borough is: " + nyc.get(i));
            }
            }
        }
    }

