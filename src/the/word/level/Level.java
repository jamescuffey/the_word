package the.word.level;

import the.word.Coin;

/**
 *
 * @author James
 */
public abstract class Level {
    
    public abstract int level();
    
    public abstract double difficulty();
    
    public abstract String levelName();
    
    public abstract Coin reward();   
}
