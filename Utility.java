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
public class Utility extends Property {
    private int rent;
    private int diceRoll;
    
    public Utility(int address, String locName, String owner, int purchaseCost, int rent, int dice)
    {
        super(address, locName, owner, purchaseCost);
        rent = 0;
        diceRoll = dice;
    }
    
    public void setUtilRent(int numUtilities, int dice)
    {
        switch (numUtilities) {
            case 1:
                rent = dice * 4;
                break;
            case 2:
                rent = dice * 10;
                break;
            default:
                rent = 0;
                break;
        }
        diceRoll = dice;
    }
    public int getDiceRoll()
    {
        return diceRoll;
    }
    public int getUtilRent()
    {
        return rent;
    }
    @Override
    public String toString()
    {
        return "On space " + getAddress() + ", Location name is " + getLocName() + ", Owner is " + getOwner() + ", Cost is $" + 
                getPurchaseCost();
    }
    @Override
    public String getPossibleAction(Player player) 
    {        
        if ("Bank".equals(getOwner()))
        {
            return "";
        }
        else if (getOwner().equals(player.getToken()))
        {
            return "This is your property. End turn";
        }
        else
        {
            return "";
        }
    }
    
}
