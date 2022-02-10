/*
 * Nate Stein
 * 3/28/17
 * Project 2: Monopoly GUI
 * Monopoly on UI
 */

package project2;

/**
 *
 * @author nds5188
 */

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JApplet;
import javax.swing.*;

public class Monopoly2 {

    /**
     * @param args the command line arguments
     */
    
    List<BoardLocation> gameBoard;
    List<Player> players;
    List<Property> props;
    
    public Monopoly2()
    {
        //create an instance of the Player list
        //Create an instance of the BoardLocagtion list
        players = new ArrayList<Player>();
        props = new ArrayList<Property>();
        gameBoard = new ArrayList<BoardLocation>();
        getBoard();
        getProps();
    }
    
    public void setLotRent() // This method is new from project 1
    {
        Lot mediterranean = (Lot)gameBoard.get(1);
        switch (mediterranean.getNumHouses())
        {
            case 1:
                mediterranean.setRent(10);
                break;
            case 2:
                mediterranean.setRent(30);
                break;
            case 3:
                mediterranean.setRent(90);
                break;
            case 4:
                mediterranean.setRent(160);
                break;
            case 5:
                mediterranean.setRent(230);
                break;
            default:
                mediterranean.setRent(2);
                break;
        }
        Lot baltic = (Lot)gameBoard.get(3);
        switch (baltic.getNumHouses()) 
        {
            case 1:
                baltic.setRent(20);
                break;
            case 2:
                baltic.setRent(60);
                break;
            case 3:
                baltic.setRent(180);
                break;
            case 4:
                baltic.setRent(320);
                break;
            case 5:
                baltic.setRent(450);
                break;
            default:
                baltic.setRent(4);
                break;
        }
        Lot oriental = (Lot)gameBoard.get(6);
        Lot vermont = (Lot)gameBoard.get(8);
        switch (oriental.getNumHouses()) 
        {
            case 1:
                oriental.setRent(30);                
                break;
            case 2:
                oriental.setRent(90);                
                break;
            case 3:
                oriental.setRent(270);                
                break;
            case 4:
                oriental.setRent(400);                
                break;
            case 5:
                oriental.setRent(550);
                break;
            default:
                oriental.setRent(6);
                break;
        }
        switch (vermont.getNumHouses()) 
        {
            case 1:                
                vermont.setRent(30);
                break;
            case 2:                
                vermont.setRent(90);
                break;
            case 3:                
                vermont.setRent(270);
                break;
            case 4:                
                vermont.setRent(400);
                break;
            case 5:                
                vermont.setRent(550);
                break;
            default:
                vermont.setRent(6);
                break;
        }
        Lot connecticut = (Lot)gameBoard.get(9);
        switch (connecticut.getNumHouses()) 
        {
            case 1:
                connecticut.setRent(40);
                break;
            case 2:
                connecticut.setRent(100);
                break;
            case 3:
                connecticut.setRent(300);
                break;
            case 4:
                connecticut.setRent(450);
                break;
            case 5:
                connecticut.setRent(600);
                break;
            default:
                connecticut.setRent(8);
                break;
        }
        Lot stCharles = (Lot)gameBoard.get(11);
        Lot states = (Lot)gameBoard.get(13);
        switch (stCharles.getNumHouses()) 
        {
            case 1:
                stCharles.setRent(50);                
                break;
            case 2:
                stCharles.setRent(150);                
                break;
            case 3:
                stCharles.setRent(450);               
                break;
            case 4:
                stCharles.setRent(625);                
                break;
            case 5:
                stCharles.setRent(750);
                break;
            default:
                stCharles.setRent(10);
                break;
        }
        switch (states.getNumHouses()) 
        {
            case 1:                
                states.setRent(50);
                break;
            case 2:                
                states.setRent(150);
                break;
            case 3:                
                states.setRent(450);
                break;
            case 4:                
                states.setRent(625);
                break;
            case 5:                
                states.setRent(750);
                break;
            default:
                states.setRent(10);
                break;
        }
        Lot virginia = (Lot)gameBoard.get(14);
        switch (virginia.getNumHouses()) 
        {
            case 1:
                virginia.setRent(60);
                break;
            case 2:
                virginia.setRent(180);
                break;
            case 3:
                virginia.setRent(500);
                break;
            case 4:
                virginia.setRent(700);
                break;
            case 5:
                virginia.setRent(900);
                break;
            default:
                virginia.setRent(12);
                break;
        }
        Lot stJames = (Lot)gameBoard.get(16);
        Lot tennessee = (Lot)gameBoard.get(18);
        switch (stJames.getNumHouses()) 
        {
            case 1:
                stJames.setRent(70);                
                break;
            case 2:
                stJames.setRent(200);                
                break;
            case 3:
                stJames.setRent(550);                
                break;
            case 4:
                stJames.setRent(750);                
                break;
            case 5:
                stJames.setRent(950);
                break;
            default:
                stJames.setRent(14);
                break;
        }
        switch (tennessee.getNumHouses()) 
        {
            case 1:                
                tennessee.setRent(70);
                break;
            case 2:                
                tennessee.setRent(200);
                break;
            case 3:                
                tennessee.setRent(550);
                break;
            case 4:                
                tennessee.setRent(750);
                break;
            case 5:                
                tennessee.setRent(950);
                break;
            default:
                tennessee.setRent(14);
                break;
        }
        Lot newYork = (Lot)gameBoard.get(19);
        switch (newYork.getNumHouses()) 
        {
            case 1:
                newYork.setRent(80);
                break;
            case 2:
                newYork.setRent(220);
                break;
            case 3:
                newYork.setRent(600);
                break;
            case 4:
                newYork.setRent(800);
                break;
            case 5:
                newYork.setRent(1000);
                break;
            default:
                newYork.setRent(16);
                break;
        }
        Lot kentucky = (Lot)gameBoard.get(21);
        Lot indiana = (Lot)gameBoard.get(23);
        switch (kentucky.getNumHouses()) 
        {
            case 1:
                kentucky.setRent(90);                
                break;
            case 2:
                kentucky.setRent(250);                
                break;
            case 3:
                kentucky.setRent(700);
                break;
            case 4:
                kentucky.setRent(875);                
                break;
            case 5:
                kentucky.setRent(1050);                
                break;
            default:
                kentucky.setRent(18);
                break;
        }
        switch (indiana.getNumHouses()) 
        {
            case 1:                
                indiana.setRent(90);
                break;
            case 2:                
                indiana.setRent(250);
                break;
            case 3:                
                indiana.setRent(700);
                break;
            case 4:                
                indiana.setRent(875);
                break;
            case 5:                
                indiana.setRent(1050);
                break;
            default:
                indiana.setRent(18);
                break;
        }
        Lot illinois = (Lot)gameBoard.get(24);
        switch (illinois.getNumHouses()) 
        {
            case 1:
                illinois.setRent(100);
                break;
            case 2:
                illinois.setRent(300);
                break;
            case 3:
                illinois.setRent(750);
                break;
            case 4:
                illinois.setRent(925);
                break;
            case 5:
                illinois.setRent(1100);
                break;
            default:
                illinois.setRent(20);
                break;
        }
        Lot atlantic = (Lot)gameBoard.get(26);
        switch (atlantic.getNumHouses()) 
        {
            case 1:
                atlantic.setRent(110);
                break;
            case 2:
                atlantic.setRent(330);
                break;
            case 3:
                atlantic.setRent(800);
                break;
            case 4:
                atlantic.setRent(975);
                break;
            case 5:
                atlantic.setRent(1150);
                break;
            default:
                atlantic.setRent(22);
                break;
        }
        Lot ventnor = (Lot)gameBoard.get(27);
        switch (ventnor.getNumHouses()) 
        {
            case 1:
                ventnor.setRent(110);
                break;
            case 2:
                ventnor.setRent(330);
                break;
            case 3:
                ventnor.setRent(800);
                break;
            case 4:
                ventnor.setRent(975);
                break;
            case 5:
                ventnor.setRent(1150);
                break;
            default:
                ventnor.setRent(22);
                break;
        }
        Lot marvinGardens = (Lot)gameBoard.get(29);
        switch (marvinGardens.getNumHouses()) 
        {
            case 1:
                marvinGardens.setRent(120);
                break;
            case 2:
                marvinGardens.setRent(360);
                break;
            case 3:
                marvinGardens.setRent(850);
                break;
            case 4:
                marvinGardens.setRent(1025);
                break;
            case 5:
                marvinGardens.setRent(1200);
                break;
            default:
                marvinGardens.setRent(24);
                break;
        }
        Lot pacific = (Lot)gameBoard.get(31);
        switch (pacific.getNumHouses()) 
        {
            case 1:
                pacific.setRent(130);
                break;
            case 2:
                pacific.setRent(390);
                break;
            case 3:
                pacific.setRent(900);
                break;
            case 4:
                pacific.setRent(1100);
                break;
            case 5:
                pacific.setRent(1275);
                break;
            default:
                pacific.setRent(26);
                break;
        }
        Lot noCarolina = (Lot)gameBoard.get(32);
        switch (noCarolina.getNumHouses()) 
        {
            case 1:
                noCarolina.setRent(130);
                break;
            case 2:
                noCarolina.setRent(390);
                break;
            case 3:
                noCarolina.setRent(900);
                break;
            case 4:
                noCarolina.setRent(1100);
                break;
            case 5:
                noCarolina.setRent(1275);
                break;
            default:
                noCarolina.setRent(26);
                break;
        }
        Lot pennsylvania = (Lot)gameBoard.get(34);
        switch (pennsylvania.getNumHouses()) 
        {
            case 1:
                pennsylvania.setRent(150);
                break;
            case 2:
                pennsylvania.setRent(450);
                break;
            case 3:
                pennsylvania.setRent(1000);
                break;
            case 4:
                pennsylvania.setRent(1200);
                break;
            case 5:
                pennsylvania.setRent(1400);
                break;
            default:
                pennsylvania.setRent(28);
                break;
        }
        Lot parkPlace = (Lot)gameBoard.get(37);
        switch (parkPlace.getNumHouses()) 
        {
            case 1:
                parkPlace.setRent(170);
                break;
            case 2:
                parkPlace.setRent(500);
                break;
            case 3:
                parkPlace.setRent(1100);
                break;
            case 4:
                parkPlace.setRent(1300);
                break;
            case 5:
                parkPlace.setRent(1500);
                break;
            default:
                parkPlace.setRent(35);
                break;
        }
        Lot boardwalk = (Lot)gameBoard.get(39);
        switch (boardwalk.getNumHouses()) 
        {
            case 1:
                boardwalk.setRent(200);
                break;
            case 2:
                boardwalk.setRent(600);
                break;
            case 3:
                boardwalk.setRent(1400);
                break;
            case 4:
                boardwalk.setRent(1700);
                break;
            case 5:
                boardwalk.setRent(2000);
                break;
            default:
                boardwalk.setRent(50);
                break;
        }
    }
    
