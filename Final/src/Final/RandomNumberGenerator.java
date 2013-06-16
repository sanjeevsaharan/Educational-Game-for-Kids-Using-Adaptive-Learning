/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Final;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author mukesh
 */
public class RandomNumberGenerator {
    ArrayList numbersList = new ArrayList ();
    public RandomNumberGenerator(int length) {
        for(int x=1;x<=length;x++)
            numbersList.add(x);
        Collections.shuffle(numbersList);
    }
     public Integer  generateNewRandom(int n) {
        
       return (Integer) numbersList.get(n);
    }
 public static void main(String[] args) {
      RandomNumberGenerator r = new RandomNumberGenerator(26);
      for(int i = 0;i < 26; i++ ) {
         Integer k= r.generateNewRandom(i);
          System.out.println(""+k);
      }
    }

}
