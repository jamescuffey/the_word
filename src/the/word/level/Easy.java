package the.word.level;

import the.word.Coin;

/**
 *
 * @author James
 */
public class Easy extends Level {

    @Override
    public int level() {
        return 1;
    }

    @Override
    public double difficulty() {
        return 2.5;
    }

    @Override
    public String levelName() {
        return "Easy level";
    }

    @Override
    public Coin reward() {
        return new Coin(5);
    }
    
}
