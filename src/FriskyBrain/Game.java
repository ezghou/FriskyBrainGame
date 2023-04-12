package FriskyBrain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author EzGhou
 * @author Thereze
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**The class Game is where the exam will take place
 * It will handle the file reading, setting of questions,
 * and checking of answers.
 */
public class Game extends JFrame implements ActionListener{
    
    /**Variables for reading the files(questions)
     */
    String[] question = new String[146];
    String[][] choices = new String[5][146];
    String[] answer = new String[146];
    String[] image = new String[146];
    String[] imageCheck = new String[146];
    int[] check = new int[146];
    int index = 0;
    String guess = "";
    int correct_guesses = 0;
    int questionCount = 1;
    int total_questions = 30;
    int totalPoints = 0;
    int coins = 0;
    int result;
    Sounds click = new Sounds();
    int buttonClicksDialog = 0;
    int buttonClicksa = 0;
    int buttonClicksb = 0;
    int buttonClicksc = 0;
    int buttonClicksd = 0;
    
    /**Load background image
      */
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    URL imageurl = classLoader.getResource("Images/blankBg.png");
    ImageIcon icon = new ImageIcon(imageurl);
    JLabel bgImage = new JLabel(icon);
    
    /**
     * Declaring the variables needed for the GUI
     */
    JPanel panelWhite = new JPanel();  
    JTextField CoinsLabel = new JTextField(); 
    JButton Peek = new JButton(); 
    JButton Reveal = new JButton();
    JButton submit = new JButton(); 
    JButton back = new JButton(); 
    JButton nextQ = new JButton(); 
    JButton viewResult = new JButton(); 
    JButton Back = new JButton("Back");
    JTextField points = new JTextField();
    JLabel finalExam = new JLabel();
    
    //For Part I which have long questions and choices (need a text wrapper)
    JTextArea questionText = new JTextArea();
    JTextArea answer_A = new JTextArea();
    JTextArea answer_B = new JTextArea();
    JTextArea answer_C = new JTextArea();
    JTextArea answer_D = new JTextArea();
    
    //To lock the user's answer
    JRadioButton rButtonA = new JRadioButton();
    JRadioButton rButtonB = new JRadioButton();
    JRadioButton rButtonC = new JRadioButton();
    JRadioButton rButtonD = new JRadioButton();
    ButtonGroup group = new ButtonGroup();
    
    //Enlarging the Image size
    JDialog dialog = new JDialog(this, "Enlarge Images", Dialog.ModalityType.DOCUMENT_MODAL);
    JTextPane a = new JTextPane();
    JTextPane b = new JTextPane();
    JTextPane c = new JTextPane();
    JTextPane d = new JTextPane();
    JTextPane ques = new JTextPane();
    
