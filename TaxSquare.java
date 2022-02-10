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

public class TaxSquare extends BoardLocation {
    int amtDue;
    
    public TaxSquare(int address, String locName)
    {
        super(address, locName);
        if (address == 4)
            amtDue = 200;
        if (address == 38)
            amtDue = 75;
    }
    public int getAmtDue()
    {
        return amtDue;
    }
    
    @Override
    public String getPossibleAction(Player player) 
    {
        return "You must pay $" + amtDue + " for taxes";
    }
    @Override
    public String toString()
    {
        return super.toString() + " Amount Due is $" + amtDue;
    }
}
