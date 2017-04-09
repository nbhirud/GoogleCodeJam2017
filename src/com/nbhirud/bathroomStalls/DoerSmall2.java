/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbhirud.bathroomStalls;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 *
 * @author nbhirud
 */
public class DoerSmall2 {

    //TreeSet<Integer> t;
    PriorityQueue<Long> t;
    int pplCount;

    public DoerSmall2(Long n, int p) {
        //t = new TreeSet<>();
        //t = new PriorityQueue<>((long x,long y) ->  (y-x));
        t = new PriorityQueue<>(Collections.reverseOrder());
        t.add(n);
        pplCount = p;

    }

    public String processor() {

        long ls = 0, rs = 0;
        //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = pplCount; i > 0; i--) {

            //int largest = t.last(); //largest in tree set
            long largest = t.poll();
            //t.remove(largest);
            if (largest == 0) {
                //System.out.println("####################################3"+largest+" "+i+" "+pplCount);

            } else if (largest == 1) {
                //System.out.println("**********"+largest+" "+i+" "+pplCount);
                ls = 0;
                rs = 0;
                t.add(ls);
                t.add(rs);
            } else if (largest % 2 == 0) {
                //System.out.println("**********"+largest+" "+i+" "+pplCount);
                //largest was even
                rs = largest / 2;
                ls = rs - 1;
                t.add(ls);
                t.add(rs);
            } else {
                //System.out.println("**********"+largest+" "+i+" "+pplCount);
                ls = rs = largest / 2;
                t.add(ls);
                t.add(rs);

            }
            /*
            if(ls > 0) {
                           t.add(ls); 
            }
            
            if(rs > 0) {
                            t.add(rs);
            }
             */

//            t.add(ls);
//            t.add(rs);
        }

        //System.out.println(rs + " " + ls);
        return rs + " " + ls;

    }

}
