/*
 * Nate Stein
 * 2/6/17
 * Project 1: Monopoly
 * Creating the game monopoly
 */
package project2;

/**
 *
 * @author nds5188
 */
import java.util.Random;

public class CardSquare extends BoardLocation {
    int amtMoney;
    public CardSquare(int address, String locName)
    {
        super(address, locName);        
    }
    
    public int getAmtMoney()
    {
        return amtMoney;
    }
    @Override
    public String getPossibleAction(Player player) 
    {
        Random n = new Random();
        amtMoney = n.nextInt(400)-200;
        // Set player money
        player.setMoneyAmt(amtMoney);        
        // Inform user what happened
        if (amtMoney >= 0)
            return "You received $" + amtMoney;
        else
            return "You lost $" + Math.abs(amtMoney);        
    }    
    
}
