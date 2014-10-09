/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class Euler23 {

    static ArrayList<Integer> abundants = new ArrayList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        buildAbundantNumbersList();
        int sum = 0;
        for(int index = 1; index < 28123; index++) {
            if(!canBeWritten(index)) {
                sum += index;
            }
        }
//        System.out.println(canBeWritten(1));
        //works for all cases below...off to class
//        System.out.println(canBeWritten(29));
//        System.out.println(canBeWritten(30));
//        System.out.println(canBeWritten(79));
//        System.out.println(canBeWritten(198));
//        System.out.println(canBeWritten(847));
//        System.out.println(canBeWritten(957));
        System.out.println(sum);
    }
    
    /**
     * Creates a comprehensive list of all
     * abundant numbers below or equal to 28123.
     */
    public static void buildAbundantNumbersList() {
        for(int num = 12; num <= 28123; num++) {    //12 is first abundant number
            if(isAbundant(num)) {
                abundants.add(num);
            }
        }
    }
    
    /**
     * Determines whether the number is abundant.
     * A number is abundant if the sum of its proper divisors is
     * greater than itself.
     * 
     * @param n some integer greater than 1
     * @return whether n is abundant
     */
    public static boolean isAbundant(int n) {
        int sum = 1;    //sum of all proper divisors
        for(int x = 2; x <= Math.sqrt(n); x++) {
            if(n%x == 0) {
                //add two factors by which n is found to be divisible
                sum += x;
                if(x != n/x)
                    sum += n/x;
            }
        }
        return (sum > n);
    }
    
    /**
     * Returns whether the number can be written as the sum of
     * two abundant numbers.
     * Assumes a comprehensive, ordered list of
     * abundant numbers has been created.
     * 
     * @param n the number to be tested
     * @return whether n can be written as the sum of 2 abundant numbers
     */
    public static boolean canBeWritten(int n) {
        for(int a = 0; a < abundants.size() && abundants.get(a) <= n-12; a++){ //12 is first abundant number
            for(int b = a; b < abundants.size() && abundants.get(a) + abundants.get(b) <= n; b++) {
                if(abundants.get(a) + abundants.get(b) == n) {
                    return true;
                }
            }
        }
        //unable to find any pairs of abundants adding up to n
        return false;
    }
    
}
