package mathgame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MathGame extends Applet implements ActionListener{

    Image back[]= new Image[11];
    String player_name;
    Gen_ran g = new Gen_ran();
    static int[] answers;
    static String[] problems;
    static int[] indexs;
    int level = 0;
    int timeleft;
    String game_str = "Addition";
    Timer timerGame = new Timer(1000, null);
    Timer timer = new Timer(500, null); // for delay display button
    private AudioClip sound1;
    private AudioClip sound2;
   
    public void call() {
       sound1 = getAudioClip(getClass().getResource("/mathgame/resources/correct.mp3"));
       sound2 = getAudioClip(getClass().getResource("/mathgame/resources/wrong.mp3"));

        g.newgame(game_str, level);
        answers = Gen_ran.answer;
        problems = Gen_ran.prob;
        indexs = Gen_ran.index;
    }
    @Override
    public void init() {
     
        for(int i = 0; i < 11; i++)
        {
         back[i] = getImage(getClass().getResource("/mathgame/resources/back/"+(i+1)+".jpg"));
        }
        screen1();
        screen2();
        screen3();
        setSize(1000, 550);
    }
    int but_n = 1;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == reset) {
            if (level == 0 || level == 1 || level == 4 || level == 5 || level == 7) {
                init_board();
            }
            if (level == 2 || level == 3 || level == 6 || level == 8 || level == 9) {
                next_type();
            }
        } else {
            String text = (String) e.getActionCommand();
            String matchwitht = matchwithcard.getText();
            if (but_n == 1) {
                timerGame.start();
                reset.setEnabled(true);
                but_n = 0;
            }

            Calculate ca = new Calculate();
            boolean t = ca.cal_but(text, matchwitht);
            if (t == true) {
                if (sound.getState()) {
                    sound1.play();
                }
                 for(int i = 0; i < 16; i++)
                 {
                     if(e.getSource()==but[i])
                     {
                      but[i].setVisible(false);
                     }
                 }


                card_pos++;
                if (level == 0 || level == 1 || level == 4 || level == 5 || level == 7) {
                    update_index();
                }
                if (level == 2 || level == 3 || level == 6 || level == 8 || level == 9) {
                    next_type_index();
                }

            } else if (t == false) {
                if (sound.getState()) {
                    sound2.play();
                }
                for(int i = 0; i < 16; i++)
                {
                if (e.getSource() == but[i]) {

                    but[i].setLabel("InCorrect");
                    but[i].setBackground(Color.red);
                    del();
                    but[i].setLabel(text);
                    but[i].setBackground(Color.CYAN);

                }
                }
            }

            update_score(t);
            update_step();
            if (card_pos == 16) {
                change_level();
            }
        }
    }

    public void change_level() {
        timerGame.stop();
        scn3.setVisible(true);
         scn31.setVisible(true);
         scn31.setBackGroundImage(back[ran_pic]);
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);
        show_scr_time.setText("Your Score is " + get_score + " and Time is " + timeleft + " Sec ");
        but_n = 1;
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
    Choice choose_game;
    Label choose;
    Color cl = new Color(137,26,254);
    public void screen1() {
       
      
        choose_game = new Choice();
        choose = new Label("Choose Game:");

        choose_game.add("Addition");
        choose_game.add("Subtraction");
        choose_game.add("Multiplication");
        choose_game.add("Division");
        
        Font f = new java.awt.Font("TimesRoman", Font.BOLD, 40);
        add_game = new Label("Math Game", Label.CENTER);
        welcome = new Label("Welcome", Label.CENTER);
        user_name = new Label("Enter your Name:");
        name = new TextField(10);
        play = new Button("Play");
        
      
      
        add(scn1);
        scn1.setLayout(new GridLayout(5, 1, 10, 10));
        scn1.add(add_game);
        scn1.add(welcome);
        c.add(user_name);
        c.add(name);
        scn1.add(c);
        e.add(choose);
        e.add(choose_game);
        scn1.add(e);

        d.add(play);
        scn1.add(d);
        
    
        scn1.setBackground(cl);
        setBackground(cl);
        scn1.setFont(f);
        add(scn1);
        
        scn1.setVisible(true);
        name.addActionListener(this);
        play.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                play_actionPerformed(e);
            }
        });

        choose_game.addItemListener(new java.awt.event.ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ae) {
                choose_game_itemStateChanged(ae);
            }
        });
    }
    Panel scn3 = new Panel();
    Panel sc = new Panel();
    Label con_sor;
    Label level_status;
    Label show_scr_time;
    Button try_next;
    BackGroundPanel scn31 = new BackGroundPanel();
    public void screen3() {
         scn3.setVisible(false);
         scn31.setVisible(false);
        scn3.setLayout(new GridLayout(4, 1, 10, 10));
        scn31.setBackGroundImage(back[0]);

        con_sor = new Label("Congratulations", Label.CENTER);
        level_status = new Label("You Completed this Level", Label.CENTER);
        show_scr_time = new Label("Your Score is " + 0 + " and Time is " + 0 + " ", Label.CENTER);
        try_next = new Button("Click Here To go Next Level");


        Font f = new java.awt.Font("TimesRoman", Font.BOLD, 40);
        scn3.add(con_sor);
        scn3.add(level_status);
        scn3.add(show_scr_time);
        scn3.add(try_next);

        scn3.setFont(f);
        scn3.setBounds(150, 250, 700, 300);
        scn31.setBounds(150, 0, 680, 250);
        this.add(scn3);
        this.add(scn31);
        try_next.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try_next_actionPerformed(e);
            }
        });


    }
    /*  public void screen4()
    {
    con_sor.setText(" Congratulations ");
    level_status.setText("Failed to Complete this Level");
    show_scr_time.setText("   ");
    try_next.setName("Please Try Again");
    }
    public void screen5()
    {
    con_sor.setText(" Congratulations  ");
    level_status.setText("You Completed this Game");
    show_scr_time.setText("   ");
    try_next.setVisible(false);
    
    }
     */
 //   Panel A2 = new Panel();
    Panel A1 = new Panel();
    Panel A3 = new Panel();
    Panel A4 = new Panel();
    Label matchwithcard;
    Label step;
    JLabel matchwith;
    Label score;
    Label u_name;
    Button[] but = new Button[16];
    Button reset;
    Button nxt_level;
    Button help;
    Label show_timer;
    Checkbox sound;

    BackGroundPanel A2 = new BackGroundPanel();
    public void screen2() {
        A2.setBackGroundImage(back[0]);
        A1.setVisible(false);
        A2.setVisible(false);
        A3.setVisible(false);
        A4.setVisible(false);

        Font f = new java.awt.Font("TimesRoman", Font.BOLD, 30);
        setFont(f);

        u_name = new Label(" Welocme kkkkkkkkkkkk", Label.CENTER);
        A4.add(u_name);
  
        A1.setBackground(cl);

       
     //   A2.setBackground(cl);
        A3.setBackground(cl);
        A4.setBackground(cl);

        A1.setLayout(new GridLayout(5, 1, 8, 8));
        reset = new Button("Reset");
        nxt_level = new Button("Next Level");
        show_timer = new Label("  Time  ", Label.CENTER);
   
        show_timer.setBackground(Color.LIGHT_GRAY);
        sound = new Checkbox(" Sound on/off", true);

  
        help = new Button(" Help ");
        Panel p1 = new Panel();
        p1.add(sound);
        p1.setBackground(Color.LIGHT_GRAY);
        A1.add(reset);
        A1.add(nxt_level);
        A1.add(help);
        A1.add(show_timer);
        A1.add(p1);
        A2.setLayout(new GridLayout(4, 4, 2, 2));

        for (int i = 0; i < 16; i++) {
            but[i] = new Button("kkkkkkkkk");
            A2.add(but[i]);
            but[i].addActionListener(this);

        }
        reset.setBackground(Color.LIGHT_GRAY);
        nxt_level.setBackground(Color.LIGHT_GRAY);
        help.setBackground(Color.LIGHT_GRAY);

        Panel c1 = new Panel();
        Panel c2 = new Panel();
        Panel c3 = new Panel();
        Panel c4 = new Panel();

        A3.setLayout(new GridLayout(1,4,8,8));

        A3.add(c1);
        A3.add(c2);
        A3.add(c3);
        A3.add(c4);

        matchwith = new JLabel("Match With: ");
        matchwithcard = new Label("vderswvvf");
        score = new Label("Score: freev");
        step = new Label("Step: frdbfrg");
        

        matchwith.setFont(f);
        c1.add(score);
        c2.add(step);
        c3.add(matchwith);
        c4.add(matchwithcard);

        c1.setBackground(Color.YELLOW);
        c2.setBackground(Color.YELLOW);
        c3.setBackground(Color.YELLOW);
        c4.setBackground(Color.YELLOW);
        A4.setBounds(0, 0, 1000, 60);
        A1.setBounds(30, 60, 250, 350);
        A2.setBounds(300, 60, 680, 350);
        A3.setBounds(30, 450, 950, 50);
  
        this.add(A4);
        this.add(A1);
        this.add(A2);
        this.add(A3);
        nxt_level.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nxt_level_actionPerformed(e);
            }
        });
        reset.addActionListener(this);


        timerGame.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timerGame_actionPerformed(e);
            }

            private void timerGame_actionPerformed(ActionEvent e) {

                timeleft++;
                show_timer.setText(timeleft + " Sec ");
            }
        });

        help.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                help_actionPerformed(e);
            }
        });

    }
    int get_score;
    int steps;

    void init_board() {
        get_score = 0;
        steps = 0;
        card_pos = 0;
        for (int i = 0; i < 16; i++) {
            
            but[i].setVisible(true);
            but[i].setEnabled(true);
            int d1 = answers[i];
            but[i].setLabel(Integer.toString(d1));
   
        }
        int k = indexs[card_pos];
        matchwithcard.setText(problems[k]);
        score.setText("Score: " + get_score);
        step.setText("Step:  " + steps);
        setButton();
        reset.setEnabled(false);

        timeleft = 0;
        timerGame.stop();
        show_timer.setText(" Time ");
        but_n = 1;

    }
    int ran_pic=0;
    public void setButton() {
        
         ran_pic = (int) (1 + Math.random() * 9);
         A2.setBackGroundImage(back[ran_pic]);
        for (int i = 0; i < 16; i++) {

            but[i].setEnabled(true);
            but[i].setVisible(true);
            but[i].setForeground(Color.BLACK);
            but[i].setBackground(Color.CYAN);
        }
    }

    public void update_score(boolean t) {
        if (t == true) {
            get_score = get_score + 10;
        } else if (t == false && get_score >= 5) {
            get_score = get_score - 5;
        }

        score.setText("Score: " + get_score);


    }

    public void update_step() {
        steps = steps + 1;
        step.setText("Step: " + steps);
    }
    int card_pos = 0;

    public void update_index() {

        if (card_pos <= 15) {
            int k = indexs[card_pos];
            matchwithcard.setText(problems[k]);
        }

    }

    public void next_type() {
        setButton();
        get_score = 0;
        steps = 0;
        card_pos = 0;
        timeleft = 0;
        for (int i = 0; i < 16; i++) {
            but[i].setVisible(true);
            but[i].setEnabled(true);
            String d1 = problems[i];
            but[i].setLabel(d1);
        }
        int k = indexs[card_pos];
        matchwithcard.setText(Integer.toString(answers[k]));
        score.setText("Score: " + get_score);
        step.setText("Step: " + steps);
        reset.setEnabled(false);

        timeleft = 0;
        timerGame.stop();
        show_timer.setText(" Time ");
        but_n = 1;
    }

    public void next_type_index() {
        if (card_pos <= 15) {
            int k = indexs[card_pos];
            matchwithcard.setText(Integer.toString(answers[k]));
        }
    }

    public void play_actionPerformed(ActionEvent e) {
        player_name = name.getText();
        u_name.setText(" Welcome " + player_name);
        scn1.setVisible(false);
        call();
        A1.setVisible(true);
        A2.setVisible(true);
        A3.setVisible(true);
        A4.setVisible(true);
        init_board();
    }

    public void nxt_level_actionPerformed(ActionEvent e) {

        level++;
        if (level == 10) {
            level = 0;
        }
        call();
        go_next_level();

    }

    public void go_next_level() {
        if (level == 0 || level == 1 || level == 4 || level == 5 || level == 7) {

            init_board();
        }
        if (level == 2 || level == 3 || level == 6 || level == 8 || level == 9) {
            next_type();
        }
        /*if(level==9)
        {
        level = -1;
        } */
    }
    int hes;

    public void try_next_actionPerformed(ActionEvent e) {

        A1.setVisible(true);
        A2.setVisible(true);
        A3.setVisible(true);
        A4.setVisible(true);

        scn3.setVisible(false);
        scn31.setVisible(false);
        hes = (50 - (get_score / (int) 5)) + timeleft + steps;
        set_level_hes(hes);

        if (level == 10) {
            level = 0;
        }
        call();

        go_next_level();
    }

    public void help_actionPerformed(ActionEvent e) {
        String m1 = matchwithcard.getText();
        String m2;
        Calculate ca1 = new Calculate();
        for (int i1 = 0; i1 < 16; i1++) {
            if(but[i1].isVisible())
            {
            m2 = but[i1].getLabel();
            if (!"Correct".equals(m2) && !"Correct H".equals(m2) && !m2.contains("=")) {
                boolean t1 = ca1.cal_but(m2, m1);

                if (t1 == true) {
                    if(sound.getState())
                    {
                      //sound1.play();
                    }
                    JOptionPane.showMessageDialog(this, m2 + " = " + m1, "Solution...", JOptionPane.PLAIN_MESSAGE);


                    //but[i1].setLabel(m2+"="+m1);
                    but[i1].setVisible(false);
                    break;
                }
            }
            }
        }
        card_pos++;
        if (level == 0 || level == 1 || level == 4 || level == 5 || level == 7) {
            update_index();
        }
        if (level == 2 || level == 3 || level == 6 || level == 8 || level == 9) {
            next_type_index();
        }

        steps = steps + 1;
        step.setText("Step: " + steps);
        if (get_score >= 5) {
            get_score = get_score - 5;
        }
        score.setText("Score: " + get_score);
        if (card_pos == 16) {
            change_level();
        }

    }

    public void choose_game_itemStateChanged(ItemEvent ae) {

        game_str = choose_game.getSelectedItem();
    }
    public void del() {
        for (int x = 0; x < 100000; x++) {
            for (int x1 = 0; x1 < 10000; x1++) {
                int x2 = 5 + 5;
            }
        }
    }

    public void set_level_hes(int hes) {
        if (level == 0) {
            if (hes <= 50) {
                level = 3;
            } else if (hes <= 65) {
                level = 2;
            } else if (hes <= 80) {
                level = 1;
            } else {
                level = 0;
            }
        }
        else if(level==1)
        {
            if(hes <=55)
            {
                level=4;
            }
            else if(hes <= 70)
            {
                level = 3;
            }
            else if(hes <= 90)
            {
                level = 2;
            }
            else level = 1;
        }
        else if(level==2)
        {
            if(hes <= 60)
            {
                level = 5;
            }
            else if(hes <= 75)
            {
                level = 4;
            }
            else if(hes <= 95)
            {
                level = 3;
            }
            else level = 2;
        }
        else if(level==3)
        {
            if(hes <= 65)
            {
                level = 6;
            }
            else if(hes <= 80)
            {
                level = 5;
            }
            else if(hes <= 100)
            {
                level = 4;
            }
            else level = 3;
        }
        else if(level==4)
        {
            if(hes <= 70)
            {
                level = 7;
            }
            else if(hes <= 85)
            {
                level = 6;
            }
            else if(hes <= 110)
            {
             level = 5;   
            }
            else level = 4;
         }
         else if(level==5)
        {
            if(hes <= 70)
            {
                level = 8;
            }
            else if(hes <= 85)
            {
                level = 7;
            }
            else if(hes <= 110)
            {
             level = 6;   
            }
            else level = 5;
         }
         else if(level==6)
        {
            if(hes <= 100)
            {
                level = 9;
            }
            else if(hes <= 115)
            {
                level = 8;
            }
            else if(hes <= 130)
            {
             level = 7;   
            }
            else level = 6;
         }
         else if(level==7)
        {
            if(hes <= 105)
            {
                level = 9;
            }
            else if(hes <= 130)
            {
                level = 8;
            }
            else level = 7;
         }
         else if(level==8)
        {
            if(hes <= 110)
            {
                level = 9;
            }
            else if(hes <= 125)
            {
                level = 8;
            }
            else level = 7;
         }
        else {
             level++;
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
