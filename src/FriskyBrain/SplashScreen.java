package FriskyBrain;


import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * This class contains the GUI of the Splash Screen frame of the Frisky brain Game.
 * It displays the Splash Screen of the game.
 * 
 * @author  EzGhou
 * @author  Therese Nuelle Roca
 */
public class SplashScreen extends JFrame{
    
    JProgressBar progressBar = new JProgressBar();
    JLabel progressText = new JLabel();
    
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL imageurl = classLoader.getResource("Images/SplashScreen.png");
    ImageIcon icon = new ImageIcon(imageurl);
    JLabel bgImage = new JLabel(icon);
    
    /**
     * This constructor is responsible for setting and adding the distinct 
     * components to the frame.
     */
    public SplashScreen(){
        createGUI();
        addText();
        addBackgroundImage();
        addProgressBar();
        LoadProgressBar();
    }
    /**
     * This method Sets the properties of the JFrame.
     */
    public void createGUI(){
        
        this.getContentPane().setLayout(null);
        this.setUndecorated(true);
        this.setSize(750,550);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);

    }
    /**
     * Adds the background image.
     */
    public void addBackgroundImage(){
        bgImage.setSize(750,550);
        this.add(bgImage);
    }
  
    /**
     * Adds the text in the frame.
     */
    public void addText(){
        
        progressText.setBounds(325,460,200,40);
        progressText.setForeground(Color.getHSBColor(53, 49, 98));
        progressText.setFont(new Font("arial",Font.BOLD,16));
        this.add(progressText);
    }
    
    /**
     * Adds the loading bar.
     */
    public void addProgressBar(){
        
        progressBar.setBounds(20,500,710,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.getHSBColor(53, 49, 98));
        progressBar.setForeground(Color.DARK_GRAY);
        progressBar.setValue(0);
        this.add(progressBar);
    }
    
    /**
     * Calculate the loading progress.
     */
    public void LoadProgressBar(){
        int pNum=0;
        
        while( pNum<=100){
        
            try{
                Thread.sleep(40);
                progressBar.setValue(pNum);
                progressText.setText("LOADING ...");
                pNum++;
                if(pNum==100)
                    this.dispose();
            }catch(Exception e){
               e.printStackTrace();
                }
            
        }
    }
}
