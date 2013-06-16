/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame;

/**
 *
 * @author MANGALDEEP
 */
public class Calculate {
    

     
      public boolean cal_but(String text,String matchwithcard)
    {
              
       int a,b,c=0;
       int a2,b2,c2=0;
       
       if(text.contains("+") || text.contains("-") || text.contains("*") || text.contains("/"))
       {
        String[] a1=text.split(" ");
        a =  Integer.parseInt(a1[0]);
        b =  Integer.parseInt(a1[2]);
        
        if("+".equals(a1[1]))
        {
            c = a+b;
        }
        else if("-".equals(a1[1]))
        {
            c = a-b;
        }
        else if("*".equals(a1[1]))
        {
            c = a*b;
        }
        else if("/".equals(a1[1]))
        {
            c = a/b;
        }
        
        
        c2 = Integer.parseInt(matchwithcard);
        
        if(c2==c) return true;
        else return false;
       }
       
       else {
           c =  Integer.parseInt(text);  
           String[] x1 = matchwithcard.split(" ");
           a2 = Integer.parseInt(x1[0]);
           b2 = Integer.parseInt(x1[2]);
           c2 = 0;
           
         if("+".equals(x1[1]))
        {
            c2 = a2+b2;
        }
        else if("-".equals(x1[1]))
        {
            c2 = a2-b2;
        }
        else if("*".equals(x1[1]))
        {
            c2 = a2*b2;
        }
        else if("/".equals(x1[1]))
        {
            c2= a2/b2;
        }
         if(c2==c) return true;
        else return false;
       }
       
    }
    
 }
