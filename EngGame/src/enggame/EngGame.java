/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enggame;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 *
 * @author MANGALDEEP
 */
public class EngGame extends Applet implements ActionListener{

    Timer time = new Timer(500,null);
    int score = 0;
    Button[] but = new Button[4];
    Image back[]=new Image[11];

    Panel q = new  Panel();
    Panel r = new  Panel();
    Panel s = new Panel();
   
    
    Button b1 = new Button("Help");
    Button b2  = new  Button("Reset");
    Button b3 = new Button("Next");
    JRadioButton j1 = new JRadioButton("Sound On/Off");
    Label l1 = new Label("Time:");
    final Label l2 = new Label("Score: " + score);
    
    String op[] = new String[44];
    int ans[]=new int[11];
    Font f = new java.awt.Font("TimesRoman", Font.BOLD, 23);
    Color cl = new Color(137,26,254);
    Button help1 = new Button(" Life  1 ");
    Button help2 = new Button(" Life  2 ");
    Label lab[]=new Label[11];
    public void screen2()
    {
        q.setVisible(false);
        r.setVisible(false);
        s.setVisible(false);
      
        r.setLayout(new GridLayout(11,1,3,3));
        for(int i = 0; i < 4; i++)
        {
            but[i]=new Button("AAAAAAAA");
            q.add(but[i]);
            but[i].addActionListener(this);
            but[i].setBackground(Color.DARK_GRAY);
            but[i].setFont(f);
        }
     
        for(int i = 0; i < 11; i++)
        {
            lab[i]=new Label("$ kkkkkkk",Label.CENTER);
            r.add(lab[i]);
            lab[i].setBackground(Color.ORANGE);
        }
         lab[3].setBackground(Color.PINK);
         lab[0].setBackground(Color.PINK);
         lab[6].setBackground(Color.PINK);
        s.add(help1);
        s.add(help2);
        setLabel();
        r.setFont(f);
        s.setFont(f);
      
        q.setBounds(20,370,460,150);
        r.setBounds(520,10,200,500);
        s.setBounds(50,540,400,50);
        q.setLayout(new GridLayout(2,2,10,10));
        s.setLayout(new GridLayout(1,2,50,50));
        q.setBackground(cl);
        s.setBackground(cl);
      
        help1.addActionListener(this);
        help2.addActionListener(this);
        help1.setBackground(Color.GREEN);
        help2.setBackground(Color.GREEN);
    
        this.add(q);
        this.add(r);
        this.add(s);
        time.setRepeats(false);
        time.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
       
    }
 
