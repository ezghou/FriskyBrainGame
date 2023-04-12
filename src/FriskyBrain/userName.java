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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This class contains the GUI of the game when it asks the username of the player before taking the exam.
 * The user needs to first type its preferred username then click the create button in order to generate its username.
 * It also holds the back button for the user to be able to go back to the main menu, and the next button to proceed to the exam proper.
 * 
 * @author EzGhou
 * @author Thereze
 */
public class userName extends JFrame implements ActionListener{
    
    
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL imageurl = classLoader.getResource("Images/userNameBg.PNG");
    ImageIcon icon = new ImageIcon(imageurl);
    JLabel bgImage = new JLabel(icon);
    
    JButton Next = new JButton(); 
    JButton Create = new JButton(); 
    JButton Back = new JButton(); 
    JTextField user = new JTextField(); 
    String userName = "";
    
    
    /**
     * This constructor is responsible for setting and adding the distinct components to the frame.
     */ 
    public userName(){
        
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
        
        //Sets the properties of the textfield
        user.setBounds(275,270,200,40);
        user.setOpaque(false);
        user.setForeground(Color.WHITE);
        user.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	user.setFont(new Font("Tahoma",Font.BOLD,15));
        user.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        user.setEditable(true);
	user.addActionListener(this);
        user.setText("Enter your name here.");
        
        //Sets the properties of the create button
        Create.setBounds(310,320,130,35);
        Create.setBackground(new java.awt.Color(255, 230, 98));
        Create.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Create.setFont(new Font("Tahoma",Font.PLAIN,15));
	Create.setFocusable(false);
	Create.addActionListener(this);
	Create.setText("Create User");
      
        //Sets the properties of the next button
        Next.setBounds(579,455,140,40);
        Next.setBackground(new java.awt.Color(255, 230, 98));
        Next.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Next.setFont(new Font("Tahoma",Font.PLAIN,15));
	Next.setFocusable(false);
        Next.setEnabled(false);
	Next.addActionListener(this);
	Next.setText("Next");
    
        //Sets the properties of the back button
        Back.setBounds(30,455,120,40);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);
	Back.setText("Back");
        
        this.add(user);
        this.add(Create);
        this.add(Next);
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
        
        if(e.getSource() == Create){
            
            userName = user.getText();
            String askname = "Are you sure with " + userName + " as your name?";
            
            if(userName.length() > 26){
                int reply = JOptionPane.showConfirmDialog(null, "Please enter a valid name. It can be a combination of number and letters but not exceeding 25 characters.", "", JOptionPane.PLAIN_MESSAGE);
            }
            
            else{
                if(userName.isEmpty()){
                    int reply = JOptionPane.showConfirmDialog(null, "Please enter a name.", "", JOptionPane.PLAIN_MESSAGE);

                }
                else{
                    int ask = JOptionPane.showConfirmDialog(null, askname, "", JOptionPane.YES_NO_OPTION);

                    if(ask == JOptionPane.YES_OPTION){
                        user.setEditable(false);
                        int reply = JOptionPane.showConfirmDialog(null, "You have succesfully created an acccount.", "", JOptionPane.PLAIN_MESSAGE);
                        Next.setEnabled(true);
                        Create.setEnabled(false);
                    }
                }
            }
        }
       
        if (e.getSource() == Next){
            Game game = new Game();
            this.dispose();
        }
        
        if(e.getSource() ==  Back){
            Frisky_Brain.hm.setVisible(true);
            this.dispose();
        }
    }
}