    /**
     * This constructor is responsible for setting and adding the distinct 
     * components to the frame.It also shows the first question upon 
     * opening.
     */
    public Game(){ 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750,550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        panelWhite.setBackground(new java.awt.Color(255, 255, 255));
        panelWhite.setBounds(175,18,384, 477);
        
        CoinsLabel.setBounds(30,27,120,40);
        CoinsLabel.setBackground(new java.awt.Color(255, 230, 98));
        CoinsLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	CoinsLabel.setFont(new Font("Tahoma",Font.PLAIN,15));
        CoinsLabel.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        CoinsLabel.setEditable(false);
        CoinsLabel.setText("       Coins: " + coins);
        
        Peek.setBounds(30,75,120,40);
        Peek.setBackground(new java.awt.Color(255, 230, 98));
        Peek.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Peek.setFont(new Font("Tahoma",Font.PLAIN,15));
	Peek.setFocusable(false);
	Peek.addActionListener(this);
	Peek.setText("Peek");
        
        Reveal.setBounds(30,123,120,40);
        Reveal.setBackground(new java.awt.Color(255, 230, 98));
        Reveal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Reveal.setFont(new Font("Tahoma",Font.PLAIN,15));
	Reveal.setFocusable(false);
	Reveal.addActionListener(this);
	Reveal.setText("Reveal");
        
        points.setBounds(579,27,140,50);
        points.setBackground(new java.awt.Color(255, 230, 98));
        points.setFont(new Font("Tahoma",Font.PLAIN,15));
        points.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	points.setHorizontalAlignment(javax.swing.JTextField.LEADING);
        points.setEditable(false);
        points.setText("  Total Points:  " + "\n" + totalPoints);
        
        submit.setBounds(579,407,140,40);
        submit.setBackground(new java.awt.Color(255, 230, 98));
        submit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	submit.setFont(new Font("Tahoma",Font.PLAIN,15));
	submit.setFocusable(false);
	submit.addActionListener(this);
	submit.setText("Submit");
        
        back.setBounds(30,455,120,40);
        back.setBackground(new java.awt.Color(255, 230, 98));
        back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	back.setFont(new Font("Tahoma",Font.PLAIN,15));
	back.setFocusable(false);
	back.addActionListener(this);
	back.setText("Back");
        
        nextQ.setBounds(579,455,140,40);
        nextQ.setBackground(new java.awt.Color(255, 230, 98));
        nextQ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	nextQ.setFont(new Font("Tahoma",Font.PLAIN,15));
	nextQ.setFocusable(false);
	nextQ.addActionListener(this);
	nextQ.setText("Next Question");
        
        viewResult.setBounds(579,455,140,40);
        viewResult.setBackground(new java.awt.Color(255, 230, 98));
        viewResult.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	viewResult.setFont(new Font("Tahoma",Font.PLAIN,15));
	viewResult.setFocusable(false);
	viewResult.addActionListener(this);
	viewResult.setText("View Result");
        viewResult.setVisible(false);
        
        finalExam.setBounds(287,20,160,50);
        finalExam.setFont(new java.awt.Font("Tunga", 0, 17)); // NOI18N
        finalExam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finalExam.setText("CMSC13 Final Exam");
        
        questionText.setBounds(185,70,364,120);
        questionText.setBackground(new Color(255, 255, 255));
        questionText.setForeground(new Color(0,0,0));
        questionText.setFont(new java.awt.Font("Tunga", 0, 15));
        questionText.setWrapStyleWord(true);
        questionText.setLineWrap(true);
        questionText.setEditable(false);
        questionText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        answer_A.setBounds(225,200,324,60);
        answer_A.setBackground(new Color(255, 255, 255));
        answer_A.setFont(new java.awt.Font("Tunga", 0, 14));
        answer_A.setForeground(new Color(0,0,0));
        answer_A.setWrapStyleWord(true);
        answer_A.setLineWrap(true);
        answer_A.setEditable(false);
        answer_A.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        answer_B.setBounds(225,270,324,60);
        answer_B.setBackground(new Color(255, 255, 255));
        answer_B.setFont(new java.awt.Font("Tunga", 0, 14));
        answer_B.setForeground(new Color(0,0,0));
        answer_B.setWrapStyleWord(true);
        answer_B.setLineWrap(true);
        answer_B.setEditable(false);
        answer_B.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        answer_C.setBounds(225,340,324,60);
        answer_C.setBackground(new Color(255, 255, 255));
        answer_C.setFont(new java.awt.Font("Tunga", 0, 14));
        answer_C.setForeground(new Color(0,0,0));
        answer_C.setWrapStyleWord(true);
        answer_C.setLineWrap(true);
        answer_C.setEditable(false);
        answer_C.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        answer_D.setBounds(225,410,324,60);
        answer_D.setBackground(new Color(255, 255, 255));
        answer_D.setFont(new java.awt.Font("Tunga", 0, 14));
        answer_D.setForeground(new Color(0,0,0));
        answer_D.setWrapStyleWord(true);
        answer_D.setLineWrap(true);
        answer_D.setEditable(false);
        answer_D.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
         
        rButtonA.setBounds(185,210,40,40);
        rButtonA.setFont(new java.awt.Font("Tunga", 0, 12));
        rButtonA.setBackground(new java.awt.Color(255, 255, 255));
        rButtonA.setForeground(new Color(0,0,0));
        rButtonA.setFocusable(false);
        rButtonA.addActionListener(this);
        rButtonA.setText("A.");
        
        rButtonB.setBounds(185,280,40,40);
        rButtonB.setFont(new java.awt.Font("Tunga", 0, 12));
        rButtonB.setBackground(new java.awt.Color(255, 255, 255));
        rButtonB.setForeground(new Color(0,0,0));
        rButtonB.addActionListener(this);
        rButtonB.setText("B.");
        
        rButtonC.setBounds(185,350,40,40);
        rButtonC.setFont(new java.awt.Font("Tunga", 0, 12));
        rButtonC.setBackground(new java.awt.Color(255, 255, 255));
        rButtonC.setForeground(new Color(0,0,0));
        rButtonC.addActionListener(this);
        rButtonC.setText("C.");
        
        rButtonD.setBounds(185,420,40,40);
        rButtonD.setFont(new java.awt.Font("Tunga", 0, 12));
        rButtonD.setBackground(new java.awt.Color(255, 255, 255));
        rButtonD.setForeground(new Color(0,0,0));
        rButtonD.addActionListener(this);
        rButtonD.setText("D.");
        
        bgImage.setSize(745, 522);
        
        group.add(rButtonA);
        group.add(rButtonB);
        group.add(rButtonC);
        group.add(rButtonD);
       
        this.add(rButtonD);
        this.add(rButtonC);
        this.add(rButtonB);
        this.add(rButtonA);
        this.add(answer_A);
        this.add(answer_B);
        this.add(answer_C);
        this.add(answer_D);
        this.add(questionText);
        this.add(finalExam);
        this.add(nextQ);
        this.add(points);
        this.add(Peek);
        this.add(Reveal);
        this.add(submit);
        this.add(back);
        this.add(viewResult);
        this.add(CoinsLabel);
        this.add(panelWhite);
        this.add(bgImage);    
        this.setVisible(true);
        
        fileReader();
        nextQuestion();
    }
    /**
     * This method facilitates whether to display the questions
     * in Part I or in Part II.
     * Also creating the mouse events so that the user can
     * view the images in Part II.
     */
    public void nextQuestion(){
        //Enabling the necessary buttons.
        submit.setEnabled(true);
        Peek.setEnabled(true);
        Reveal.setEnabled(true);
        
        //Checking the number of questions.
        if(questionCount < 16){
            RandomizerPartI();
            questionText.setText(question[index]);
            answer_A.setText(choices[0][index]);
            answer_B.setText(choices[1][index]);
            answer_C.setText(choices[2][index]);
            answer_D.setText(choices[3][index]);
            questionCount++;
        }
        
        else{
            RandomizerPartII();
            
            //Creating a mouse events for the JTextArea for accessing the images
            
            questionText.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(e.getClickCount() == 1 && !e.isConsumed()){
                            e.consume();
                            dialogQuestion();
                            buttonClicksDialog = 0;
                        }
                        
                    }
                });
            
            answer_A.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(e.getClickCount() == 1 && !e.isConsumed()){
                            e.consume();
                            dialogChoiceA();
                            buttonClicksDialog = 0;
                        }
                    }
                });
            
            answer_B.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(e.getClickCount() == 1 && !e.isConsumed()){
                            e.consume();
                            dialogChoiceB();
                            buttonClicksDialog = 0;
                        }
                        
                    }
                });
            
            answer_C.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(e.getClickCount() == 1 && !e.isConsumed()){
                            e.consume();
                            dialogChoiceC();
                            buttonClicksDialog = 0;
                        }
                        
                    }
                });
            
            answer_D.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(e.getClickCount() == 1 && !e.isConsumed()){
                            e.consume();
                            dialogChoiceD();
                            buttonClicksDialog = 0;
                        }
                        
                    }
                });
            //Checking what type of question
            switch(imageCheck[index]){
                case "1": //Question has image while choices do not have image.
                    questionText.setText(question[index] + "\n" + "[There is an image in this question, click this box to view.]");
                    
                    answer_A.setText(choices[0][index]);
                    answer_B.setText(choices[1][index]);
                    answer_C.setText(choices[2][index]);
                    answer_D.setText(choices[3][index]);
                    questionCount++;
                    break;
                 
                case "2": //Question has image while choices also have images.
                    questionText.setText(question[index] + " \n" + "[There is an image in this question, click this box to view.]");
                    
                    answer_A.setText("[There is an image in this question, click this box to view.]");
                    answer_B.setText("[There is an image in this question, click this box to view.]");
                    answer_C.setText("[There is an image in this question, click this box to view.]");
                    answer_D.setText("[There is an image in this question, click this box to view.]");

                    questionCount++;
                    break;
                
                case "3": //Question dont have image but the choices have an image.
                    questionText.setText(question[index]);

                    answer_A.setText("[There is an image in this question, click this box to view.]");
                    answer_B.setText("[There is an image in this question, click this box to view.]");
                    answer_C.setText("[There is an image in this question, click this box to view.]");
                    answer_D.setText("[There is an image in this question, click this box to view.]");

                    questionCount++;
                    break;
                    
                case "4": //Question dont have an image, aslo choices.
                    questionText.setText(question[index] + "\n");
                    
                    answer_A.setText(choices[0][index]);
                    answer_B.setText(choices[1][index]);
                    answer_C.setText(choices[2][index]);
                    answer_D.setText(choices[3][index]);
                    questionCount++;
                    break;
            }
        }
        nextQ.setEnabled(false);
    }
    /**
     * This method handles the actions of the component and contains the code 
     * that will be executed when an action occurred.
     * @param e The Event object that represents the event being fired.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == rButtonA){
            buttonClicksa++;
            if(buttonClicksa <= 1){
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {

                }
                guess = "A";
            }
            
            //Button Click variable is created to avoid multiple clicking of the 
            //JRadioButton (Creating a bug in the sound)
            buttonClicksb = 0;
            buttonClicksc = 0;
            buttonClicksd = 0;
        }
        
        if(e.getSource() == rButtonB){
            buttonClicksb++;
            if(buttonClicksb <= 1){
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {

                }
                guess = "B";
            }
            buttonClicksa = 0;
            buttonClicksc = 0;
            buttonClicksd = 0;
        }
        
        if(e.getSource() == rButtonC){
            buttonClicksc++;
            if(buttonClicksc <= 1){
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {

                }
                guess = "C";
            }
            buttonClicksb = 0;
            buttonClicksa = 0;
            buttonClicksd = 0;
        }
        
        if(e.getSource() == rButtonD){
            buttonClicksd++;
            if(buttonClicksd <= 1){
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {

                }
                guess = "D";
            }
            buttonClicksb = 0;
            buttonClicksc = 0;
            buttonClicksa = 0;
        }
        
        if(e.getSource() == Peek){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            peek();
        }
        
        if(e.getSource() == Reveal){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            reveal();
        }
        
        if(e.getSource() == submit){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            submit();
            buttonClicksa = 0;
            buttonClicksb = 0;
            buttonClicksc = 0;
            buttonClicksd = 0;
        }
        
        if(e.getSource() == viewResult){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            result();
        }
        
        if(e.getSource() == nextQ){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            nextQuestion();
            buttonClicksa = 0;
            buttonClicksb = 0;
            buttonClicksc = 0;
            buttonClicksd = 0;
            
            if(questionCount == total_questions){
                nextQ.setVisible(false);
                viewResult.setVisible(true);
            }
            
            //Making the TextArea's border black after running the displayAnswer
            //method.
            rButtonA.setForeground(Color.black);
            answer_A.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
            rButtonB.setForeground(Color.black);
            answer_B.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
            rButtonC.setForeground(Color.black);
            answer_C.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
            rButtonD.setForeground(Color.black);
            answer_D.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
            
            guess = "";
            
            rButtonA.setEnabled(true);
            rButtonB.setEnabled(true);
            rButtonC.setEnabled(true);
            rButtonD.setEnabled(true);
            
            group.clearSelection();
        }
        
        if(e.getSource() == back){
            try {
                click.soundChoice(4);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?", "Back", JOptionPane.YES_NO_OPTION);
               
            if(reply == JOptionPane.YES_OPTION){
                Frisky_Brain.hm.setVisible(true);
                this.dispose();
            }
        }
        //This Back button is only visibe and usable in the JDialog
        if(e.getSource() == Back){
            buttonClicksDialog++;
            if(buttonClicksDialog <= 1){
                try {
                    click.soundChoice(4);
                } catch (Exception ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                ques.setText("");
                a.setText("");
                b.setText("");
                c.setText("");
                d.setText("");
                dialog.dispose();
            }
        }
        
    }
    
    /**This method shows the user if the 
     * user's answer is correct or not.
     * 
     */
    public void displayAnswer(){
        
        if(guess.equals(answer[index])){
            try {
                click.soundChoice(2);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Adding points and diplaying it.
            totalPoints++;  
            coins++;
            points.setText("  Total Points:  " + "\n" + totalPoints);
            CoinsLabel.setText("       Coins: " + coins);
        }
        else{
            
            try {
                click.soundChoice(3);
            } catch (Exception ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Changing the color of the border of the TextArea, red if it is wrong, 
        //and green for the right answer.
        if(!"A".equals(answer[index])){
            rButtonA.setForeground(Color.red);
            answer_A.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
        }
        else{
            rButtonA.setForeground(Color.green);
            answer_A.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
        }
        if(!"B".equals(answer[index])){
            rButtonB.setForeground(Color.red);
            answer_B.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
        }
        else{
            rButtonB.setForeground(Color.green);
            answer_B.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
        }
        
        if(!"C".equals(answer[index])){
            rButtonC.setForeground(Color.red);
            answer_C.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
        }
        else{
            rButtonC.setForeground(Color.green);
            answer_C.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
        }
        
        if(!"D".equals(answer[index])){
            rButtonD.setForeground(Color.red);
            answer_D.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
        }
        else{
            rButtonD.setForeground(Color.green);
            answer_D.setBorder(javax.swing.BorderFactory.createLineBorder(Color.green));
        }
    }
    
    /**It will submit the answer of the user
     * so that the game can check it.
     */
    public void submit(){
        if(guess.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please submit an answer, it won't hurt.");
        }
        
        else{
            displayAnswer();
            rButtonA.setEnabled(false);
            rButtonB.setEnabled(false);
            rButtonC.setEnabled(false);
            rButtonD.setEnabled(false);
            submit.setEnabled(false);
            Peek.setEnabled(false);
            Reveal.setEnabled(false);
            nextQ.setEnabled(true);
        }
    }
    
    /**Create an instance of the class Result
     * to display whether the user pass or fail
     * after the user reach the maximum 
     * number of questions.
     */
    public void result(){
        Result resultView = new Result(totalPoints);
        this.dispose();
    }
    /**
     * This method implements the Peek skill.
     */
    public void peek(){
        String ans = answer[index];
        
        if(coins < 10){
            JOptionPane.showMessageDialog(null, "You don't have sufficient coins");
        }
        
        else{
            //Checking what percentage the user gets [40% - 90%]
            Random rand = new Random();
            int percentage;

            while(true){
                percentage = rand.nextInt(90);

                if(percentage >= 40){
                    break;
                }
            }
            //Checking if the user gets the correct answer or not, and display 
            //it.
            int get = rand.nextInt(100);
            if(get <= percentage){
                JOptionPane.showMessageDialog(null, "The answer for this question is " + answer[index]);
                coins = coins - 10;
                CoinsLabel.setText("       Coins: " + coins);
            }
            else{
                //Deciding what choice to display after not getting the right answer
                //by using another random method.
                int wrong = 0;
                while(true){
                    int gett = rand.nextInt(3);

                    if(ans.equals("A") && gett != 0){
                        wrong = gett;
                        break;
                    }
                    if(ans.equals("B") && gett != 1){
                        wrong = gett;
                        break;
                    }
                    if(ans.equals("C") && gett != 2){
                        wrong = gett;
                        break;
                    }
                    if(ans.equals("D") && gett != 3){
                        wrong = gett;
                        break;
                    }
                }
                
                switch(wrong){
                    case 0:
                        JOptionPane.showMessageDialog(null, "The answer for this question is " + "A");
                        coins = coins - 10;
                        CoinsLabel.setText("       Coins: " + coins);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "The answer for this question is " + "B");
                        coins = coins - 10;
                        CoinsLabel.setText("       Coins: " + coins);
                        break;   
                    case 2:
                        JOptionPane.showMessageDialog(null, "The answer for this question is " + "C");
                        coins = coins - 10;
                        CoinsLabel.setText("       Coins: " + coins);
                        break;   
                    case 3:
                        JOptionPane.showMessageDialog(null, "The answer for this question is " + "D");
                        coins = coins - 10;
                        CoinsLabel.setText("       Coins: " + coins);
                        break;  
                }
            }
        }
    }
    
    /**
     * This method implements the Reveal skill.
     */
    public void reveal(){
        if(coins < 15){
            JOptionPane.showMessageDialog(null, "You don'to have sufficient coins");
        }
        else{
            JOptionPane.showMessageDialog(null, "The answer for this question is " + answer[index]);
            coins = coins - 15;
            CoinsLabel.setText("       Coins: " + coins);
        }
    }
    /**
     * The method used to pick the question randomly to be 
     * display in Part I.
     */
    public void RandomizerPartI(){
        
        Random rand = new Random();
        int count;

        while(true){
            count = rand.nextInt(69);

            if(check[count] == 0){
                check[count] = 1;
                index = count;
                break;
            }
        }
    }
    
    /**
     * The method used to pick the question randomly to be 
     * display in Part II.
     */
    public void RandomizerPartII(){
        
        Random rand = new Random();
        int count;

        while(true){
            count = rand.nextInt(145);

            if(count > 69){
                if(check[count] == 0){
                    check[count] = 1;
                    index = count;
                    break;
                }
            }
        }
    }
    
    /**Reads the CSV file which contains the questions
     */
    public void fileReader(){
        String[] read;
        InputStream path = getClass().getResourceAsStream("/Questions/CS13 Questions.csv");
        String line = "";
    
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(path));

            for(int count = 0;(line = reader.readLine()) != null; count++){

                read = line.split(",");
                question[count] = read[0];
                choices[0][count] = read[1];
                choices[1][count] = read[2];
                choices[2][count] = read[3];
                choices[3][count] = read[4];
                answer[count] = read[5];
                image[count] = read[6];
                imageCheck[count] = read[7];
            }
        } 
        catch(IOException e){
            
        }   
    }
    
    /**Shows a JDialog containing the image for choice A.
     */
    public void dialogChoiceA(){
        
        dialog.getContentPane().setLayout(null);
        dialog.setUndecorated(true);
        dialog.setSize(600,490);
        dialog.setLocationRelativeTo(null);
        dialog.getContentPane().setBackground(Color.white);
        
        a.setBounds(20,25,560,425);
        a.setBackground(new Color(255, 255, 255));
        a.setFont(new java.awt.Font("Tunga", 0, 15));
        a.setForeground(new Color(0,0,0));
        a.setEditable(false);
        a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        Back.setBounds(7,455,100,30);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);
        
        
        /**Check if A has an image.
         */
        switch(imageCheck[index]){
            case "1":
                a.setText("NO IMAGE AVAILABLE");
                break;
            
            case "2":
                    a.insertComponent(reSize(choices[0][index]));
                    break;
            case "3":
                    a.insertComponent(reSize(choices[0][index]));
                    break;
            case "4":
                    a.setText("NO IMAGE AVAILABLE");
                    break;
        }
        
        
        a.setVisible(true);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        ques.setVisible(false);
                
        
        dialog.add(a);
        dialog.add(Back);
        
        dialog.setVisible(true);
    }
    
    /**Shows a JDialog containing the image for choice B.
     */
    public void dialogChoiceB(){
        
        dialog.getContentPane().setLayout(null);
        dialog.setUndecorated(true);
        dialog.setSize(600,490);
        dialog.setLocationRelativeTo(null);
        dialog.getContentPane().setBackground(Color.white);
        
        b.setBounds(20,25,560,425);
        b.setBackground(new Color(255, 255, 255));
        b.setFont(new java.awt.Font("Tunga", 0, 15));
        b.setForeground(new Color(0,0,0));
        b.setEditable(false);
        b.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        Back.setBounds(7,455,100,30);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);
        

        /**Checks if B has an image.
         */
        switch(imageCheck[index]){
            case "1":
                b.setText("NO IMAGE AVAILABLE");
                break;
            
            case "2":
                    b.insertComponent(reSize(choices[1][index]));
                    break;
            case "3":
                    b.insertComponent(reSize(choices[1][index]));
                    break;
            case "4":
                    b.setText("NO IMAGE AVAILABLE");
                    break;
        }
        
        a.setVisible(false);
        b.setVisible(true);
        c.setVisible(false);
        d.setVisible(false);
        ques.setVisible(false);
                
        dialog.add(b);
        dialog.add(Back);
        
        dialog.setVisible(true);
    }
    
    /**Shows a JDialog containing the image for choice C.
     */
    public void dialogChoiceC(){
        
        dialog.getContentPane().setLayout(null);
        dialog.setUndecorated(true);
        dialog.setSize(600,490);
        dialog.setLocationRelativeTo(null);
        dialog.getContentPane().setBackground(Color.white);
        
        c.setBounds(20,25,560,425);
        c.setBackground(new Color(255, 255, 255));
        c.setFont(new java.awt.Font("Tunga", 0, 15));
        c.setForeground(new Color(0,0,0));
        c.setEditable(false);
        c.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        Back.setBounds(7,455,100,30);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);
        

        /**Checks if C has an image.
         */
        switch(imageCheck[index]){
            case "1":
                c.setText("NO IMAGE AVAILABLE");
                break;
            
            case "2":
                    c.insertComponent(reSize(choices[2][index]));
                    break;
            case "3":
                    c.insertComponent(reSize(choices[2][index]));
                    break;
            case "4":
                    c.setText("NO IMAGE AVAILABLE");
                    break;
        }
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(true);
        d.setVisible(false);
        ques.setVisible(false);
                
        
        dialog.add(c);
        dialog.add(Back);
        
        dialog.setVisible(true);
    }
    
    /**Shows a JDialog containing the image for choice D.
     */
    public void dialogChoiceD(){
        
        dialog.getContentPane().setLayout(null);
        dialog.setUndecorated(true);
        dialog.setSize(600,490);
        dialog.setLocationRelativeTo(null);
        dialog.getContentPane().setBackground(Color.white);
        
        d.setBounds(20,25,560,425);
        d.setBackground(new Color(255, 255, 255));
        d.setFont(new java.awt.Font("Tunga", 0, 15));
        d.setForeground(new Color(0,0,0));
        d.setEditable(false);
        d.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        Back.setBounds(7,455,100,30);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);

        /**Checks if D has an image.
         */
        switch(imageCheck[index]){
            case "1":
                d.setText("NO IMAGE AVAILABLE");
                break;
            
            case "2":
                    d.insertComponent(reSize(choices[3][index]));
                    break;
            case "3":
                    d.insertComponent(reSize(choices[3][index]));
                    break;
            case "4":
                    d.setText("NO IMAGE AVAILABLE");
                    break;
        }
        
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(true);
        ques.setVisible(false);
                
        dialog.add(d);
        dialog.add(Back);
        
        dialog.setVisible(true);
    }
    
    /**Shows a JDialog containing the image for the current question.
     */
    public void dialogQuestion(){
        dialog.getContentPane().setLayout(null);
        dialog.setUndecorated(true);
        dialog.setSize(600,490);
        dialog.setLocationRelativeTo(null);
        dialog.getContentPane().setBackground(Color.white);

        ques.setBounds(20,10,560,440);
        ques.setBackground(new Color(255, 255, 255));
        ques.setForeground(new Color(0,0,0));
        ques.setFont(new java.awt.Font("Tunga", 0, 16));
        ques.setEditable(false);
        ques.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        

        /**Checks if the question has an image
         */
        switch(imageCheck[index]){
            case "1":
                ques.setText(question[index] + " \n");
                ques.insertComponent(reSize(image[index]));
                break;
            case "2":
                ques.setText(question[index] + " \n");
                ques.insertComponent(reSize(image[index]));
                break;
            case "3":
                ques.setText(question[index] + " \n");
                ques.setText("NO IMAGE AVAILABLE");
                break;
            case "4":
                    ques.setText("NO IMAGE AVAILABLE");
                    break;
        }
        
        Back.setBounds(7,455,100,30);
        Back.setBackground(new java.awt.Color(255, 230, 98));
        Back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0),new java.awt.Color(255,165,0)));
	Back.setFont(new Font("Tahoma",Font.PLAIN,15));
	Back.setFocusable(false);
	Back.addActionListener(this);
        
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        ques.setVisible(true);
        
        dialog.add(ques);
        dialog.add(Back);
        
        dialog.setVisible(true);
    }
    
    /**
     * This method resize the image to be displayed on the JDialog
     * @param image It is the image that will be displayed
     * @return The image after checking if it needs to be resize or not
     */
    public JLabel reSize(String image){
        int height, width;
        
        URL imageUrl = classLoader.getResource(image);
        ImageIcon Icon = new ImageIcon(imageUrl);
        Image pic = Icon.getImage();
        
        height = Icon.getIconHeight();
        width = Icon.getIconWidth();
        //Checks if the image need to be resize.
        if(width > 560){
            Image newPic = pic.getScaledInstance(558, height, java.awt.Image.SCALE_SMOOTH);
            Icon = new ImageIcon(newPic);
        }
        
        if(height > 425){
            Image newPic = pic.getScaledInstance(width, 415, java.awt.Image.SCALE_SMOOTH);
            Icon = new ImageIcon(newPic);
        }
        
        JLabel imageLabel = new JLabel(Icon);
        
        return imageLabel;
    }
}
