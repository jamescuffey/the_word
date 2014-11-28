package the.word;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author James
 */
public final class Generate extends JPanel {
    
    public static boolean hasCompleted;
    
    //set a temp variable for our coin
    private static int tempCoin;
       
    //create an instance of the coin class
    public static Coin singleton = new Coin(tempCoin); 
    
    //get the instance
    public static Coin getSingleton() {
        return singleton;
    }
 
    /**
     * Our counter used for the timer.
     * 
     * No point in encapsulation, as the value needs to be changed statically.
     */
    public static int counter = 10;  
    
    /**
     * The label for outputs.
     */
    public static Label text;
    
    /**
     * The timer label that hasn't yet be initialised.
     */
    public static Label time;
    
    /**
     * The label for generating new words.
     */
    public static Label label;
    
    /**
     * The label for updating coins on the screen.
     */
    public static Label coins;
 
    /**
     * Initialise the random generator.
     */
    private static Random generator = new Random();
    
    /**
     * Stores the current word.
     */
    public static String currentWord = "";
    
    /**
     * Construct our new words.
     */
    public Generate() {  
        hasCompleted = false;
        label = new Label("The new word is: " + generateWord());
        time = new Label("You have: " + counter + " seconds left!");
        text = new Label("");
        coins = new Label("Total coins: " + getSingleton().getCoins());
        JButton button = new JButton("Confirm my choice");
        JTextField word = new JTextField(10);
        
        //handles the logic for clicking the button
        button.addActionListener((ActionEvent e) -> {
            if(!hasCompleted) {
                handleLogic(word);
            } else {
                text.setText("You have already answered this question!");
            }
        });
        
        time.setForeground(Color.red);   
        coins.setForeground(Color.yellow); 
        label.setForeground(Color.white);
        text.setForeground(Color.white);    
 
        setLayout(new GridLayout(0,  1));
        
        //add the components to the JPanel
        add(label);
        add(time);
        add(coins);
        add(text);
        add(word);
        add(button);
        
        //set its background to dark gray.
        setBackground(Color.DARK_GRAY);
    }
    
    /**
     * Handle the logic for the text field.
     * @param word 
     */
    public void handleLogic(JTextField word) { 
        if(counter != 0) {
            if(word.getText().contains(currentWord) && counter > 0 && word.getText().length() == currentWord.length()) {     
                tempCoin += 10;  
                hasCompleted = true; 
                text.setText("You got the answer right, you've been rewarded with " + tempCoin + " coins!");  

                //increments the coin by 10
                getSingleton().setCoins(tempCoin);
            
                //updates the coin text
                coins.setText("Total coins: " + Generate.getSingleton().getCoins());  
            } else if(!word.getText().contains(currentWord)) {
                tempCoin -= 3;
                text.setText("You got the answer wrong, " + tempCoin + " coins have been taken from your stack!");
                //decrements the coin by 3
                getSingleton().setCoins(tempCoin);
            
                //updates the coin text
                coins.setText("Total coins: " + Generate.getSingleton().getCoins());  
            } else if(word.getText().length() != currentWord.length()) {
                text.setText("You've entered the right word, just remove a few characters!");
            } else if(word.getText().contains("")) {
                text.setText("You have not entered a word, you have been penalised!");
                tempCoin -= 3;
                //decrements the coin by 3
                getSingleton().setCoins(tempCoin);
            }
        } else {
            text.setText("You've ran out of time!");
        }
    }
  
    /**
     * Generates a new word.
     * @return result
     */
    public static String generateWord() {
        int randomWord = generator.nextInt(Constants.WORDS.length);
        String result = "";
 
        //store the words in a temp variable
        currentWord = Constants.WORDS[randomWord];  
        
        //check if it's not empty
        if(currentWord != null) {
            int randomLetter = generator.nextInt(currentWord.length());
       
            StringBuilder sb = new StringBuilder(currentWord);
            sb.deleteCharAt(randomLetter);
            result = sb.toString();
        }
        return result;     
    }
    
    public static void reset() {
        //reset variables such as levels etc..
        getSingleton().setCoins(0);
        hasCompleted = false;
        text.setText("");
    }  
}
