/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbhirud.bathroomStalls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nbhirud
 */
public class BathroomStallsSmall2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String op = "";
        try {

            //Doer d = new DoerSmall2(1000,1000);
            String inFile = "E:\\GoogleCodeJam\\in.txt";
            String outFile = "E:\\GoogleCodeJam\\out.txt";
            System.out.println(inFile);
            System.out.println(outFile);

//            Scanner in = new Scanner(new File(inFile));
            BufferedReader br = new BufferedReader(new FileReader(inFile));

            int caseCount = Integer.parseInt(br.readLine().trim());
            String line = "";
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                //System.out.println(line);
                String[] input = line.split(" ");
                String str = new DoerSmall2(Long.parseLong(input[0]), Integer.parseInt(input[1])).processor();
                System.out.println(str);
                op = op + "Case #"+ i +": "+ str + "\n";
            }

            /*
            BufferedWriter bw = new BufferedWriter(new FileWriter(inFile));
            bw.write(op);
            bw.flush();
            
             */
            //Get the file reference
            Path path = Paths.get(outFile);

            //Use try-with-resource to get auto-closeable writer instance
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(op);
            }
            
            /*
            Case #1: 1 0
Case #2: 1 0
Case #3: 1 1
Case #4: 0 0
Case #5: 500 499


            */
            
            //System.out.println(op);

            //op = op +""+rs + " " + ls+"\n";
            br.close();
            //bw.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BathroomStallsSmall2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BathroomStallsSmall2.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
            DoerSmall2 d0 = new DoerSmall2(4, 2);
            DoerSmall2 d1 = new DoerSmall2(5, 2);
            DoerSmall2 d2 = new DoerSmall2(6, 2);
            DoerSmall2 d3 = new DoerSmall2(1000,1000);
            DoerSmall2 d4 = new DoerSmall2(1000,1);
            
            d0.processor();
            d1.processor();
            d2.processor();
            d3.processor();
            d4.processor();

        /*
            DoerSmall2 d0 = new DoerSmall2(4, 2);
            DoerSmall2 d1 = new DoerSmall2(5, 2);
            DoerSmall2 d2 = new DoerSmall2(6, 2);
            DoerSmall2 d3 = new DoerSmall2(1000,1000);
            DoerSmall2 d4 = new DoerSmall2(1000,1);
            
            d0.processor();
            d1.processor();
            d2.processor();
            d3.processor();
            d4.processor();
         */
    }

}
