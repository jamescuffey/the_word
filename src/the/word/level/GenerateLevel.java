package the.word.level;

/**
 *
 * @author James
 */
public class GenerateLevel {
    
    private int level;
   
    public enum DIFFICULTY {
        EASY(0),
        MEDIUM(1),
        HARD(2);
        
        private int difficulty;
        
        public int getDifficulty() {
            return difficulty;
        }
        
        DIFFICULTY(int difficulty) {
            this.difficulty = difficulty;
        }
    }
    
    public GenerateLevel() {
        level = 0;    
    }
    
    public int getLevel() {
        return level;
    }
    
    public int setLevel(int level) {
        return this.level = level;
    }
    
    private DIFFICULTY difficulty;
    
    public void setDifficulty(int difficultyLevel) {
        difficulty = DIFFICULTY.values()[difficultyLevel];
        switch(difficulty) {
            case EASY:
                setLevel(1);
                
                //set other attributes here
                break;
                
            case MEDIUM:
                setLevel(2);
                
                //set other attributes here
                break;
                
            case HARD:
                setLevel(3);                
                
                //set other attributes here
                break;      
        }
      
    }

    
    public void handleDifficulty() {
        
    
    }
    
    
    
}
