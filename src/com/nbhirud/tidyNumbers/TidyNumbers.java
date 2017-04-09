/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbhirud.tidyNumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nbhirud
 */
public class TidyNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String inFile = "E:\\GoogleCodeJam\\tidy\\B-small-practice.in";
        String outFile = "E:\\GoogleCodeJam\\tidy\\B-small-practice.out";
        System.out.println(inFile);
        String op = "";
        String finalOp = "";
        String line = "";
        int i = 0;

        int currNum = 0;
        String currStr = "";
        int numLen = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader(inFile));

            int count = Integer.parseInt(br.readLine());
            int[] numbs = new int[count];
            while ((line = br.readLine()) != null) {

                //System.out.println(isTidy(line)+" ----- "+line);
                numbs[i] = Integer.parseInt(line);
                i++;
            }
            //System.out.println(numbs.length);
            int k = 0;
            for (int n : numbs) {
                //we iterate through each number in the array
                //int n = numbs[k];
                op = "" + n;
                if (!isTidy(n)) {
                    int oneFlagCount = 0;
                    currNum = n;

                    for (i = 0; (i < op.length()) && (!isTidy(n)); i++) {

                        //for (i = 0; i < op.length(); i++) {
                        //if(Integer.parseInt(op.substring(i, i+1)) <= Integer.parseInt(op.substring(i+1, i+2))) {
                        if (oneFlagCount >= 0) {
                            //means that we haven't encountered a non-One digit yet
                            if (Integer.parseInt(op.substring(i, i + 1)) == 1) {
                                oneFlagCount++;
                            } else {
                                oneFlagCount = -1;
                            }
                        }
                        if (Integer.parseInt(op.substring(i, i + 1)) <= ((i + 2 <= op.length()) ? Integer.parseInt(op.substring(i + 1, i + 2)) : 9)) {
                            //digit at posotion i is less than or equal to digit at position i+1 => correct order
                            continue;
                        } else {
                            //we have encountered an invalid order of digits
                            int num = (Integer.parseInt(op.substring(i, i + 1)) - 1) * 10 + 9; // this would convert 32 to 29 (example)
                            //String newOp = op.substring(0,i)+num+op.substring(i+3, op.length());
                            //String newOp = op.substring(0, i) + num + ((i + 3 <= op.length()) ? op.substring(i + 3, op.length()) : "");

                            //String newOp = op.substring(0, i) + num;
                            String newOp = "";
                            if (oneFlagCount < 0) {
                                //atleast 1 non 1 digit yet
                                newOp = op.substring(0, i) + num;
                                String tmp = "";
                                for (int x = i; x < op.length() - 2; x++) {
                                    tmp = tmp + "9";
                                }
                                newOp = newOp + tmp;
                            } else {
                                //all digits till now were 1
                                String tmp2 = "";
                                for (int x = 0; x < op.length() - 1; x++) {
                                    tmp2 = tmp2 + "9";
                                }
                                newOp = tmp2;

                            }

                            n = Integer.parseInt(newOp);
                            op = "" + n;
                        }

                    }
                    numbs[k] = n;
                } else {
                    //the number is already tidy and we have already assigned it to 'op'
                }
                k++;
            }

            //Writing to output
            op = "";
            int j = 0;
            for (int n : numbs) {
                op = op + "Case #" + ((int) (j + 1)) + ": " + n + "\n";
                j++;
            }

            System.out.println(op);

            Path path = Paths.get(outFile);
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(op);
            }
            br.close();
            System.out.println(outFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TidyNumbers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TidyNumbers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isTidy(int num) {
        //checks if all digits are in an ascending order from left to right
        String str = "" + num;
        boolean status = true;
        int strLen = str.length();

        //System.out.println("********* "+str);
        for (int i = 0; (i < strLen - 1) && (status == true); i++) {
            if (Integer.parseInt(str.substring(i, i + 1)) > Integer.parseInt(str.substring(i + 1, i + 2))) {
                status = false;
            }
            //System.out.println(str.substring(i, i+1)+" - "+str.substring(i+1, i+2)+" - "+status);
        }
        //System.out.println(status + " ----- " + str);
        return status;
    }
}
