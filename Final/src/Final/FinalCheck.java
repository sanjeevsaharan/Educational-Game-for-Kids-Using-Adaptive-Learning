/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Final;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.applet.Applet;

/**
 *
 * @author mukesh
 */
public class FinalCheck extends Applet {
     Timer timerGame = new Timer(1000,null);
    Font f = new java.awt.Font("TimesRoman", Font.BOLD, 23);
    int score = 0,timeleft= 0,level = 1;
    int seqence = 0;
    private AudioClip sound1;
    private AudioClip sound2;
    @Override
    public void init(){
       screen1();
       screen3();
       screen2();
       screen4();

        setSize(700,500);

        setBackground(Color.orange);

    }
    //------------screen4-----------
    Panel result = new  Panel();
      Label  viewresult=new Label("");
    public void screen4(){
        result.setVisible(false);
        result.setBounds(150, 100, 400, 400);
        result.setLayout(new GridLayout(1,1, 10, 10));
        viewresult.setText("---Congratulation yu completed all the level of Game--");
        result.add(viewresult);
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

   // Choice choose_game;
    Label choose;
    //----------------------------screen1 formation--------------------------------
    public void screen1(){
         scn1.setLayout(new GridLayout(5,1,10,10));

   //     choose_game = new Choice();
        choose=new Label("");



   //     Font f = new java.awt.Font("TimesRoman", Font.BOLD, 40);
        add_game = new Label("English Game",Label.CENTER);
        welcome = new Label("Welcome",Label.CENTER);
        user_name = new Label("Enter your Name:");
        name = new TextField(10);
        play = new Button("Play");
        play.setBackground(Color.LIGHT_GRAY);
        scn1.add(add_game);
        scn1.add(welcome);
        c.add(user_name);
        c.add(name);
        scn1.add(c);
        e.add(play);
        //e.add(choose_game);
        scn1.add(e);

        //d.add(play);
        scn1.add(d);

        scn1.setBackground(Color.ORANGE);

        scn1.setFont(f);
        this.add(scn1);
        scn1.setVisible(true);
        //name.addActionListener((ActionListener) this);

        play.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                play_actionPerformed(e);
            }
        });

    }

       JFrame frame = new JFrame();
       Panel scn3 = new Panel();
       Panel sc = new Panel();
       Label con_sor;
       Label level_status;
       Label show_scr_time;
       Button try_next;
    //----------------------screen3 formation------------------------------------------------
    public void screen3()
    {
       // frame.setVisible(false);
       // frame.add(scn3);
       scn3.setVisible(false);

       scn3.setLayout(new GridLayout(4,1,10,10));


       con_sor=new Label("Congratulations",Label.CENTER);
       level_status=new Label("You Completed this Level",Label.CENTER);
       show_scr_time=new Label("Your Score is "+0+" and Time is "+0+" ",Label.CENTER);
       try_next=new Button("Click Here To go Next Level");


      //  Font f = new java.awt.Font("TimesRoman", Font.BOLD, 40);
        scn3.add(con_sor);
        scn3.add(level_status);
        scn3.add(show_scr_time);
        scn3.add(try_next);

        scn3.setFont(f);
        scn3.setBackground(Color.ORANGE);
        scn3.setBounds(0,0,700,500);
        frame.setBounds(150,0,700,400);
        this.add(scn3);
       try_next.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try_next_actionPerformed(e);
            }


        });


    }

    //------------------Decide next level------------------------

    public void try_next_actionPerformed(ActionEvent e){
        scn3.setVisible(false);
        level = heauricticFuction();    //heauristic function call
        seqence = 0;
        score = 0;
        timeleft = 0;
        l2.setText("Score: " + score);
        if (level == 1)
            level1();
        else if(level == 2)
        level2();
        else if (level == 3)
            level3();
        else if (level == 4)
            level4();
        else if (level == 5)
            level5();
        else if ( level == 6 ){

            result.setVisible(true);
            System.out.println("----------finisg game-------------");
        }

        timerGame.start();      //start timer

        play(seqence);      //call play function


    }
//-------------------------function for calculating the heauristic value----------------
    public int heauricticFuction(){
        int heauristicValue = 0;
        if ( timeleft >= 50 || score < 0 ) {
            heauristicValue = level;
        } else if ( timeleft > 0 && timeleft < 35) {
            if ( score >= 65 ){
                heauristicValue = level + 1;
            } else {
                heauristicValue = level;
            }
        } else if ( timeleft >= 35 && timeleft < 50 ) {
            if (score > 75) heauristicValue = level + 1;
            else heauristicValue = level;
        }

        return heauristicValue;

    }


