package the.word;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author James
 */
public class Generate extends JPanel {
 
    /**
     * Our counter used for the timer.
     * 
     * No point in encapsulation, as the value needs to be changed statically.
     */
    public static int counter = 10;  
    
    /**
     * The timer label that hasn't yet be initialised.
     */
    public static Label time;
    
    /**
     * The label for generating new words.
     */
    public static Label label;
 
    /**
     * Initialise the random generator.
     */
    private static Random generator = new Random();
    
    /**
     * Stores the current word.
     */
    public static String currentWord = "";
    
    /**
     * Holds a list of all the words.
     */
    public static final String WORDS[] = {"Dictionary", "Acquire", "Atheist", "Argument"};
    
    /**
     * Construct our new words.
     */
    public Generate() {
        label = new Label("The new word is: " + generateWord());
        JTextField word = new JTextField(10);
        time = new Label("You have : " + counter + " seconds left!");
        JButton button = new JButton("Confirm my choice");
        
        //handles the logic for clicking the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogic(word);
            }
        });
        
        time.setPreferredSize(new Dimension(420, 250));
        word.setLocation(0, 0);   
        label.setSize(10, 10);
        button.setLocation(0, 10);
        time.setForeground(Color.red);    
  
        label.setForeground(Color.white);
        
        //add the components to the JPanel
        add(label);
        add(word);
        add(button);
        add(time);
        
        //set its background to dark gray.
        setBackground(Color.DARK_GRAY);
    }
    
    
    /**
     * Handle the logic for the text field.
     * @param word 
     */
    public void handleLogic(JTextField word) {
        if(word.getText().contains(currentWord) && counter > 0) {
            System.out.println("Your right!");
        } else if(!word.getText().contains(currentWord)) {
            System.out.println("Wrong word!");
        } else {
            System.out.println("Time has ran out!");
        }
    }
  
    /**
     * Generates a new word.
     */
    public static String generateWord() {
        int randomWord = generator.nextInt(WORDS.length);
        String result = "";
 
        //store the words in a temp variable
        currentWord = WORDS[randomWord];  
        
        //check if it's not empty
        if(currentWord != null) {
            int randomLetter = generator.nextInt(currentWord.length());
       
            StringBuilder sb = new StringBuilder(currentWord);
            sb.deleteCharAt(randomLetter);
            result = sb.toString();
        }
        return result;     
    }
    
    public void reset() {
        //reset variables such as levels etc..
    }
   
}
