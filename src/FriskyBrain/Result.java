
package FriskyBrain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class contains the GUI of the Result frame of the Frisky brain Game.
 * It displays the score obtained by the user after playing the game and 
 * it indicates whether the player passed or failed the test.
 * It also holds the back button for the user to be able to go back to the main menu.
 * 
 * @author  EzGhou
 * @author  Therese Nuelle Roca
 */
public class Result extends JFrame implements ActionListener{
 
    JLabel score = new JLabel();
    JButton Back = new JButton(); 
    
    String pass = "Images/passedBg.PNG";
    String fail = "Images/failedBg.PNG";
    
    ClassLoader classLoader;
    URL imageurl ;
    JLabel bgImage;
        
    int totalScore;
    
    
    /**
     * This constructor is responsible for setting and adding the distinct components to the frame.
     * @param num The total points earned by the player.
     */
    public Result(int num){
        
        //Sets the properties of the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750,550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
       
        //Sets the properties of the back button 
        Back.setBounds(30,455,120,40);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);
	Back.setText("Back");
        
        this.add(Back);  
        
        this.totalScore = num;
             
        resultText();
        resultBackground();
        
        this.setVisible(true);
        
        
    }

    /**
     * This method is responsible for changing the background image of the result frame 
     * which depends on whether the user passed or failed the test.
     * 
     */
    public void resultBackground(){      
        String path;
  
        if(totalScore > 18){
            path = pass;
        }
        else{
            path = fail;
        }
        
        classLoader = Thread.currentThread().getContextClassLoader();
        imageurl = classLoader.getResource(path);
        JLabel bgImage = new JLabel(new ImageIcon(imageurl));
        bgImage.setSize(745,521);
        this.add(bgImage);
        
    }
    
    /**
     * This method handles an instance of JLabel which is score and sets its properties.
     */
    public void resultText(){
        
        score.setText(totalScore +"/30");
        System.out.println("resultFrame"+totalScore);
        score.setBounds(360, 149, 80,100);
        score.setFont(new Font("Tahoma",Font.PLAIN,20));
        score.setForeground(Color.red);
        this.add(score);
    }   
    
    
    /**
     * This method handles the actions of the component and contains the code 
     * that will be executed when an action occurred.
     * @param e The Event object that represents the event being fired.
     */
    @Override
    public void actionPerformed(ActionEvent e){
     
        if(e.getSource() ==  Back){
                Frisky_Brain.hm.setVisible(true);
                this.dispose();      
        }
    }
    
    
}



