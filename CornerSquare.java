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
public class CornerSquare extends BoardLocation {
    boolean toJail;    
    public CornerSquare(int address, String locName)
    {
        super(address, locName);
        toJail = address == 30;
    }
    public boolean toJail()
    {
        return toJail;
    }
    
    @Override
    public String getPossibleAction(Player player) 
    {
        // Set up GO actions
        if (player.getLocation() == 0)
        {
            return "You landed on GO\n";
        }
        else
        {
            if (player.getLocation() == 30)
            {
                return "You are going to jail";
            }
            else         
                return "End turn";
        }
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
}
