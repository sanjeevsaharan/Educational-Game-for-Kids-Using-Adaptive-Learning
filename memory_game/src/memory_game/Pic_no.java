package memory_game;

import java.util.Random;

public class Pic_no {
     int level; 
     Random r = new Random();  // Random number generator

     int[] pic_no0 = new int[4];
     int[] pic_no1 = new int[12];
     int[] pic_no2 = new int[16];
     int[] pic_no3 = new int[20];
     
      public void create_arr(int leve)
      {
          level = leve;
          if(level == 0)
          {
             level0();
              
          }
          else if(level == 1)
          {
               level1();
          }
          else if(level == 2)
          {
               level2();
          }
          else if(level == 3)
          {
              level3();
          }
      }

     public static void main (String args[]) 
     {
        Pic_no pic = new Pic_no();
       // pic.create_arr(3);
     }
     public void level0()
     {

        for (int i=0;i<2;i++)
        {
            pic_no0[i]=pic_no0[i+2]=i+1;
        }
        for (int i=0;i<4;i++)
        {
        int p1=r.nextInt(4);
        int p2=r.nextInt(4);
        int temp = pic_no0[p1];  
        pic_no0[p1] = pic_no0[p2];
        pic_no0[p2] = temp;
       }

     }
     public void level1()
     {

        for (int i=0;i<6;i++)
        {
             pic_no1[i]= pic_no1[i+6]=i+1;
        }
        for (int i=0;i<12;i++)
        {
        int p1=r.nextInt(12);
        int p2=r.nextInt(12);
        int temp =  pic_no1[p1];
         pic_no1[p1] =  pic_no1[p2];
         pic_no1[p2] = temp;
       }

     }
      public void level3()
     {

        for (int i=0;i<10;i++)
        {
            pic_no3[i]=pic_no3[i+10]=i+1;
        }
        for (int i=0;i<20;i++)
        {
        int p1=r.nextInt(20);
        int p2=r.nextInt(20);
        int temp = pic_no3[p1];
        pic_no3[p1] = pic_no3[p2];
        pic_no3[p2] = temp;
       }

     }
     
     public void level2()
     {

        for (int i=0;i<8;i++)
        {
            pic_no2[i]=pic_no2[i+8]=i+1;
        }
        for (int i=0;i<16;i++)
        {
        int p1=r.nextInt(16);
        int p2=r.nextInt(16);
        int temp = pic_no2[p1];
        pic_no2[p1] = pic_no2[p2];
        pic_no2[p2] = temp;
       }

     }
}
