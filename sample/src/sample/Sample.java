/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;


/**
 *
 * @author MANGALDEEP
 */
public class Sample extends Applet implements ActionListener,KeyListener{
    
    Font f = new java.awt.Font("TimesRoman", Font.BOLD, 25);
    Timer time = new Timer(50,null);
    
    Panel q = new Panel();
    BackGroundPanel bgp = new BackGroundPanel();
    JButton btn[] = new JButton[26];
    ImageIcon img ;
    Image backGround;
    int pict_no = 1;
    AudioClip sound[]=new AudioClip[26];
    @Override
    public void init()
    {
        add(bgp);
        add(q);
        q.setLayout(new GridLayout(6,5,5,5));
        Label a1 = new Label();
        Label a2 = new Label();
        a1.setBackground(Color.BLUE);
        a2.setBackground(Color.BLUE);
        for(int i = 0; i < 26; i++)
        {
            btn[i]=new JButton();
            q.add(btn[i]);
            btn[i].addActionListener(this);
            btn[i].addKeyListener(this);
             img = new ImageIcon(getClass().getResource("/sample/resources/"+pict_no+".gif"));

           
            btn[i].setIcon(img);
            btn[i].setBackground(Color.GREEN);
            sound[i]= getAudioClip(getClass().getResource("/sample/resources/sound/"+pict_no+".mp3"));
            pict_no++;
        }
        q.add(a1);
        q.add(a2);
        q.add(btn[25]);
        backGround = getImage(getClass().getResource("/sample/resources/abc.jpg"));
        bgp.setBackground(Color.BLUE);
        bgp.setBackGroundImage(backGround);
        this.setLayout(new BorderLayout());
        bgp.setBounds(0,0,500,415);
        q.setBounds(510,0,500,500);
        q.setBackground(Color.BLUE);
        this.setSize(1020,500);
        this.setBackground(Color.BLUE);
        time.setRepeats(false);
        
        time.addActionListener(new java.awt.event.ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            timer_actionPerformed(e);
        }

            private void timer_actionPerformed(ActionEvent e) {
               if(!btn[post].isEnabled())
               {
                int k = post+1;   
                img = new ImageIcon(getClass().getResource("/sample/resources/"+k+".gif"));
                btn[post].setIcon(img);
                btn[post].setEnabled(true);
                
               }
            }

        });

        }
    int post;
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getSource().toString();
      for(int i = 0; i < 26; i++)
      {
        if(e.getSource()==btn[i])
        {
            post = i;
        }
            
      }
      sound[post].play();
      btn[post].setIcon(null);
      btn[post].setEnabled(false);
      int p1 = post+1;
      backGround = getImage(getClass().getResource("/sample/resources/image/"+p1+".jpg"));
      bgp.setBackGroundImage(backGround);
      bgp.repaint();
      time.start();
      
      
    } 

    @Override
    public void keyTyped(KeyEvent e) {
        char cb = e.getKeyChar();
        int p1 = (int)cb;
        if(p1 < 97)
        {
            post = p1-65;
        }
        else{ 
            post = p1-97;
        }
        btn[post].doClick();

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void paint(Graphics g) {
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
