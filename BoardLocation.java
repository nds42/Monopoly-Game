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
public abstract class BoardLocation {    
    private int address;
    private String locName;
    
    public BoardLocation()
    {
        address = 0;
        locName = "";
    }
    public BoardLocation(int address, String locName)
    {
        this.address = address;
        this.locName = locName;
    }        
    public int getAddress()
    {
        return address;
    }
    public String getLocName()
    {
        return locName;
    }
    @Override
    public String toString()
    {
        return "On space " + address + ", Location name is " + locName;
    }
    //abstract getpossibleaction
    public abstract String getPossibleAction(Player player);
}
