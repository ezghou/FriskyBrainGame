package FriskyBrain;


import java.awt.event.*;
import java.awt.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author EzGhou
 * @author Therese
 * @version 1
 */
public class HomeScreen extends JFrame implements ActionListener{
     /**Load background image
      */
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL imageurl = classLoader.getResource("Images/homeScreen.png");
    ImageIcon icon = new ImageIcon(imageurl);
    JLabel bgImage = new JLabel(icon);
    
    /**Declaring the buttons and the sounds
     * to be used in this frame
     */
    JButton TakeTheExam = new JButton(); 
    JButton HowToPlay = new JButton();
    JButton Settings = new JButton(); 
    JButton Credits = new JButton(); 
    JButton Exit = new JButton(); 
    Sounds music = new Sounds();
    Sounds click = new Sounds();
    boolean musicCheck = true;
    
    
    /**
     * This constructor is responsible for setting and adding the distinct 
     * components to the frame.
     */
    public HomeScreen(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750,550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        bgImage.setBounds(0,0,745, 522);
        this.add(bgImage);
        
        TakeTheExam.setBounds(272,203,150,40);
        TakeTheExam.setBackground(new java.awt.Color(255, 230, 98));
        TakeTheExam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	TakeTheExam.setFont(new Font("Tahoma",Font.PLAIN,15));
	TakeTheExam.setFocusable(false);
	TakeTheExam.addActionListener(this);
	TakeTheExam.setText("Take the Exam");
        
        HowToPlay.setBounds(272,250,150,40);
        HowToPlay.setBackground(new java.awt.Color(255, 230, 98));
        HowToPlay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	HowToPlay.setFont(new Font("Tahoma",Font.PLAIN,15));
	HowToPlay.setFocusable(false);
	HowToPlay.addActionListener(this);
	HowToPlay.setText("How to Play");
        
        Settings.setBounds(272,297,150,40);
        Settings.setBackground(new java.awt.Color(255, 230, 98));
        Settings.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Settings.setFont(new Font("Tahoma",Font.PLAIN,15));
	Settings.setFocusable(false);
	Settings.addActionListener(this);
	Settings.setText("Settings");
        
        Credits.setBounds(272,344,150,40);
        Credits.setBackground(new java.awt.Color(255, 230, 98));
        Credits.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Credits.setFont(new Font("Tahoma",Font.PLAIN,15));
	Credits.setFocusable(false);
	Credits.addActionListener(this);
	Credits.setText("Credits");
        
        Exit.setBounds(272,391,150,40);
        Exit.setBackground(new java.awt.Color(255, 230, 98));
        Exit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Exit.setFont(new Font("Tahoma",Font.PLAIN,15));
	Exit.setFocusable(false);
	Exit.addActionListener(this);
	Exit.setText("Exit");
        
        this.add(TakeTheExam);
        this.add(HowToPlay);
        this.add(Settings);
        this.add(Credits);
        this.add(Exit);
        this.add(bgImage);
        this.setVisible(true);
        
        music();
    }
    
    /**
     * This method handles the actions of the component and contains the code 
     * that will be executed when an action occurred.
     * @param e The Event object that represents the event being fired.
     */
    @Override
    public void actionPerformed(ActionEvent e){
       if(e.getSource() == TakeTheExam){
           
        try {
            click.soundChoice(4);
        } catch (Exception ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           userName user = new userName();
       }
       
       if(e.getSource() == HowToPlay){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
           HowToPlay htp = new HowToPlay();
       }
       
       if(e.getSource() == Settings){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
           SoundFrame sf = new SoundFrame();
       }
               
       if(e.getSource() == Credits){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
           CreditsFrame creditsFrame = new CreditsFrame();
       }
       
       if(e.getSource() == Exit){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
           this.dispose();
       }
    }
    
    /**Play the background music
     */
    public void music(){
        musicCheck = true;
        try {
            music.soundChoice(1);
        } catch (Exception e) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
        }
        
            music.playLoop();
            
    }
}
