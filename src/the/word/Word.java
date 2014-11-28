package the.word;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import static the.word.Generate.counter;
import static the.word.Generate.generateWord;
import static the.word.Generate.label;
import static the.word.Generate.time;

/**
 *
 * @author James
 */
public class Word extends JFrame implements Runnable {
    
    /**
     * Declare our height and width of the application.
     */
    private final int HEIGHT = 600, WIDTH = 250;
   
    /**
     * Construct a new Word.
     */
    public Word() {
        setSize(HEIGHT, WIDTH);
        setTitle("The word game - created by James");      
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().add(new Generate()); 
        
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Main entry point to the application.
     * @param args 
     */
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        new Word().run();   
    }

    /**
     * Our main run method, enclosed in a while loop for regular check back.
     */
    @Override
    public void run() {
        while(true) {
            while(counter != 0) {
            try {
                //decrement the counter
                counter = counter - 1;
                
                //ovveride the current label's text
                time.setText("You have : " + counter + " seconds left!");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         
        if(counter == 0) {
            //override new value of the counter
            counter = 10;
            
            //ovveride the current label's text again
            label.setText("The new word is: " + generateWord());   
            Generate.reset();
        }
      }
    }
    
}
