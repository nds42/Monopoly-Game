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

public class Property extends BoardLocation {

    private String owner;
    private int purchaseCost;    
    
    public Property()
    {
        owner = "";
        purchaseCost = 0;        
    }
    public Property(int address, String locName, String owner, int purchaseCost)
    {
        super(address, locName);
        this.owner = owner;
        this.purchaseCost = purchaseCost;        
    }   
    public void setOwner(String buyer)
    {
        owner = buyer;
    }    
    public String getOwner()
    {
        return owner;
    }
    public int getPurchaseCost()
    {
        return purchaseCost;
    }    
    @Override
    public String toString()
    {
        return super.toString() + ", Owner is " + owner + ", Cost is $" + purchaseCost;
    }
    
    @Override
    public String getPossibleAction(Player player) 
    {        
        if ("Bank".equals(owner))
        {
            return "Click on 1 if you would like to buy it, and 2 to do nothing";
        }
        else if (player.getToken().equalsIgnoreCase(owner))
        {
            return "This is your property. End turn";
        }
        else
            return "You owe rent";
    }
    
}
