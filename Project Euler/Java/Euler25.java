/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

import java.math.BigInteger;

/**
 *
 * @author chris
 */
public class Euler25 {
    //Created entirely to compare running times.
    //I finished this in Python and the brute
    //force approach only took a few hundredths
    //of a second.
    
    public static void main(String[] args) {
        fibWithDigits(1000);
    }
    
    public static void fibWithDigits(int digits) {
        long t = System.currentTimeMillis();
        BigInteger a = new BigInteger("0");
        BigInteger f = new BigInteger("1");
        BigInteger done = new BigInteger("1");
        int num = 1;
        while(digits > 1){
            done = done.multiply(new BigInteger("10"));
            digits--;
        }
        while(f.compareTo(done) < 0) {
            BigInteger b = new BigInteger("0");
            b = b.add(f);
            f = f.add(a);
            a = a.subtract(a);
            a = a.add(b);
            num++;
        }
        long elapsed = System.currentTimeMillis()-t;
        System.out.println("Number: "+f.toString());
        System.out.println("Index: "+num);
        System.out.println("Time: "+elapsed);
    }
    
}
