
package memory_game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Memory_game extends Applet implements ActionListener {

     Font f = new java.awt.Font("TimesRoman", Font.BOLD, 23);
     Timer timer = new Timer(200, null);
     Timer timerGame = new Timer(1000, null);
     
     boolean matchBtns2[] = new boolean[16];
     boolean matchBtns0[] = new boolean[4];
     boolean matchBtns1[] = new boolean[12];
     boolean matchBtns3[] = new boolean[20];
     
     int level_type = 0;
     int level = 0;
     JLabel time;          // for display timer
     JButton play;         // for start game
     JButton help;         // for help
     Panel q = new Panel();
     Panel r = new Panel();
     
     BackGroundPanel bgp = new BackGroundPanel();
     int timeleft;
     int steps;
     int status;
     JLabel step;
     Image background;
     
     AudioClip sound1;
     @Override
    public void init()
    {
        sound1 =  getAudioClip(getClass().getResource("/memory_game/resources/a.WAV"));
        background = getImage(getClass().getResource("/memory_game/resources/back4.jpg"));

  
         q.setBounds(150,20,600,40);
         q.setLayout(new GridLayout(1,4,10,10));
         play = new JButton("Play");
         play.setToolTipText("Press this to start game.");

         help = new JButton("Help");
         help.setToolTipText("Press this for Help.");
         step = new JLabel("Clicks",JLabel.CENTER);
         step.setToolTipText("No of clicks .");
         time = new JLabel("Time ",JLabel.CENTER);
         q.setBackground(Color.LIGHT_GRAY);
         time.setFont(f);
         play.setFont(f);
         help.setFont(f);
         step.setFont(f);
         q.add(play);
         q.add(time);
         q.add(help);
         q.add(step);
         bgp.add(q);
         screen0();
         screen1();
         screen2();
         screen3();
         screen4();
         q.setVisible(true);
         bgp.setBounds(0,0,900,600);
         add(bgp);
         setSize(900,600);
         bgp.setBackGroundImage(background);
         bgp.setLayout(new BorderLayout());
         this.setLayout(new BorderLayout());
         setFont(f);
         
         play.addActionListener(new java.awt.event.ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sound1.play();
                play_actionPerformed(e);
            }

         });
        help.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            
            public void actionPerformed(ActionEvent e)
            {
                sound1.play();
                help_actionPerformed(e);
            }
        });
        timer.setRepeats(false);
        timer.addActionListener(new java.awt.event.ActionListener()
        {
        @Override
            public void actionPerformed(ActionEvent e)
            {
                timer_actionPerformed(e);
            }

        });

       timerGame.addActionListener(new java.awt.event.ActionListener()
      {
            @Override
        public void actionPerformed(ActionEvent e)
        {
         timerGame_actionPerformed(e);
        }
        private void timerGame_actionPerformed(ActionEvent e) {
                
              timeleft--;
              if (timeleft==-1){
                timerGame.stop();
                time_less();
                }
                time.setText(timeleft+" Sec ");
            }
        });         
   }
     
    @Override
    public void actionPerformed(ActionEvent e) {
       if(level==0)
       {
           level0_action(e);
       }
       else if(level==1)
       {
         level1_action(e);
       }
       else if(level==2)
        {
           level2_action(e);
        }
       else if(level==3)
       {
           level3_action(e);
       }
    }
    
  void timer_actionPerformed(ActionEvent e)
  {
    // Hide all numbers
    if(level==0)
    {
        level0_timer(e);
    }
   else if(level==2)
    {
        level2_timer(e);
    }
   else if(level==1)
   {
       level1_timer(e);
   }
   else if(level==3){
       level3_timer(e);
   }
  }
  
  Panel scn = new Panel();
  JButton Btn0[] = new JButton[4];   
    
    public void screen0()
    {
         scn.setLayout(new GridLayout(2,2,1,1));
         scn.setBounds(150,70,600,480);
         scn.setVisible(true);   
         for(int i1=0; i1 <4; i1++)
         {
            Btn0[i1] = new JButton();
            Btn0[i1].setBackground(Color.BLACK);
            Btn0[i1].addActionListener(this);
            scn.add(Btn0[i1]);
         }
          add(scn);
          play.setEnabled(true);

         for (int i=0; i<4; i++){
         Btn0[i].setEnabled(false);
         Btn0[i].setIcon(null);
         }
    }
    Panel scn1 = new Panel();
    JButton Btn1[] = new JButton[12]; 
    
    public void screen1()
    {
         scn1.setLayout(new GridLayout(3,4,1,1));
         scn1.setBounds(150,70,600,480);
         scn1.setVisible(false);                
         for(int i1=0; i1 <12; i1++)
         { 
            Btn1[i1]=new JButton();
            Btn1[i1].setBackground(Color.BLACK);
            Btn1[i1].addActionListener(this);

            scn1.add(Btn1[i1]);
         }
         add(scn1);
         play.setEnabled(true);

         for (int i=0; i<12; i++){
         Btn1[i].setEnabled(false);
         Btn1[i].setIcon(null);
         }
        
    }
    Panel scn2 = new Panel();
    JButton Btn2[] = new JButton[16];   
    public void screen2()
    {
         scn2.setLayout(new GridLayout(4,4,1,1));
         scn2.setBounds(150,70,600,480);
         scn2.setVisible(false);   
          for(int i1=0; i1 <16; i1++)
         {
            Btn2[i1]=new JButton();
            Btn2[i1].setBackground(Color.BLACK);
            Btn2[i1].addActionListener(this);
            scn2.add(Btn2[i1]);
         }
         add(scn2);
         play.setEnabled(true);

         for (int i=0; i<16; i++){
         Btn2[i].setEnabled(false);
         Btn2[i].setIcon(null);
         }
    }
    Panel scn3 = new Panel();
    JButton Btn3[] = new JButton[20]; 
    public void screen3()
    {
         scn3.setLayout(new GridLayout(4,5,1,1));
         scn3.setBounds(150,70,600,480);
         scn3.setVisible(false);   
          for(int i1=0; i1 <20; i1++)
         {
            Btn3[i1]=new JButton();
            Btn3[i1].setBackground(Color.BLACK);
            Btn3[i1].addActionListener(this);
            scn3.add(Btn3[i1]);
         }
         add(scn3);
         play.setEnabled(true);

         for (int i=0; i<20; i++){
         Btn3[i].setEnabled(false);
         Btn3[i].setIcon(null);
         }
    }
    Panel scn4 = new Panel();
    JLabel l = new JLabel(" Congratulation ",JLabel.CENTER);
    JLabel l1 = new JLabel(" You Finished Game ",JLabel.CENTER);
    public void screen4()
    {
        q.setVisible(false);
        scn4.setVisible(false);
        scn4.add(l);
        scn4.add(l1);
        l.setFont(f);
        l1.setFont(f);
        scn4.setBackground(Color.green);
        scn4.setBounds(100,100,400,200);
        add(scn4);
    }
    
     Pic_no pics = new Pic_no();
     int[] pict_no0 = new int[4];
     int[] pict_no1 = new int[12];
     int[] pict_no2 = new int[16];
     int[] pict_no3 = new int[20];
     int no_click;
     int first_but; 
   
     public void play_actionPerformed(ActionEvent e)
   {
        if(level==0)
         {
           timeleft = 10;
         }
         else if(level==1)
         {
           timeleft = 45;
         }
         else if(level==2)
         {
             timeleft = 60;
         }
         else timeleft=75;
                             
         steps = 0;
         status = 0;
         no_click = 0;
         first_but = -1;
         step.setText("0 Clicks");
         time.setText(" Time ");
         play.setEnabled(false);
         pics.create_arr(level);
                
          if(level==0)
          {
               int ran = (int) (Math.random() *16);
               for(int i = 0; i < 4; i++)
               {
                    Btn0[i].setIcon(null);
               }
               pict_no0=pics.pic_no0;
               for (int i=0; i<4; i++){
                    Btn0[i].setEnabled(true);
                    pict_no0[i]=pict_no0[i]+ran;
                    
               }
               System.out.println(ran);
           }
           else if(level==1)
           {
               for(int i = 0; i < 12; i++)
               {
                    Btn1[i].setIcon(null);
               }
               
                pict_no1=pics.pic_no1;
               
               for (int i=0; i<12; i++)
                  Btn1[i].setEnabled(true);
                 if(level_type==0)
                 {
                  for (int i=0; i<12; i++)
                       pict_no1[i]=pict_no1[i]+200;
                 }
                     else if(level_type == 1)
                       {
                                 for (int i=0; i<12; i++)
                                  pict_no1[i]=pict_no1[i]+100; 
                            }
                            else if(level_type == 2)
                            {
                                 for (int i=0; i<12; i++)
                                  pict_no1[i]=pict_no1[i]+12; 
                            }
             }
             else if(level==2)
              {
                 for(int i = 0; i < 16; i++)
                 {
                    Btn2[i].setIcon(null);
                 }      
                 pict_no2=pics.pic_no2;
                  for (int i=0; i<16; i++){
                        Btn2[i].setEnabled(true);
                  }
                        if(level_type == 0)
                        {
                          for(int i1=0; i1<16; i1++)
                           pict_no2[i1]=pict_no2[i1]+200;
                        }
                        else if(level_type == 1)
                        {
                          for (int i2=0; i2<16; i2++)
                           pict_no2[i2]=pict_no2[i2]+100;  
                        }
                        else if(level_type == 2)
                        {
                            for(int i3=0; i3<16; i3++){
                           pict_no2[i3]=pict_no2[i3]+0;
                            }
                        }
              }else if(level==3)
                 {
                    for(int i = 0; i < 20; i++)
                    {
                     Btn3[i].setIcon(null);
                    }     
                        pict_no3=pics.pic_no3;
                                          for (int i=0; i<20; i++)
                        Btn3[i].setEnabled(true);
                         if(level_type == 0)
                         {
                             for (int i=0; i<20; i++)
                                 pict_no3[i]=pict_no3[i]+200;
                         }
                         else if(level_type == 1)
                         {
                             for (int i=0; i<20; i++)
                                 pict_no3[i]=pict_no3[i]+100;
                         }
                         else if(level_type == 2)
                         {
                             for (int i=0; i<20; i++)
                                 pict_no3[i]=pict_no3[i]+0;
                         }
                    }
                    
                    timerGame.start();
     }
 public void level0_action(ActionEvent e)
 {
  
     int but1 = -1;
     for(int i = 0; i < 4; i++)
     {
         if(e.getSource()==Btn0[i])
         {
             but1 = i;
         }
     }
     ImageIcon img = new ImageIcon(getClass().getResource("/memory_game/resources/level0/"+pict_no0[but1]+".jpg"));
     Btn0[but1].setIcon(img);
     if(no_click==0){
         Btn0[but1].setEnabled(false);
         Btn0[but1].setDisabledIcon(img);
         no_click = 1;
         first_but = but1;
     } else if(no_click==1)
        {
           match(but1);
           Btn0[but1].setDisabledIcon(img);
       }
}
 public void level1_action(ActionEvent e)
 {
  
     int but1 = -1;
     for(int i = 0; i < 12; i++)
     {
         if(e.getSource()==Btn1[i])
         {
             but1 = i;
         }
     }
     ImageIcon img = new ImageIcon(getClass().getResource("/memory_game/resources/level1/"+pict_no1[but1]+".jpg"));
     Btn1[but1].setIcon(img);
     if(no_click==0){
         Btn1[but1].setEnabled(false);
         Btn1[but1].setDisabledIcon(img);
         no_click = 1;
         first_but = but1;
     } else if(no_click==1)
        {
           match(but1);
           Btn1[but1].setDisabledIcon(img);
       }
}
 public void level2_action(ActionEvent e)
 {
  
     int but1 = -1;
     for(int i = 0; i < 16; i++)
     {
         if(e.getSource()==Btn2[i])
         {
             but1 = i;
         }
     }
     ImageIcon img = new ImageIcon(getClass().getResource("/memory_game/resources/level2/"+pict_no2[but1]+".jpg"));
     Btn2[but1].setIcon(img);
     if(no_click==0){
         Btn2[but1].setEnabled(false);
         Btn2[but1].setDisabledIcon(img);
         no_click = 1;
         first_but = but1;
     } else if(no_click==1)
        {
           match(but1);
           Btn2[but1].setDisabledIcon(img);
       }
} 
public void level3_action(ActionEvent e)
 {
  
     int but1 = -1;
     for(int i = 0; i < 20; i++)
     {
         if(e.getSource()==Btn3[i])
         {
             but1 = i;
         }
     }
     ImageIcon img = new ImageIcon(getClass().getResource("/memory_game/resources/level3/"+pict_no3[but1]+".jpg"));
     Btn3[but1].setIcon(img);
     if(no_click==0){
         Btn3[but1].setEnabled(false);
         Btn3[but1].setDisabledIcon(img);
         no_click = 1;
         first_but = but1;
     } else if(no_click==1)
        {
           match(but1);
           Btn3[but1].setDisabledIcon(img);
       }
}
 public void match(int n)
 {
     if(level==0)
     {
              steps++;
              step.setText(steps+" Clicks ");  
              if(pict_no0[first_but] != pict_no0[n])
              {
                    matchBtns0[n]=false;
                    matchBtns0[first_but]=false;
                    timer.start();
              }
              else{
                    matchBtns0[n]=true;
                    matchBtns0[first_but]=true;
                    Btn0[n].setEnabled(false);
                    Btn0[first_but].setEnabled(false);
                    status++;
                    endgame();
              }
              no_click = 0; 
    }
      else if(level==1)
     {
                steps++;
               step.setText(steps+" Clicks ");  
              if(pict_no1[first_but] != pict_no1[n])
              {
                    matchBtns1[n]=false;
                    matchBtns1[first_but]=false;
                    timer.start();
              }
              else{
                    matchBtns1[n]=true;
                    matchBtns1[first_but]=true;
                    Btn1[n].setEnabled(false);
                    Btn1[first_but].setEnabled(false);
                    status++;
                    endgame();
              }
              no_click = 0;         
     }
     else if(level==2)
             {
             steps++;
              step.setText(steps+" Clicks ");  
              if(pict_no2[first_but] != pict_no2[n])
              {
                    matchBtns2[n]=false;
                    matchBtns2[first_but]=false;
                    timer.start();
              }
              else{
                    matchBtns2[n]=true;
                    matchBtns2[first_but]=true;
                    Btn2[n].setEnabled(false);
                    Btn2[first_but].setEnabled(false);
                    status++;
                    endgame();
              }
              no_click = 0;
             }
     else if(level==3)
     {
                steps++;
                step.setText(steps+" Clicks ");  
              if(pict_no3[first_but] != pict_no3[n])
              {
                    matchBtns3[n]=false;
                    matchBtns3[first_but]=false;
                    timer.start();
              }
              else{
                    matchBtns3[n]=true;
                    matchBtns3[first_but]=true;
                    Btn3[n].setEnabled(false);
                    Btn3[first_but].setEnabled(false);
                    status++;
                    endgame();
              }
              no_click = 0;         
     }
 }
 public void level0_timer(ActionEvent e)
 {
    
     for(int i = 0; i < 4; i++)
     {
         if(this.matchBtns0[i]==false)
         {
            Btn0[i].setIcon(null);
            Btn0[i].setEnabled(true);
         }
     }
}
 public void level1_timer(ActionEvent e)
 {
    
     for(int i = 0; i < 12; i++)
     {
         if(this.matchBtns1[i]==false)
         {
            Btn1[i].setIcon(null);
            Btn1[i].setEnabled(true);
         }
     }
}
public void level2_timer(ActionEvent e)
{
    
     for(int i = 0; i < 16; i++)
     {
         if(this.matchBtns2[i]==false)
         {
            Btn2[i].setIcon(null);
            Btn2[i].setEnabled(true);
         }
     }
}
public void level3_timer(ActionEvent e)
{
    
     for(int i = 0; i < 20; i++)
     {
         if(this.matchBtns3[i]==false)
         {
            Btn3[i].setIcon(null);
            Btn3[i].setEnabled(true);
         }
     }
}
 public void endgame()
 {
     if(level==0 && status==2)
     {
          timerGame.stop();       
          JOptionPane.showMessageDialog(this,"CONGRATULATIONS!! "+"\nYou win.\nNo. of Clicks: "+steps + "\nYou have completed the game in "+(10-timeleft)+"seconds","Game Over", JOptionPane.NO_OPTION);
           play.setEnabled(true);
           scn.setVisible(false); 
           scn1.setVisible(true);
           level = 1;
           play.doClick(); 
     }
     if(status==8 && level==2)
     {
          timerGame.stop();
          JOptionPane.showMessageDialog(this,"CONGRATULATIONS!! "+"\nYou win.\nNo. of Clicks: "+steps + "\nYou have completed the game in "+(60-timeleft)+"seconds","Game Over", JOptionPane.NO_OPTION);
          play.setEnabled(true);
          int hes = steps+(60-timeleft);
          if(hes <= 40)
          {
              level = 3;
              level_type = 0;
              scn2.setVisible(false);
              scn3.setVisible(true);
          }
          else if(hes <= 50)
          {
            if(level_type == 0)
            {
             level_type = 2;   
            }
            else if(level_type==1 || level_type==2)
            {
              level=3;
              level_type = 0;
              scn2.setVisible(false);
              scn3.setVisible(true);
            }
          }
          else if(hes <= 65)
          {
            if(level_type == 0)
            {
             level_type = 1;   
            }
            else if(level_type == 1)
            {
             level_type = 2;   
            }
            else if(level_type == 2)
            {
              level=3;
              level_type = 0;
              scn2.setVisible(false);
              scn3.setVisible(true);
           }
         }
         else
         {
              level = 2;
         }
         
          play.doClick(); 
     }
     if(level==1 && status==6)
     {
            timerGame.stop();
           JOptionPane.showMessageDialog(this,"CONGRATULATIONS!! "+"\nYou win.\nNo. of Clicks: "+steps + "\nYou have completed the game in "+(45-timeleft)+"seconds","Game Over", JOptionPane.NO_OPTION);
           play.setEnabled(true);
          

           
           int hes = steps+(45-timeleft);
           
           if(hes <= 25)
           {
              level = 2;
              level_type = 0;
              scn1.setVisible(false);
              scn2.setVisible(true);
           }
           else if(hes <= 35)
           {
                  level = 1;
                  if(level_type == 0)
                  {
                      level_type = 2;
                  }
                  else if(level_type ==2 || level_type==1)
                  {
                        level = 2;
                        level_type = 0;
                        scn1.setVisible(false);
                        scn2.setVisible(true);
                 }
                 set_button1(); 
           }
           else if(hes <= 60)
           {
                    level = 1;
                    if(level_type == 0)
                    {
                      level_type = 1;
                    }
                    else if(level_type == 1)
                    {
                        level_type = 2;
                    }
                    else if(level_type ==2)
                    {
                        level = 2;
                        level_type = 0;
                        scn1.setVisible(false);
                        scn2.setVisible(true);
                    }
                    set_button1();
                    
            }
            else
            {
                level = 1; 
                set_button1();
            }
           play.doClick(); 
     
     }
     if(level==3 && status==10)
     {
            timerGame.stop();  
            JOptionPane.showMessageDialog(this,"CONGRATULATIONS!! "+"\nYou win.\nNo. of Clicks: "+steps + "\nYou have completed the game in "+(75-timeleft)+"seconds","Game Over", JOptionPane.NO_OPTION);
            play.setEnabled(true);
          int hes = steps + (75-timeleft);
          if(hes <= 70)
          {
             if(level_type==0 || level_type==1)
             {
                 level_type = 2;
             }
             else if(level_type==2)
             {
                scn3.setVisible(false);
                q.setVisible(false);
                r.setVisible(false);
                scn4.setVisible(true);  
             }
          }
          else if(hes <= 110)
          {
             if(level_type==0)
             {
               level_type = 1;   
             }
             else if(level_type==1)
             {
                 level_type = 2;
             }
             else if(level_type==2)
             {
                scn3.setVisible(false);
                q.setVisible(false);
                r.setVisible(false);
                scn4.setVisible(true);  
             }
           
          }
          else
          {
              level = 3;
          }
     }
          play.doClick();
          
 }
 public void time_less()
 {
      JOptionPane.showMessageDialog(this,"SORRY!! "+"\nYou Loss."+ "\nYou not completed the game in time limit \n Please try again ","Game Over", JOptionPane.NO_OPTION);
      play.setEnabled(true);
      play.doClick();
      time.setText("Time");
 } 
  void help_actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(this," How to Play \n - First click on play button \n- You should flip open the same pair of images as fast as possible. \n- You must complete the memory game within the time limit.","How to Play",JOptionPane.PLAIN_MESSAGE);
    }

    private void set_button1() {
        for(int i = 0; i < 4; i++)
        {
            Btn0[i].setIcon(null);
        }
    }
 
}

class BackGroundPanel extends Panel {
Image backGround;
    BackGroundPanel() {
    super();
    }
    @Override   
    public void paint(Graphics g) {
     g.drawImage(getBackGroundImage(),0,0,(int)getBounds().getWidth(),(int)getBounds().getHeight(),this);
    }
    public void setBackGroundImage(Image backGround) {
        this.backGround = backGround;
    }
    private Image getBackGroundImage() {
        return backGround;
    }
}