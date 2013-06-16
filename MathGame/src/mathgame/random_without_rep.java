/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mathgame;

import java.util.*;

//generate random number for 16 buttons without repetation
public class random_without_rep {
    
        public static List get(List numbers, int noOfRandomNumbers) {
                List list = new ArrayList(numbers);
                List randomList = new ArrayList();

                Random rd = new Random();
                for (int i = 0; i < noOfRandomNumbers; i++) {
                        int index = (int) (rd.nextDouble() * list.size());
                        randomList.add(list.get(index));
                        list.remove(index);
                }
                return randomList;
        }

        public static int[] md() {
                int[] ind = new int[16];    
                int arr[] = new int[16];
                Integer in[] = new Integer[16];
         
                for (int i = 0; i < arr.length; i++) {
                        arr[i] = i;   
                        in[i] = new Integer(arr[i]);
                }
               // System.out.println("Generated Random Numbers: ");
                List randomList = get(Arrays.asList(in), 16);
               
                       
                  Iterator it =randomList.listIterator();
                  for(int i = 0; i < 16; i++)
                  {
                       String d = it.next().toString();
                      // int s = (int) it.next();
                      //ind[i]=(int) it.next();
                      ind[i]=Integer.parseInt(d); 
                      //System.out.println(ind[i]);
                  }
                  return ind;
            }
}
