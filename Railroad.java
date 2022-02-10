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
public class Railroad extends Property {
    private int rent;
    public Railroad(int address, String locName, String owner, int purchaseCost, int rent)
    {
        super(address, locName, owner, purchaseCost);
        rent = 25;
    }
    
    public void setRailRent(int numRailroads)
    {
        switch (numRailroads) {
            case 1:
                rent = 25;
                break;
            case 2:
                rent = 50;
                break;
            case 3:
                rent = 100;
                break;
            case 4:
                rent = 200;
                break;
            default:
                rent = 0;
                break;
        }
    }
    
    public int getRailRent()
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
