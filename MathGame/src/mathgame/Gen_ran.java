
package mathgame;

public class Gen_ran {
   
        static int[] answer;
        static String[] prob;
        static int[] index;
         int n1,n2;
         
        public void cal_num(String gametype,int l)
        {
           if(l==0 || l==2) {     
            if (gametype.equals("Subtraction")) {
                    n1 = (int) (2 + Math.random() * 15);
                    n2 = (int) (2 + Math.random() * 12);
                    while (n1 <= n2) {
                     n1 = (int) (2 + Math.random() * 15);
                    }
                 }
            else if (gametype.equals("Multiplication")) {
                    n1 = (int) (2 + Math.random() * 4);
                    n2 = (int) (2 + Math.random() * 3);

                 }
            else if (gametype.equals("Division")) {
                    n1 = (int) (2 + Math.random() * 6);
                    n2 = (int) (2 + Math.random() * 5);

                 }        
                else {
                    n1 = (int) (2 + Math.random() * 5);
                    n2 = (int) (2 + Math.random() * 4);
                }  
          }
            if(l==1 || l==3)
            {
            if (gametype.equals("Subtraction")) {
                    n1 = (int) (2 + Math.random() * 30);
                    n2 = (int) (2 + Math.random() * 25);
                    while (n1 <= n2) {
                     n1 = (int) (2 + Math.random() * 30);
                    }
                 }
            else if (gametype.equals("Multiplication")) {
                    n1 = (int) (2 + Math.random() * 8);
                    n2 = (int) (2 + Math.random() * 7);

                 }
            else if (gametype.equals("Division")) {
                    n1 = (int) (2 + Math.random() * 15);
                    n2 = (int) (2 + Math.random() * 12);

                 }        
                else {
                    n1 = (int) (2 + Math.random() * 15);
                    n2 = (int) (2 + Math.random() * 14);
                }   
            }
            if(l==4 || l==6)
            {
            if (gametype.equals("Subtraction")) {
                    n1 = (int) (2 + Math.random() * 50);
                    n2 = (int) (2 + Math.random() * 45);
                    while (n1 <= n2) {
                     n1 = (int) (2 + Math.random() * 50);
                    }
                 }
            else if (gametype.equals("Multiplication")) {
                    n1 = (int) (2 + Math.random() * 10);
                    n2 = (int) (2 + Math.random() * 9);

                 }
            else if (gametype.equals("Division")) {
                    n1 = (int) (2 + Math.random() * 25);
                    n2 = (int) (2 + Math.random() * 20);

                 }        
                else {
                    n1 = (int) (2 + Math.random() * 48);
                    n2 = (int) (2 + Math.random() * 47);
                }  
            }
             if(l==5 || l==8)
            {
            if (gametype.equals("Subtraction")) {
                    n1 = (int) (2 + Math.random() * 100);
                    n2 = (int) (2 + Math.random() * 95);
                    while (n1 <= n2) {
                     n1 = (int) (2 + Math.random() * 100);
                    }
                 }
            else if (gametype.equals("Multiplication")) {
                    n1 = (int) (2 + Math.random() * 15);
                    n2 = (int) (2 + Math.random() * 13);

                 }
            else if (gametype.equals("Division")) {
                    n1 = (int) (2 + Math.random() * 35);
                    n2 = (int) (2 + Math.random() * 30);

                 }        
                else {
                    n1 = (int) (2 + Math.random() * 98);
                    n2 = (int) (2 + Math.random() * 97);
                }  
            }
             
             if(l==7 || l==9)
            {
            if (gametype.equals("Subtraction")) {
                    n1 = (int) (2 + Math.random() * 150);
                    n2 = (int) (2 + Math.random() * 145);
                    while (n1 <= n2) {
                     n1 = (int) (2 + Math.random() * 150);
                    }
                 }
            else if (gametype.equals("Multiplication")) {
                    n1 = (int) (2 + Math.random() * 20);
                    n2 = (int) (2 + Math.random() * 19);

                 }
            else if (gametype.equals("Division")) {
                    n1 = (int) (2 + Math.random() * 50);
                    n2 = (int) (2 + Math.random() * 40);

                 }        
                else {
                    n1 = (int) (2 + Math.random() * 200);
                    n2 = (int) (2 + Math.random() * 190);
                }  

        }
        }
        public void newgame(String str,int level){
            String gametype = str;
        
            int i;
            String value;
            answer = new int[16];

            prob = new String[16];
           
            for (i = 0; i < 16; i++)
            {

                int ans;

                cal_num(str,level);
            if(gametype.equals("Addition"))
            {
                value = Integer.toString(n1) + " + " + Integer.toString(n2);
                 ans = n1 + n2;

            }
            else if(gametype.equals("Subtraction"))
            {
             value = Integer.toString(n1) + " - " + Integer.toString(n2);
            ans = n1 - n2;
            }
            else if(gametype.equals("Division"))
            {
            value = Integer.toString(n1*n2) + " / " + Integer.toString(n2);
            ans = n1;
            }
            else
            {
            value = Integer.toString(n1) + " * " + Integer.toString(n2);
                ans = n1*n2;
            }
                prob[i]=value;
                answer[i]=ans;
        }
        index = new int[16];
        index = random_without_rep.md();
       

    }

        public void newgame1(String str){
            
            
        }

}

