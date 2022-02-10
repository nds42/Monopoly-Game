/*
 * Nate Stein
 * 2/6/17
 * Project 1: Monopoly
 * Creating the game monopoly
 */
package project2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nds5188
 */
public class Player {
    private int location;
    private double moneyAmt;
    private String token;
    private List<Property> ownedProps;
    private List<Lot> ownedLots;
    private int numRailroads;
    private int numUtilities;
        
    public Player(String token)
    {
        location = 0;
        moneyAmt = 1500;
        this.token = token;
        this.ownedProps = new ArrayList<Property>();
        this.ownedLots = new ArrayList<Lot>();
    }

    public void setMoneyAmt(int money)
    {
        moneyAmt += money;
    }
    public void buyLot(Lot lot)
    {
        ownedLots.add(lot);
    }
    public void buyProperty(Property prop)
    {
        ownedProps.add(prop);
    }    
    public Lot getLots(int y)
    {
        return ownedLots.get(y);
    }
    public boolean ownsLots()
    {
        return !ownedLots.isEmpty();
    }
    public List<Lot> getOwnedLots2()
    {
        return ownedLots;
    }
    public String getOwnedLots()
    {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Property ints : ownedLots)
        {
            sb.append(i).append(". ").append(ints.getLocName()).append(" ");
            i++;
        }
        return sb.toString();
    }   
    public String getOwnedProps()
    {
        StringBuilder sb = new StringBuilder();
        for (Property ints : ownedProps)
        {
            sb.append(ints.getLocName()).append(", ");
        }
        return sb.toString();
    }                
    public void setLocation(int loc)
    {
        location = loc;
    }
    public void buyRailroad()
    {
        numRailroads++;
    }
    public void buyUtility()
    {
        numUtilities++;
    }
    public void setToken(String token)
    {
        this.token = token;
    }
    public int getNumRailroads()
    {
        return numRailroads;
    }
    public int getNumUtilities()
    {
        return numUtilities;
    }
    public double getMoneyAmt()
    {
        return moneyAmt;
    }
    public String getToken()
    {
        return token;
    }
    public int getLocation()
    {
        return location;
    }
    @Override
    public String toString()
    {
        return "Location is " + location + ", Money amount is " + moneyAmt + ", Token is " + token
                + ", Owned Properties are " + ownedProps;
    }
}
