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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class contains the GUI of the credits frame of the Frisky brain Game.
 * It displays the name of the developers of the game and its purpose.
 * It also holds the back button for the user to be able to go back to the main menu.
 * 
 * @author  EG Renz Go
 * @author  Therese Nuelle Roca
 */
public class CreditsFrame extends JFrame implements ActionListener{
     
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL imageurl = classLoader.getResource("Images/creditsBg.png");
    ImageIcon icon = new ImageIcon(imageurl);
    JLabel bgImage = new JLabel(icon);
    
    JButton Back = new JButton(); 
    Sounds click = new Sounds();
    
    /**
     * This constructor is responsible for setting and adding the distinct 
     * components to the frame.
     */
    public CreditsFrame(){
        
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
      
        //Sets the properties of the back button
        Back.setBounds(30,455,120,40);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);
	Back.setText("Back");
      
        
        this.add(Back);
        this.add(bgImage);
        this.setVisible(true);
    }
    
    /**
     * This method handles the actions of the component and contains the code 
     * that will be executed when an action occurred.
     * @param e The Event object that represents the event being fired.
     */
    @Override
    public void actionPerformed(ActionEvent e){
    
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