    protected List<Property> getProps()
    {        
        props.add(new Lot(1, "Mediterranean Ave", "Bank", 60, 2, "Dark Purple", 50, 0, false));        
        props.add(new Lot(3, "Baltic Ave", "Bank", 60, 4, "Dark Purple", 50, 0, false));
        props.add(new Railroad(5, "Reading Railroad", "Bank", 200, 0));
        props.add(new Lot(6, "Oriental Ave", "Bank", 100, 6, "Light Blue", 50, 0, false));
        props.add(new Lot(8, "Vermont Ave", "Bank", 100, 6, "Light Blue", 50, 0, false));
        props.add(new Lot(9, "Connecticut Ave", "Bank", 120, 8, "Light Blue", 50, 0, false));
        props.add(new Lot(11, "St Charles Place", "Bank", 140, 12, "Light Purple", 100, 0, false));
        props.add(new Utility(12, "Electric Company", "Bank", 150, 0, 0));
        props.add(new Lot(13, "States Ave", "Bank", 140, 12, "Light Purple", 100, 0, false));
        props.add(new Lot(14, "Virginia Ave", "Bank", 160, 14, "Light Purple", 100, 0, false));
        props.add(new Railroad(15, "Pennsylvania Railroad", "Bank", 200, 0));
        props.add(new Lot(16, "ST James Place", "Bank", 180, 14, "Orange", 100, 0, false));
        props.add(new Lot(18, "Tennessee Ave", "Bank", 180, 14, "Orange", 100, 0, false));
        props.add(new Lot(19, "New York Ave", "Bank", 200, 16, "Orange", 100, 0, false));
        props.add(new Lot(21, "Kentucky Ave", "Bank", 220, 18, "Red", 150, 0, false));
        props.add(new Lot(23, "Indiana Ave", "Bank", 220, 18, "Red", 150, 0, false));
        props.add(new Lot(24, "Illinois Ave", "Bank", 240, 20, "Red", 150, 0, false));
        props.add(new Railroad(25, "B & O Railroad", "Bank", 200, 0));
        props.add(new Lot(26, "Atlantic Ave", "Bank", 260, 22, "Yellow", 150, 0, false));
        props.add(new Lot(27, "Ventnor Ave", "Bank", 260, 22, "Yellow", 150, 0, false));
        props.add(new Utility(28, "Water Works", "Bank", 150, 0, 0));
        props.add(new Lot(29, "Marvin Gardens", "Bank", 280, 24, "Yellow", 150, 0, false));
        props.add(new Lot(31, "Pacific Ave", "Bank", 300, 26, "Green", 200, 0, false));
        props.add(new Lot(32, "NO Carolina Ave", "Bank", 300, 26, "Green", 200, 0, false));
        props.add(new Lot(34, "Pennsylvania Ave", "Bank", 320, 28, "Green", 200, 0, false));
        props.add(new Railroad(35, "Short Line Railroad", "Bank", 200, 0));
        props.add(new Lot(37, "Park Place", "Bank", 350, 35, "Dark Blue", 200, 0, false));
        props.add(new Lot(39, "Boardwalk", "Bank", 400, 50, "Dark Blue", 200, 0, false));
        return props;
    }
    
