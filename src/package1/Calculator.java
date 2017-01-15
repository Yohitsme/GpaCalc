package package1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by User on 1/8/2017.
 * This class will be responsible for doing the back end calculations and conversions.
 */
public class Calculator {

    //public static ArrayList<Integer> marksList;
    public static ArrayList<Double> numberList;
    public static double gpa;

    // The conversion formula for the 4.0 GPA scale
    public static void conversion(ArrayList<Integer> marksList){
    	numberList = new ArrayList<>();
    	numberList.clear();
        for (Integer item : marksList ) {
            if (item < 50) {
                numberList.add(0.0);
            } else if (item >= 50 && item <= 52) {
                numberList.add(0.7);
            } else if (item >= 53 && item <= 56) {
                numberList.add(1.0);
            } else if (item >= 57 && item <= 59) {
                numberList.add(1.3);
            } else if (item >= 60 && item <= 62) {
                numberList.add(1.7);
            } else if (item >= 63 && item <= 66) {
                numberList.add(2.0);
            } else if (item >= 67 && item <= 69) {
                numberList.add(2.3);
            } else if (item >= 70 && item <= 72) {
                numberList.add(2.7);
            } else if (item >= 73 && item <= 76) {
                numberList.add(3.0);
            } else if (item >= 77 && item <= 79) {
                numberList.add(3.3);
            } else if (item >= 80 && item <= 84) {
                numberList.add(3.7);
            } else if (item >= 85) {
                numberList.add(4.0);
            }
        }
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double calculate(){
    	gpa = 0.0;
        for (double item : numberList){
            gpa += item;
        }
        gpa = gpa/numberList.size();
        return round(gpa, 2);
    }

}