//---------------screen1 play button action ------------------
    public void play_actionPerformed(ActionEvent e){
        scn1.setVisible(false);
        timerGame.start();
        p.setVisible(true);
        q.setVisible(true);
        r.setVisible(true);
        s.setVisible(true);
        t.setVisible(true);
        u.setVisible(true);
        l3.setText(name.getText());
       // screen2();
    }
    Button[] b = new Button[5];
    //BackGroundPanel p = new BackGroundPanel();
    Panel p =  new  Panel();
    Panel q = new  Panel();
    Panel r = new  Panel();
    Panel s = new Panel();
    Panel t =  new  Panel();
    Panel u  = new Panel();
    JLabel l11= new JLabel();
    Button b1 = new Button("Help");
    Button b2  = new  Button("Reset");
    JButton b3 = new JButton("Next");
    JRadioButton j1 = new JRadioButton("Sound On/Off",true);

    Label user = new Label("Welcome ",Label.CENTER);

    Label l1 = new Label("Time:" +timeleft);
    Label l2 = new Label("Score: " + score);
    Label l3 = new Label("Welcome  "  );
    Label l4 = new Label("Welcome  "  );
    Label l5 = new Label("level:");
    int quest = seqence + 1;
    Label l6 = new Label("Q "+ quest+")");
    JTextField j2 = new JTextField("mm");
    final JTextField j3 = new JTextField("mm");

//-----------------------screen2 frmation-----------------------------------------
    public void screen2()
    {
        sound1 = getAudioClip( getClass().getResource("/Final/resources/right.mp3" ));

        sound2 = getAudioClip( getClass().getResource("/Final/resources/wrong.mp3" ));

         p.setBackground(Color.LIGHT_GRAY);
        q.setBackground(Color.blue);
        r.setBackground(Color.blue);
        s.setBackground(Color.black);
        t.setBackground(Color.blue);
        u.setBackground(Color.GRAY);

        j1.setFont(f);

   //  final Button[] b = new Button[5]; // array of button type

        b1.setBackground(Color.gray);
        b1.setActionCommand("help");
        b3.setActionCommand("next");
        b2.setActionCommand("reset");
        b2.setBackground(Color.gray);
        b3.setEnabled(true);

        j1.setBackground(Color.gray);
        l1.setBackground(Color.GRAY);
        l2.setBackground(Color.GRAY);
        l5.setBackground(Color.GRAY);
        j2.setBackground(Color.gray);


        for ( int i = 1; i < 5; i++ ){

             b[i] = new Button("ggggggggg");
             b[i].setBackground(Color.cyan);
             s.add(b[i]);
        }
      //set layout of panel
        s.setLayout(new GridLayout(2, 2, 5, 5));
        r.setLayout(new GridLayout(1, 2, 10, 10));
        q.setLayout(new GridLayout(5, 1, 5, 5));
        t.setLayout(new GridLayout(1, 2, 10, 10));
        u.setLayout(new GridLayout(3, 1, 5, 5));
        l6.setAlignment(Label.LEFT);
        l11.setBounds(150, 50, 300, 200);
        p.add(l11);
        q.add(l5);
        q.add(b1);
        //q.add(b2);
        q.add(j1);
        q.add(l1);
        q.add(l2);


        t.add(l4);
        t.add(l3);
        u.add(l6);
       // r.add(l5);
        //r.add(l4);

   //add panel in applet
        add(p);
        add(q);
        add(r);
        add(s);
        add(t);
        add(u);

    // set bound to all panel
        t.setBounds(0, 0, 500, 50);
        r.setBounds(0,400,700,100);
        s.setBounds(10,260,480,130);
        p.setBounds(100,50,400,200);
        q.setBounds(500,0,200,400);
        u.setBounds(0, 50, 100, 200);

        p.setVisible(false);
        q.setVisible(false);
        r.setVisible(false);
        s.setVisible(false);
        t.setVisible(false);
        u.setVisible(false);
        setFont(f);
         ActionListener actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    sideActionPerformed(e);
                }
            };
            b1.addActionListener(actionListener1);
            b2.addActionListener(actionListener1);
            b3.addActionListener(actionListener1);
             for (int i = 1;i <= 4; i++) {
                b[i].addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    optionFormation(e);
                }
            });
            }
            timerGame.addActionListener(new java.awt.event.ActionListener()
     {
            @Override
       public void actionPerformed(ActionEvent e)
       {
        timerGame_actionPerformed(e);
       }

            private void timerGame_actionPerformed(ActionEvent e) {

                    timeleft++;

                 l1.setText("Time : "+timeleft +" Sec ");


            }
     });
            level1();
            play(seqence);
        }

    Specific_Random srand;
    //-------------------------level random value range generator function--------------------
    public void level1(){
        srand = new Specific_Random(1, 10);
    }
    public void level2(){
        srand = new Specific_Random(11, 20);
    }
    public void level3(){
        srand = new Specific_Random(21, 30);
    }
    public void level4(){
        srand = new Specific_Random(31, 40);
    }
    public void level5(){
        srand = new Specific_Random(41, 50);
    }


    ImageIcon img;
    Mapp m = new Mapp();
    Integer k, k1;
    int kans;
    String ans="",sol="",ss="";
    String ansOpt[] = new String[5];

          Image image;
    public void play(int seq){
        image = null;
    //    System.out.println("seq in play="+seq);
        RandomNumberGenerator rand1 = new RandomNumberGenerator(4);
        k= srand.generateNewRandom(seq);
        img = new ImageIcon(getClass().getResource("/Final/resources/"+k+".png"));
//System.out.println("/Final/resources/"+k+".png");
     //   image = getImage(getClass().getResource("/Final/resources/"+k+".png"));
        ss = m.map_test(k);
        k1 = rand1.generateNewRandom(0);
        kans = k1;
        ans = ""+ k1;
        sol = ans;
        ss =  ""+ans+")  " + ss;
        ansOpt[k1]= ss;
        b[k1].setActionCommand(ans);
        for ( int i = 1; i< 4; i++ ) {
                k1 = rand1.generateNewRandom(i);
                Integer kk =  (k+i <= 50) ? k+i : i;
                ans = ""+k1;
                b[k1].setActionCommand(ans);
                ansOpt[k1]= ans + ")  " +m.map_test(kk);
        }
        setValue();     //call setValue function
    }
    //---------------------set value of image and option on screen2--------------
    public void setValue(){
        l5.setText("Level : " + level);
        quest = seqence + 1;
        l6.setText("Q "+ quest+")");

        l11.setIcon(img);
        //p.setBackGroundImage(image);
        for (int i = 1; i <= 4; i++ )  b[i].setLabel(ansOpt[i]);

    }
    int flagh= 0,flags=0;
    //----------------------update the values of option on screen2-----------------
    public void updateValue(String pos){
        Integer i = Integer.valueOf(pos);
         l2.setText("Score: "+score);

         if (flagh == 1||flags == 1){
             b[i].setBackground(Color.GREEN);
             flagh = 0;
             flags = 0;
         }
        else if(flags == 2)
        {
            //System.out.println("wrong ans= " );
             b[i].setBackground(Color.red);
             flags = 0;
         }
    }
