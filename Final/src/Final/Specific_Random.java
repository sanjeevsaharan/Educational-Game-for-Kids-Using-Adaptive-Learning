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
public class Specific_Random {
      ArrayList numbersList = new ArrayList ();
    public Specific_Random(int start,int end) {
        for(int x=start;x<=end;x++)
            numbersList.add(x);
        Collections.shuffle(numbersList);
    }
     public Integer  generateNewRandom(int n) {

       return (Integer) numbersList.get(n);
    }
 public static void main(String[] args) {
      Specific_Random r = new Specific_Random(21,30);
      for(int i = 0;i < 10; i++ ) {
         Integer k= r.generateNewRandom(i);
          System.out.println(""+k);
      }
    }

}