   @Override
    public void init(){
       
        for(int i = 0; i < 11; i++)
        {
          back[i] = getImage(getClass().getResource("/EngGame/resources/"+(i+1)+".jpg"));
        }
         setBackground(cl);
        setString();
        
        screen1();
        
        screen3();
        screen4();
        screen2();
        setSize(900,600);
       

    }
   int a = 0;
   int que = 0;
   public void update_op()
   {
       repaint();
      
       for(int i = 0; i < 4; i++)
       {
        but[i].setLabel(op[a]);
        but[i].setBackground(Color.LIGHT_GRAY);
        a++;
      }
      
   }
   public void setLabel()
   {
        lab[10].setText("$100");
         lab[9].setText("$500");
          lab[8].setText("$1000");
           lab[7].setText("$2000");
            lab[6].setText("$5000");
             lab[5].setText("$10000");
              lab[4].setText("$20000");
               lab[3].setText("$50000");
                lab[2].setText("$100000");
                 lab[1].setText("$500000");
                  lab[0].setText("$1000000");
         for(int i = 0; i < 11; i++)
        {
           lab[i].setBackground(Color.ORANGE);
        }
          lab[3].setBackground(Color.PINK);
         lab[0].setBackground(Color.PINK);
         lab[6].setBackground(Color.PINK);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        int an=ans[que];
        int butn = 0;
        for(int i = 0; i < 4; i++)
        {
            if(e.getSource()==but[i])
            {
                butn = i;
            }
        }
        if(e.getSource()==sor1)
        {
            setLabel();
            que = 0;
            a = 0;
            update_op();
            scn5.setVisible(false);
          
            q.setVisible(true);
            r.setVisible(true);
            s.setVisible(true);
            help1.setVisible(true);
            help2.setVisible(true);
        }
        else
        {
        if(e.getSource()==help1)
        {
            butn = an;
            help1.setVisible(false);
        }
        else if(e.getSource()==help2)
        {
            butn = an;
            help2.setVisible(false);
        }
        if(butn==an)
        {
           
            if(10-que==3 || 10-que==0 || 10-que==6)
            {
               lab[10-que].setBackground(Color.green); 
               if(10-que==6)
               {
                   lab[10-que].setText("$5000 **");
               }
               if(10-que==3)
               {
                   lab[10-que].setText("$50000 **");
               }
               if(10-que==0)
               {
                   lab[10-que].setText("$1000000");
               }
            }
            else  lab[10-que].setBackground(Color.green);
            que++;
            if(que==11)
            {
                delay();
                delay();
                q.setVisible(false);
                r.setVisible(false);
                s.setVisible(false);
                
                
                scn3.setVisible(true);
            }
            else{
                but[butn].setBackground(Color.green);
                
                delay();
                
               
                
               update_op();
               
            }
        }
        else
        {
          but[butn].setBackground(Color.red);
          delay();
          but[butn].setBackground(Color.LIGHT_GRAY);
          but[an].setBackground(Color.green);
          delay();
          but[an].setBackground(Color.LIGHT_GRAY);
          delay1();
          but[an].setBackground(Color.green);
          delay();
          
          q.setVisible(false);
          r.setVisible(false);
          s.setVisible(false);
          scn5.setVisible(true);
          
        }
      }
    }
    public void delay()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(EngGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delay1()
    {
        try {
            Thread.sleep(100);
        }   catch (InterruptedException ex) {
            Logger.getLogger(EngGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @Override
    public void paint(Graphics g) {
        if(q.isVisible())
        {
             g.drawImage(back[que], 10, 10, this);
        }

    } 
    Panel scn1 = new Panel();
    Label add_game;
    Label welcome;
    Label user_name;
    TextField name;
    Button play;

    Panel c = new Panel();
    Panel d = new Panel();
    Panel e = new Panel();
    public void screen1(){
        scn1.setLayout(new GridLayout(5,1,10,10));
 
        add_game = new Label("Picture Quiz Game",Label.CENTER);
        welcome = new Label("Welcome",Label.CENTER);
        user_name = new Label("Enter your Name:");
        name = new TextField(10);
        play = new Button("Play");
        scn1.add(add_game);
        scn1.add(welcome);
        c.add(user_name);
        c.add(name);

        scn1.add(c);
        scn1.add(e);

        d.add(play);
        scn1.add(d);

        scn1.setBackground(cl);

        scn1.setFont(f);
        this.add(scn1);
        scn1.setVisible(true);
        play.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                play_actionPerformed(e);
            }

            private void play_actionPerformed(ActionEvent e) {
                scn1.setVisible(false);
                q.setVisible(true);
                r.setVisible(true);
                s.setVisible(true);
                 update_op();
            }
        });


    }
    public void setString()
    {
        op[0]="Leopard";
        op[1]="Lion";
        op[2]="Tiger";
        op[3]="Panther";
        op[4]="Dog";
        op[5]="Cat";
        op[6]="Rabbit";
        op[7]="Fox";
        op[8]="Elephant";
        op[9]="Bear";
        op[10]="Lion";
        op[11]="Tiger";
        op[12]="Dog";
        op[13]="Cat";
        op[14]="Fox";
        op[15]="Monkey";
        op[16]="Leopard";
        op[17]="Fox";
        op[18]="Bear";
        op[19]="Cat";
        
        op[20]="Fox";
        op[21]="Cat";
        op[22]="Cow";
        op[23]="Goat";
        
        op[24]="Cat";
        op[25]="Dog";
        op[26]="Rat";
        op[27]="Goat";
        
        op[28]="Panther";
        op[29]="Fox";
        op[30]="Tiger";
        op[31]="Lion";
        
        op[32]="Panther";
        op[33]="Bear";
        op[34]="Cat";
        op[35]="Fox";
        
        op[36]="Goat";
        op[37]="Buffelow";
        op[38]="Cow";
        op[39]="Dear";
        
        op[40]="Cow";
        op[41]="Buffelow";
        op[42]="Goat";
        op[43]="Elephant";
        
        ans[0]=2;
        ans[1]=1;
        ans[2]=0;
        ans[3]=3;
        ans[4]=2;
        
        ans[5]=3;
        ans[6]=1;
        ans[7]=0;
        ans[8]=3;
        ans[9]=2;
        ans[10]=1;     
    }
    Panel scn3 = new Panel();
    Label con;
    public void screen3()
    {
        con=new Label(" Congratulation  You Done the Game ",Label.CENTER);
        
        scn3.add(con);
        con.setBackground(Color.ORANGE);
        this.add(scn3);
        con.setFont(f);
        scn3.setBounds(0,0,900,500);
        scn3.setBackground(cl);
        scn3.setVisible(false);
    }
    Panel scn4 = new Panel();
     Panel scn5 = new Panel();
    Label sor;
    Button sor1;
    public void screen4()
    {
       
        scn4.setLayout(new GridLayout(2,1,10,10));
        con=new Label(" Sorry, You Lose the Game ",Label.CENTER);
        sor1 = new Button("Please try Again");
        sor1.addActionListener(this);
        scn4.add(con);
        scn4.add(sor1);
        scn5.add(scn4);
        con.setBackground(Color.ORANGE);
        this.add(scn5);
        con.setFont(f);
        sor1.setFont(f);
        
        scn4.setBounds(300,20,300,100);
        scn5.setBounds(0,0,900,500);
        scn4.setBackground(cl);
        scn5.setVisible(false);
        scn5.setBackground(cl);
    }
    
}



class BackGroundPanel extends Panel {

    Image backGround;

    BackGroundPanel() {
        super();
    }

    @Override
    public void paint(Graphics g) {
// get the size of this panel(which is the size of the applet) and draw the image
        g.drawImage(getBackGroundImage(), 0, 0, (int) getBounds().getWidth(), (int) getBounds().getHeight(), this);
    }

    public void setBackGroundImage(Image backGround) {
        this.backGround = backGround;
    }

    private Image getBackGroundImage() {
        return backGround;
    }
    
}


  