//-----------------check that solution is right r wrong and move to next question-------------
     public void optionFormation(ActionEvent e){
         if (sol.equals(e.getActionCommand())){

              b3.setEnabled(true);
              score = score + 10;
              flags = 1;
              if(j1.isSelected())
              {
               sound1.play();
             }
              updateValue(e.getActionCommand());
              //b3.doClick();

          }else {
             if(j1.isSelected())
             {
               sound2.play();
             }
               score = score - 5;
               flags = 2;
               updateValue(e.getActionCommand());
          }

         delay();
         int i = Integer.parseInt(e.getActionCommand());
         b[i].setBackground(Color.cyan);
         b3.doClick();
    }

     //-------------help and next button action-----------------
     public void sideActionPerformed(ActionEvent e) {
        if ("help".equals(e.getActionCommand())){
            flagh =1;
            score = score - 5;
            updateValue(sol);
            delay();
            b3.doClick();
          } else if ("next".equals(e.getActionCommand())){
              seqence = seqence+1;
              b[kans].setBackground(Color.cyan);
              checkLevel(seqence);
              if (seqence < 10){
              play(seqence);}

          } else if ("reset".equals(e.getActionCommand())){
              j3.setText("you r r");
              System.out.println("reset button");

        }
    }
     //---------------check that level is completed or not------------------
     public void checkLevel( int seq){
              if (seq ==10  ) {
             //level = level + 1;
             int displevel = level;
             level_status.setText("You Completed this Level "+ displevel);
             show_scr_time.setText("Your Score is "+score+" and Time is "+timeleft+" ");
             timerGame.stop();
              scn3.setVisible(true);
        //     frame.setVisible(true);
         }

     }
     //---------------for delay-------------------------------------
     public void delay(){
          try {
                Thread.sleep(500);

          }catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
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
