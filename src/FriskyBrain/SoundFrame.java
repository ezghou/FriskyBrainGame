package FriskyBrain;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class contains the GUI of the sounds settings frame of the game.
 * It holds the on and off buttons to control the sounds/background music of game.
 * 
 * @author EzGhouphere
 * @author Thereze
 */
public class SoundFrame extends JFrame implements ActionListener{
    
    //Loads the background image file and add it to JLabel
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL imageurl = classLoader.getResource("Images/soundBg.png");
    ImageIcon icon = new ImageIcon(imageurl);
    JLabel bgImage = new JLabel(icon);
    
    JButton SoundOn = new JButton(); 
    JButton SoundOff = new JButton(); 
    JButton Back = new JButton(); 
    Sounds click  = new Sounds();
    
    /**
     * This constructor is responsible for setting and adding the distinct components to the frame.
     */  
    public SoundFrame(){
        
        Frisky_Brain.hm.setVisible(false);
        
        //Sets the properties of the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750,550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Sets the size of the background image and add it on the frame
        bgImage.setSize(745,521);
        this.add(bgImage);
      
        //Sets the properties of the on button 
        SoundOn.setBounds(310,170,130,35);
        SoundOn.setBackground(new java.awt.Color(255, 230, 98));
        SoundOn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	SoundOn.setFont(new Font("Tahoma",Font.PLAIN,15));
	SoundOn.setFocusable(false);
	SoundOn.addActionListener(this);
	SoundOn.setText("On");
      
        //Sets the properties of the off button
        SoundOff.setBounds(310,220,130,35);
        SoundOff.setBackground(new java.awt.Color(255, 230, 98));
        SoundOff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	SoundOff.setFont(new Font("Tahoma",Font.PLAIN,15));
	SoundOff.setFocusable(false);
	SoundOff.addActionListener(this);
	SoundOff.setText("Off");
    
        //Sets the properties of the back button 
        Back.setBounds(30,455,120,40);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);
	Back.setText("Back");
        
        this.add(SoundOn);
        this.add(SoundOff);
        this.add(Back);
        this.add(bgImage);
        this.setVisible(true);
    }
    
    /**
     * This method handles all the actions of the components and contains the code 
     * that will be executed when a particular action occurs.
     * @param e The Event object that represents the event being fired.
     */
    @Override
    public void actionPerformed(ActionEvent e){
     
        if(e.getSource() == SoundOn){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(Frisky_Brain.hm.musicCheck == true){
                int reply = JOptionPane.showConfirmDialog(null, "The music is already playing.", "", JOptionPane.PLAIN_MESSAGE);
            }
            
            else{
                Frisky_Brain.hm.musicCheck = true;
                Frisky_Brain.hm.music.playLoop();
            }
        }
       
        if (e.getSource() == SoundOff){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(Frisky_Brain.hm.musicCheck == false){
                int reply = JOptionPane.showConfirmDialog(null, "The music is already off.", "", JOptionPane.PLAIN_MESSAGE);
            }
            
            else{
                Frisky_Brain.hm.musicCheck = false;
                Frisky_Brain.hm.music.stop();
            }
        }
        
        if(e.getSource() ==  Back){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            Frisky_Brain.hm.setVisible(true);
            this.dispose();
        }
    }
}