    protected List<BoardLocation> getBoard()
    {
        gameBoard.add(new CornerSquare(0, "Go"));
        gameBoard.add(new Lot(1, "Mediterranean Ave", "Bank", 60, 2, "Dark Purple", 50, 0, false));
        gameBoard.add(new CardSquare(2, "Community Chest"));
        gameBoard.add(new Lot(3, "Baltic Ave", "Bank", 60, 4, "Dark Purple", 50, 0, false));
        gameBoard.add(new TaxSquare(4, "Income Tax"));
        gameBoard.add(new Railroad(5, "Reading Railroad", "Bank", 200, 0));
        gameBoard.add(new Lot(6, "Oriental Ave", "Bank", 100, 6, "Light Blue", 50, 0, false));
        gameBoard.add(new CardSquare(7, "Chance"));
        gameBoard.add(new Lot(8, "Vermont Ave", "Bank", 100, 6, "Light Blue", 50, 0, false));
        gameBoard.add(new Lot(9, "Connecticut Ave", "Bank", 120, 8, "Light Blue", 50, 0, false));
        gameBoard.add(new CornerSquare(10, "Jail"));
        gameBoard.add(new Lot(11, "St Charles Place", "Bank", 140, 12, "Light Purple", 100, 0, false));
        gameBoard.add(new Utility(12, "Electric Company", "Bank", 150, 0, 0));
        gameBoard.add(new Lot(13, "States Ave", "Bank", 140, 12, "Light Purple", 100, 0, false));
        gameBoard.add(new Lot(14, "Virginia Ave", "Bank", 160, 14, "Light Purple", 100, 0, false));
        gameBoard.add(new Railroad(15, "Pennsylvania Railroad", "Bank", 200, 0));
        gameBoard.add(new Lot(16, "ST James Place", "Bank", 180, 14, "Orange", 100, 0, false));
        gameBoard.add(new CardSquare(17, "Community Chest"));
        gameBoard.add(new Lot(18, "Tennessee Ave", "Bank", 180, 14, "Orange", 100, 0, false));
        gameBoard.add(new Lot(19, "New York Ave", "Bank", 200, 16, "Orange", 100, 0, false));
        gameBoard.add(new CornerSquare(20, "Free Parking"));
        gameBoard.add(new Lot(21, "Kentucky Ave", "Bank", 220, 18, "Red", 150, 0, false));
        gameBoard.add(new CardSquare(22, "Chance"));
        gameBoard.add(new Lot(23, "Indiana Ave", "Bank", 220, 18, "Red", 150, 0, false));
        gameBoard.add(new Lot(24, "Illinois Ave", "Bank", 240, 20, "Red", 150, 0, false));
        gameBoard.add(new Railroad(25, "B & O Railroad", "Bank", 200, 0));
        gameBoard.add(new Lot(26, "Atlantic Ave", "Bank", 260, 22, "Yellow", 150, 0, false));
        gameBoard.add(new Lot(27, "Ventnor Ave", "Bank", 260, 22, "Yellow", 150, 0, false));
        gameBoard.add(new Utility(28, "Water Works", "Bank", 150, 0, 0));
        gameBoard.add(new Lot(29, "Marvin Gardens", "Bank", 280, 24, "Yellow", 150, 0, false));
        gameBoard.add(new CornerSquare(30, "Go to jail"));
        gameBoard.add(new Lot(31, "Pacific Ave", "Bank", 300, 26, "Green", 200, 0, false));
        gameBoard.add(new Lot(32, "NO Carolina Ave", "Bank", 300, 26, "Green", 200, 0, false));
        gameBoard.add(new CardSquare(33, "Community Chest"));
        gameBoard.add(new Lot(34, "Pennsylvania Ave", "Bank", 320, 28, "Green", 200, 0, false));
        gameBoard.add(new Railroad(35, "Short Line Railroad", "Bank", 200, 0));
        gameBoard.add(new CardSquare(36, "Chance"));
        gameBoard.add(new Lot(37, "Park Place", "Bank", 350, 35, "Dark Blue", 200, 0, false));
        gameBoard.add(new TaxSquare(38, "Income Tax"));
        gameBoard.add(new Lot(39, "Boardwalk", "Bank", 400, 50, "Dark Blue", 200, 0, false));
        return gameBoard;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        JApplet graphics = new Interface();
        graphics.init();
        JFrame frame = new JFrame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphics);
        frame.setSize(1330, 700);
        frame.setMinimumSize(new Dimension(1100, 680));
        frame.setVisible(true);
    }
}