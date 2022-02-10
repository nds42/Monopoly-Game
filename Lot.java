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
public class Lot extends Property {   
    private int rent;
    private final String lotColor;
    private final int houseCost;
    private int numHouses;
    private boolean hasHotel;
    
    public Lot()
    {
        rent = 0;
        lotColor = "";
        houseCost = 0;
        numHouses = 0;        
        hasHotel = false;
    }
    public Lot(int address, String locName, String owner, int purchaseCost, int rent, String lotColor, int houseCost, int numHouses, boolean hasHotel)
    {
        super(address, locName, owner, purchaseCost);
        this.rent = rent;
        this.lotColor = lotColor;
        this.houseCost = houseCost;
        this.numHouses = numHouses;
        this.hasHotel = hasHotel;
    }
    public void setRent(int rent)
    {
        this.rent = rent;
    }
    public void addHouse()
    {
        numHouses++;
        setHasHotel();
    }
    public void removeHouse()
    {
        numHouses--;
    }
    public void setHasHotel()
    {
        hasHotel = numHouses == 5;
    }    
    public int getRent()
    {
        return rent;
    }
    public String getlotColor()
    {
        return lotColor;
    }
    public int getHouseCost()
    {
        return houseCost;
    }
    public int getNumHouses()
    {
        return numHouses;
    }
    public boolean hasHotel()
    {
        return hasHotel;
    }
    @Override
    public String toString()
    {
        return super.toString() + "\n Rent is $" + rent +", Lot Color is " + lotColor + ", House Cost is $" + houseCost 
                + ", House Number is " + numHouses + ", Has Hotel: " + hasHotel;
    }
    @Override
    public String getPossibleAction(Player player) 
    {
        if ("Bank".equals(getOwner()))
        {
            return "";
        }
        else if (player.getToken().equalsIgnoreCase(getOwner()))
        {
            return "This is your property. End turn";
        }
        else
        {
            return "You owe $" + getRent() + " for rent. End turn";
        }
    }
}
