package the.word;

/**
 *
 * @author James
 * 
 * This class will represent the coin system.
 */
public class Coin {
 
    /**
     * A single coin.
     */
    private int coin;
    
    /**
     * The coin constructor parsing the coin amount as arguments.
     * @param coin 
     */
    public Coin(int coin) {
        this.coin = coin;
        this.coin = 10;
    }
    
    /**
     * Gets the coins
     * @return coin
     */
    public int getCoins() {
        return coin;
    }
    
    /**
     * Sets the coins value.
     * @param coin
     * @return this.coin = coin;
     */
    public int setCoins(int coin) {
        return this.coin = coin;       
    }  
    
}
