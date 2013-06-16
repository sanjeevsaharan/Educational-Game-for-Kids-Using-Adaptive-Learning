/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Final;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;

/**
 *
 * @author mukesh
 */
public class Mapp {
    public String map_test(Integer pos){
        Map<String,Object> mp=new HashMap<String,Object>();

        // adding or set elements in Map by put method key and value pair

        mp.put("Apple",new Integer(1));
        mp.put("Banana",new Integer(2));
        mp.put("Cat",new Integer(3));
        mp.put("Dog",new Integer(4));
        mp.put("Elephant",new Integer(5));
        mp.put("Fan",new Integer(6));
        mp.put("Goat",new Integer(7));
        mp.put("Horse",new Integer(8));
        mp.put("Inkport",new Integer(9));
        mp.put("Jug",new Integer(10));
        mp.put("Kite",new Integer(11));
        mp.put("Lion",new Integer(12));
        mp.put("Monkey",new Integer(13));
        mp.put("Nest",new Integer(14));
        mp.put("Owl",new Integer(15));
        mp.put("Peacock",new Integer(16));
        mp.put("Queen",new Integer(17));
        mp.put("Rat",new Integer(18));
        mp.put("Spon",new Integer(19));
        mp.put("Tiger",new Integer(20));
        mp.put("Umbrella",new Integer(21));
        mp.put("Van",new Integer(22));
        mp.put("Wolf",new Integer(23));
        mp.put("X-Ray",new Integer(24));
        mp.put("Yak",new Integer(25));
        mp.put("Zebra",new Integer(26));
        mp.put("Pineapple",new Integer(27));
        mp.put("Mango",new Integer(28));
        mp.put("Orange",new Integer(29));
        mp.put("Litci",new Integer(30));
        mp.put("Guvava",new Integer(31));
        mp.put("Coconut",new Integer(32));
        mp.put("Plums",new Integer(33));
        mp.put("Cherry",new Integer(34));
        mp.put("Watermelon",new Integer(35));
        mp.put("Pear",new Integer(36));
        mp.put("Grapes",new Integer(37));
        mp.put("Date",new Integer(38));
        mp.put("BlackBerry",new Integer(39));
        mp.put("Chikoo",new Integer(40));
        mp.put("Bear",new Integer(41));
        mp.put("Camel",new Integer(42));
        mp.put("Bat",new Integer(43));
        mp.put("Deer",new Integer(44));
        mp.put("Dolfin",new Integer(45));
        mp.put("Fish",new Integer(46));
        mp.put("Giraffi",new Integer(47));
        mp.put("Gorilla",new Integer(48));
        mp.put("Hawk",new Integer(49));
        mp.put("Hornet",new Integer(50));





        //Get Map in Set interface to get key and value
        
        Set s=mp.entrySet();
        String ans ="";
        //Move next key and value of Map by iterator
        
        Iterator it=s.iterator();

        while(it.hasNext())
        {
            // key=value separator this by Map.Entry to get key and value
            Map.Entry m =(Map.Entry)it.next();

            // getKey is used to get key of Map
            String key=(String)m.getKey();

            // getValue is used to get value of key in Map
            Integer value=(Integer)m.getValue();
            //System.out.println("value="+value+"pos="+pos);
            if(value.compareTo(pos)==0){
                ans = key;

            }
        }
//        System.out.println("pos="+pos + " "+ans);
//        ImageIcon img = new ImageIcon(getClass().getResource("/Final/resources/"+pos+".png"));
//        System.out.println(""+img);
        return ans;
    }
    public static void main(String[] args) {
          Mapp m = new  Mapp();
        for (int i = 21; i<50; i++ ){
            m.map_test(i);

        }
    }
}
