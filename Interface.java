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
import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Interface extends JApplet implements ActionListener, ItemListener
{
    Monopoly2 game = new Monopoly2();
    private int y = 0;
    private JLabel label;
    private ImageIcon icon;
    private Image board;
    private int l = 0;
    private int i;
    private int x = 0;
    private int prevLocation;
    private JLabel usersQ;
    private JComboBox userSelect;
    private final String[] numUsers = {"", "2", "3", "4"};
    private final JLabel[] nameQs = new JLabel[4];
    private final JTextField[] names = new JTextField[4];
    private final JButton[] addPlayers = new JButton[4];
    private final JPanel[] addingUsers = new JPanel[4];
    private final String[] tokens = {"Hat", "Shoe", "Cannon", "Race Car"};
    private JButton selectNum;
    private JButton go;
    private final JButton[] menuOptions = new JButton[4];
    private final JLabel[] optionLabels = new JLabel[4];
    private JPanel menu;
    private JLabel[] playerInfo;
    private JLabel turn;
    private final JLabel doubles = new JLabel("Doubles were rolled. Go again");
    private final JLabel passedGo = new JLabel("You passed GO and collected $200.");
    private JLabel spaceInfo;
    private JLabel possibleAction;
    private final JRadioButton[] purchase = new JRadioButton[2];
    private ButtonGroup buy;
    private JLabel purchaseResult;
    private JLabel oweRent;
    private final JLabel[] boardInfo = new JLabel[40];    
    private JPanel curState;
    private JLabel diceRoll;
    private JLabel selectLot;
    private JRadioButton[] lotNum;
    private ButtonGroup lotNumGroup;
    private JLabel lotChosen;
    private JRadioButton buyHouse;
    private JRadioButton removeHouse;
    private ButtonGroup houseOptions;
    private JLabel houseResult;
    private GridLayout layout;
    private FlowLayout layout2;
    private GridLayout state;
    private JScrollPane jsPane;
    private int d1, d2;
    
    @Override
    public void init()
    {
        icon = new ImageIcon("build\\Board.jpg");
        board = icon.getImage();
        Image newIm = board.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newIm);
        label = new JLabel(icon);
        add(label);
        for (int k = 0; k < 40; k++)
            boardInfo[k] = new JLabel("");
        houseResult = new JLabel("");
        houseOptions = new ButtonGroup();
        buyHouse = new JRadioButton("Add a house");
        removeHouse = new JRadioButton("Remove a house");
        buyHouse.addItemListener(this);
        removeHouse.addItemListener(this);
        houseOptions.add(buyHouse);
        houseOptions.add(removeHouse);
        lotChosen = new JLabel("");
        lotNumGroup = new ButtonGroup();
        selectLot = new JLabel("");
        diceRoll = new JLabel("");
        turn = new JLabel("");
        oweRent = new JLabel("");
        purchaseResult = new JLabel("");
        possibleAction = new JLabel("");
        spaceInfo = new JLabel("");
        purchase[0] = new JRadioButton("Purchase");
        purchase[1] = new JRadioButton("Do Nothing");
        purchase[0].addItemListener(this);
        purchase[1].addItemListener(this);
        buy = new ButtonGroup();
        buy.add(purchase[0]);
        buy.add(purchase[1]);
        layout2 = new FlowLayout();
        layout2.setAlignment(FlowLayout.LEFT);
        setLayout(layout2);
        usersQ = new JLabel("How many users should there be?");
        add(usersQ);
        userSelect = new JComboBox(numUsers);
        userSelect.addItemListener(this);
        add(userSelect);
        selectNum = new JButton("Continue");
        selectNum.addActionListener(this);
        add(selectNum);
        nameQs[0] = new JLabel("What name should we give user number 1?");
        names[0] = new JTextField(10);
        names[0].addActionListener(this);
        addPlayers[0] = new JButton("Add user");
        addPlayers[0].addActionListener(this);
        addingUsers[0] = new JPanel();
        addingUsers[0].add(nameQs[0]);
        addingUsers[0].add(names[0]);
        addingUsers[0].add(addPlayers[0]);
        nameQs[1] = new JLabel("What name should we give user number 2?");
        names[1] = new JTextField(10);
        names[1].addActionListener(this);
        addPlayers[1] = new JButton("Add user");
        addPlayers[1].addActionListener(this);
        addingUsers[1] = new JPanel();
        addingUsers[1].add(nameQs[1]);
        addingUsers[1].add(names[1]);
        addingUsers[1].add(addPlayers[1]);
        nameQs[2] = new JLabel("What name should we give user number 3?");
        names[2] = new JTextField(10);
        names[2].addActionListener(this);
        addPlayers[2] = new JButton("Add user");
        addPlayers[2].addActionListener(this);
        addingUsers[2] = new JPanel();
        addingUsers[2].add(nameQs[2]);
        addingUsers[2].add(names[2]);
        addingUsers[2].add(addPlayers[2]);
        nameQs[3] = new JLabel("What name should we give user number 4?");
        names[3] = new JTextField(10);
        names[3].addActionListener(this);
        addPlayers[3] = new JButton("Add user");
        addPlayers[3].addActionListener(this);
        addingUsers[3] = new JPanel();
        addingUsers[3].add(nameQs[3]);
        addingUsers[3].add(names[3]);
        addingUsers[3].add(addPlayers[3]);
        go = new JButton("Continue");
        go.addActionListener(this);
        curState = new JPanel();
        // I did not have the main menu in project 1
        layout = new GridLayout(4, 2, 4, 4);
        menuOptions[0] = new JButton("1");
        menuOptions[1] = new JButton("2");
        menuOptions[2] = new JButton("3");
        menuOptions[3] = new JButton("4");
        menuOptions[0].addActionListener(this);
        menuOptions[1].addActionListener(this);
        menuOptions[2].addActionListener(this);
        menuOptions[3].addActionListener(this);
        optionLabels[0] = new JLabel("Click on 1 to manage houses/hotels: ");
        optionLabels[1] = new JLabel("Click on 2 to roll dice: ");
        optionLabels[2] = new JLabel("Click on 3 to display board information: ");
        optionLabels[3] = new JLabel("Click on 4 to end game: ");
        menu = new JPanel();
        menu.setLayout(layout);
        menu.add(optionLabels[0]);
        menu.add(menuOptions[0]);
        menu.add(optionLabels[1]);
        menu.add(menuOptions[1]);
        menu.add(optionLabels[2]);
        menu.add(menuOptions[2]);
        menu.add(optionLabels[3]);
        menu.add(menuOptions[3]);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int k = 0; k < 40; k++)
        {            
            if (boardInfo[k].isShowing())
            {
                remove(boardInfo[k]);
            }
        }
        if (e.getSource() == selectNum)
        {
            if (userSelect.getSelectedItem() != "")
            {
                remove(usersQ);
                remove(userSelect);
                remove(selectNum);
            }
            
            if (userSelect.getSelectedItem() == "2")
            {
                i = 2;
                add(addingUsers[0]);
                add(addingUsers[1]);
                validate();
            }            
            else if (userSelect.getSelectedItem() == "3")
            {
                i = 3;
                add(addingUsers[0]);
                add(addingUsers[1]);
                add(addingUsers[2]);
                validate();
            }
            else if (userSelect.getSelectedItem() == "4")
            {
                i = 4;
                add(addingUsers[0]);
                add(addingUsers[1]);
                add(addingUsers[2]);
                add(addingUsers[3]);
                validate();
            }
            
        }        
        if (e.getSource() == addPlayers[0])
        {
            game.players.add(new Player(names[0].getText()));
            remove(addingUsers[0]);
            validate();
            if (!addingUsers[0].isShowing() && !addingUsers[1].isShowing() && !addingUsers[2].isShowing() && !addingUsers[3].isShowing())
            {
                add(go);
                validate();
            }
        }
        else if (e.getSource() == addPlayers[1])
        {
            game.players.add(new Player(names[1].getText()));
            remove(addingUsers[1]);
            validate();
            if (!addingUsers[0].isShowing() && !addingUsers[1].isShowing() && !addingUsers[2].isShowing() && !addingUsers[3].isShowing())
            {
                add(go);
                validate();
            }
        }
        else if (e.getSource() == addPlayers[2])
        {
            game.players.add(new Player(names[2].getText()));
            remove(addingUsers[2]);
            validate();
            if (!addingUsers[0].isShowing() && !addingUsers[1].isShowing() && !addingUsers[2].isShowing() && !addingUsers[3].isShowing())
            {
                add(go);
                validate();
            }
        }
        else if (e.getSource() == addPlayers[3])
        {            
            game.players.add(new Player(names[3].getText()));
            remove(addingUsers[3]);
            validate();
            if (!addingUsers[0].isShowing() && !addingUsers[1].isShowing() && !addingUsers[2].isShowing() && !addingUsers[3].isShowing())
            {
                add(go);
                validate();
            }
        }
        
        if (e.getSource() == go)
        {
            for (int k = 0; k < i; k++)
            {
                if (names[k].getText().equals(""))
                {
                    game.players.get(k).setToken(tokens[k]);
                }
            }
            remove(addingUsers[0]);
            remove(addingUsers[1]);
            remove(addingUsers[2]);
            remove(addingUsers[3]);
            remove(go);
            playerInfo = new JLabel[i];            
            for(int k = 0; k < i; k++)
            {
                playerInfo[k] = new JLabel(game.players.get(k).getToken() + " is on " + game.gameBoard.get(game.players.get(k).getLocation()).getLocName()
                        + " (space " + game.players.get(k).getLocation() + ") " + "Owned Properties are: " + game.players.get(k).getOwnedProps() + 
                        " Amount of money is: $" + game.players.get(k).getMoneyAmt());
                curState.add(playerInfo[k]);
            }            
            state = new GridLayout(i, 1, 2, 2);
            curState.setLayout(state);
            add(curState);
            turn.setText("It is " + game.players.get(0).getToken() + "'s turn");
            add(turn);
            add(menu);
            validate();
        }
        
        remove(possibleAction);
        remove(purchase[0]);
        remove(purchase[1]);
        remove(doubles);
        remove(purchaseResult);
        validate();
        // I did not have adding and removing houses in project 1
        if (e.getSource() == menuOptions[0])
        {
            menuOptions[0].setEnabled(false);
            validate();
            if (game.players.get(x).ownsLots())
            {
                selectLot.setText("Select the number of the lot which you want to modify houses with: " + game.players.get(x).getOwnedLots());
                add(selectLot);
                l = game.players.get(x).getOwnedLots2().size();
                lotNum = new JRadioButton[l];
                for (int k = 0; k < l; k++)
                {
                    lotNum[k] = new JRadioButton("" + (k+1));
                    lotNum[k].addItemListener(this);
                    add(lotNum[k]);
                    lotNumGroup.add(lotNum[k]);
                }
                validate();
            }
            else
            {
                selectLot.setText("You do not own any lots. This action is unavailable.");
                add(selectLot);
                validate();
            }
        }
        else if (e.getSource() == menuOptions[1])
        {
            remove(oweRent);
            remove(lotChosen);
            remove(selectLot);
            remove(houseResult);
            remove(passedGo);
            menuOptions[0].setEnabled(true);
            if (l > 0)
            {
                for (int k = 0; k < l; k++)
                {                  
                    remove(lotNum[k]);
                }
            }
            remove(buyHouse);
            remove(removeHouse);
            remove(menu);
            validate();
            repaint();
            Random number = new Random();
            int dice1 = number.nextInt(6)+1;
            int dice2 = number.nextInt(6)+1;
            int diceSum = dice1 + dice2;
            diceRoll.setText("Dice roll is " + diceSum);
            add(diceRoll);
            prevLocation = game.players.get(x).getLocation();
            if (diceSum + prevLocation >= 40)
            {
                game.players.get(x).setLocation(diceSum + prevLocation - 40);
                game.players.get(x).setMoneyAmt(200);
                add(passedGo);
                validate();
            }
            else 
            {
                game.players.get(x).setLocation(diceSum + prevLocation);
            }
            int curLoc = game.players.get(x).getLocation();
            BoardLocation curLocation = game.getBoard().get(curLoc);
            if (curLocation instanceof Lot)
            {
                Lot curLot = (Lot)game.gameBoard.get(curLoc);
                spaceInfo.setText(curLot.toString());
                add(spaceInfo);
                possibleAction.setText(curLot.getPossibleAction(game.players.get(x)));
                add(possibleAction);
                validate();
                if ("Bank".equals(curLot.getOwner()))
                {
                    add(purchase[0]);
                    add(purchase[1]);
                    validate();
                }
                else if (!game.players.get(x).getToken().equalsIgnoreCase(curLot.getOwner()))
                {                    
                    game.players.get(x).setMoneyAmt(-curLot.getRent());
                    if (curLot.getOwner().equals(game.players.get(0).getToken()))                    
                        game.players.get(0).setMoneyAmt(curLot.getRent());
                    else if (curLot.getOwner().equals(game.players.get(1).getToken()))
                        game.players.get(1).setMoneyAmt(curLot.getRent());
                    else if (curLot.getOwner().equals(game.players.get(2).getToken()))
                        game.players.get(2).setMoneyAmt(curLot.getRent());
                    else if (curLot.getOwner().equals(game.players.get(3).getToken()))
                        game.players.get(3).setMoneyAmt(curLot.getRent());
                    for (int k = 0; k < i; k++)
                    {
                        playerInfo[k].setText(game.players.get(k).getToken() + " is on " + game.gameBoard.get(game.players.get(k).getLocation()).getLocName()
                            + " (space " + game.players.get(k).getLocation() + ") " + "Owned Properties are: " + game.players.get(k).getOwnedProps() + 
                            " Amount of money is: $" + game.players.get(k).getMoneyAmt());
                    }
                    /*for (int k = 0; k < i; k++)
                    {                        
                        StringBuilder sb = new StringBuilder();                        
                        for (JLabel info : playerInfo)
                        {
                            sb.append(info.getText()).append("\n");
                        }                        
                        if (game.players.get(k).getMoneyAmt() <= 0)
                        {
                            JOptionPane.showMessageDialog(this, game.players.get(k).getToken() + " has run out of money. Game over\n" + sb.toString());
                            System.exit(0);
                        }
                    }*/
                    if (dice1 == dice2) // This was added after project 1
                    {
                        add(doubles);
                        x--;
                    }
                    if (x == (i-1))
                        x = -1;
                    x++;
                    turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                    add(turn);
                    add(menu);
                }
                else
                {
                    if (dice1 == dice2) // This was added after project 1
                    {
                        add(doubles);
                        x--;
                    }
                    if (x == (i-1))
                        x = -1;
                    x++;
                    turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                    add(turn);
                    add(menu);
                }
            }            
            else if (curLocation instanceof Railroad) // I adjusted this to correctly implement the rent after project 1
            {
                Railroad curRail = (Railroad)game.gameBoard.get(curLoc);
                spaceInfo.setText(curRail.toString());
                add(spaceInfo);
                possibleAction.setText(curRail.getPossibleAction(game.players.get(x)));
                add(possibleAction);
                validate();
                if ("Bank".equals(curRail.getOwner()))
                {
                    add(purchase[0]);
                    add(purchase[1]);
                    validate();
                }
                else if (!game.players.get(x).getToken().equalsIgnoreCase(curRail.getOwner()))
                {
                    game.players.get(x).setMoneyAmt(-curRail.getRailRent());
                    if (curRail.getOwner().equals(game.players.get(0).getToken()))
                    {
                        curRail.setRailRent(game.players.get(0).getNumRailroads());
                        game.players.get(0).setMoneyAmt(curRail.getRailRent());
                    }
                    else if (curRail.getOwner().equals(game.players.get(1).getToken()))
                    {
                        curRail.setRailRent(game.players.get(1).getNumRailroads());
                        game.players.get(1).setMoneyAmt(curRail.getRailRent());
                    }
                    else if (curRail.getOwner().equals(game.players.get(2).getToken()))
                    {
                        curRail.setRailRent(game.players.get(2).getNumRailroads());
                        game.players.get(2).setMoneyAmt(curRail.getRailRent());
                    }
                    else if (curRail.getOwner().equals(game.players.get(3).getToken()))
                    {
                        curRail.setRailRent(game.players.get(3).getNumRailroads());
                        game.players.get(3).setMoneyAmt(curRail.getRailRent());
                    }
                    for (int k = 0; k < i; k++)
                    {
                        playerInfo[k].setText(game.players.get(k).getToken() + " is on " + game.gameBoard.get(game.players.get(k).getLocation()).getLocName()
                            + " (space " + game.players.get(k).getLocation() + ") " + "Owned Properties are: " + game.players.get(k).getOwnedProps() + 
                            " Amount of money is: $" + game.players.get(k).getMoneyAmt());
                    }
                    /*for (int k = 0; k < i; k++)
                    {                        
                        StringBuilder sb = new StringBuilder();
                        for (JLabel info : playerInfo)
                        {
                            sb.append(info.getText()).append("\n");
                        }
                        if (game.players.get(k).getMoneyAmt() <= 0)
                        {
                            JOptionPane.showMessageDialog(this, game.players.get(k).getToken() + " has run out of money. Game over\n" + sb.toString());
                            System.exit(0);
                        }
                    }*/
                    if (dice1 == dice2) // This was added after project 1
                    {
                        add(doubles);
                        x--;
                    }
                    if (x == (i-1))
                        x = -1;
                    x++;
                    turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                    oweRent.setText("You owe $" + curRail.getRailRent() + " for rent.");
                    add(oweRent);
                    add(turn);
                    add(menu);
                }
                else
                {
                    if (dice1 == dice2) // This was added after project 1
                    {
                        add(doubles);
                        x--;
                    }
                    if (x == (i-1))
                        x = -1;
                    x++;
                    turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                    add(turn);
                    add(menu);
                }
            }            
            else if (curLocation instanceof Utility) // I adjusted this to correctly implement the rent after project 1
            {
                Utility curUtil = (Utility)game.gameBoard.get(curLoc);                
                spaceInfo.setText(curUtil.toString());
                add(spaceInfo);
                possibleAction.setText(curUtil.getPossibleAction(game.players.get(x)));
                add(possibleAction);
                validate();
                if ("Bank".equals(curUtil.getOwner()))
                {                    
                    add(purchase[0]);
                    add(purchase[1]);                    
                    validate();
                }
                else if (!game.players.get(x).getToken().equalsIgnoreCase(curUtil.getOwner()))
                {
                    game.players.get(x).setMoneyAmt(-curUtil.getUtilRent());
                    if (curUtil.getOwner().equals(game.players.get(0).getToken()))
                    {
                        curUtil.setUtilRent(game.players.get(0).getNumUtilities(), diceSum);
                        game.players.get(0).setMoneyAmt(curUtil.getUtilRent());
                    }
                    else if (curUtil.getOwner().equals(game.players.get(1).getToken()))
                    {
                        curUtil.setUtilRent(game.players.get(1).getNumUtilities(), diceSum);
                        game.players.get(1).setMoneyAmt(curUtil.getUtilRent());
                    }
                    else if (curUtil.getOwner().equals(game.players.get(2).getToken()))
                    {
                        curUtil.setUtilRent(game.players.get(2).getNumUtilities(), diceSum);
                        game.players.get(2).setMoneyAmt(curUtil.getUtilRent());
                    }
                    else if (curUtil.getOwner().equals(game.players.get(3).getToken()))
                    {
                        curUtil.setUtilRent(game.players.get(3).getNumUtilities(), diceSum);
                        game.players.get(3).setMoneyAmt(curUtil.getUtilRent());
                    }
                    for (int k = 0; k < i; k++)
                    {
                        playerInfo[k].setText(game.players.get(k).getToken() + " is on " + game.gameBoard.get(game.players.get(k).getLocation()).getLocName()
                            + " (space " + game.players.get(k).getLocation() + ") " + "Owned Properties are: " + game.players.get(k).getOwnedProps() + 
                            " Amount of money is: $" + game.players.get(k).getMoneyAmt());
                    }
                    /*for (int k = 0; k < i; k++)
                    {                        
                        StringBuilder sb = new StringBuilder();
                        for (JLabel info : playerInfo)
                        {
                            sb.append(info.getText()).append("\n");
                        }
                        if (game.players.get(k).getMoneyAmt() <= 0)
                        {
                            JOptionPane.showMessageDialog(this, game.players.get(k).getToken() + " has run out of money. Game over\n" + sb.toString());
                            System.exit(0);
                        }
                    }*/
                    if (dice1 == dice2) // This was added after project 1
                    {
                        add(doubles);
                        x--;
                    }
                    if (x == (i-1))
                        x = -1;
                    x++;
                    turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                    oweRent.setText("The dice roll is, " + curUtil.getDiceRoll() + ", and you owe $" + curUtil.getUtilRent() + " for rent.");
                    add(oweRent);
                    add(turn);
                    add(menu);
                    validate();
                }
                else
                {
                    if (dice1 == dice2) // This was added after project 1
                    {
                        add(doubles);
                        x--;
                    }
                    if (x == (i-1))
                        x = -1;
                    x++;
                    turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                    add(turn);
                    add(menu);                    
                }                
            }            
            else if (curLocation instanceof TaxSquare)
            {
                TaxSquare curTax = (TaxSquare)game.gameBoard.get(curLoc);
                spaceInfo.setText(curTax.toString());
                add(spaceInfo);
                possibleAction.setText(curTax.getPossibleAction(game.players.get(x)));
                add(possibleAction);
                game.players.get(x).setMoneyAmt(-curTax.getAmtDue());
                if (dice1 == dice2) // This was added after project 1
                {
                    add(doubles);
                    x--;
                }
                if (x == (i-1))
                    x = -1;            
                x++;
                turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                add(turn);
                add(menu);
                validate();
            }
            else if (curLocation instanceof CardSquare)
            {
                spaceInfo.setText(game.gameBoard.get(curLoc).toString());
                add(spaceInfo);
                possibleAction.setText(game.gameBoard.get(curLoc).getPossibleAction(game.players.get(x)));
                add(possibleAction);
                if (dice1 == dice2) // This was added after project 1
                {
                    add(doubles);
                    x--;
                }
                if (x == (i-1))
                    x = -1;            
                x++;
                turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                add(turn);
                add(menu);
                validate();
            }
            else if (curLocation instanceof CornerSquare)
            {
                CornerSquare curCorner = (CornerSquare)game.gameBoard.get(curLoc);
                spaceInfo.setText(curCorner.toString());
                add(spaceInfo);
                possibleAction.setText(curCorner.getPossibleAction(game.players.get(x)));
                add(possibleAction);
                if (curCorner.toJail)
                {
                    game.players.get(x).setLocation(10);
                }
                if (dice1 == dice2) // This was added after project 1
                {
                    add(doubles);
                    x--;
                }
                if (x == (i-1))
                    x = -1;
                x++;
                turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
                add(turn);
                add(menu);
                validate();
            }
                        
            for(int k = 0; k < i; k++)
            {
                playerInfo[k].setText(game.players.get(k).getToken() + " is on " + game.gameBoard.get(game.players.get(k).getLocation()).getLocName()
                        + " (space " + game.players.get(k).getLocation() + ") " + "Owned Properties are: " + game.players.get(k).getOwnedProps() + 
                        " Amount of money is: $" + game.players.get(k).getMoneyAmt());
            }
            d1 = dice1;
            d2 = dice2;
            validate();
        }
        else if (e.getSource() == menuOptions[2])
        {
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < 40; k++)
            {                
                boardInfo[k].setText(game.gameBoard.get(k).toString());
                sb.append(boardInfo[k].getText()).append("\n");
            }
            JTextArea textArea = new JTextArea(sb.toString());
            jsPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            jsPane.setPreferredSize(new Dimension(600, 600));
            JOptionPane.showMessageDialog(this, jsPane, "Board Information", JOptionPane.INFORMATION_MESSAGE);
            validate();
        }
        else if (e.getSource() == menuOptions[3])
        {
            StringBuilder sb = new StringBuilder();
            for (JLabel info : playerInfo)
            {
                sb.append(info.getText()).append("\n");
            }            
            JOptionPane.showMessageDialog(this, "You have ended the game\n" + sb.toString());
            System.exit(0);
        }        
        repaint();
    }

    @Override
    public void itemStateChanged(ItemEvent ie) 
    {
        if (ie.getSource() == purchase[0] && ie.getStateChange() == ItemEvent.SELECTED)
        {
            int curLoc = game.players.get(x).getLocation();
            BoardLocation curLocation = game.getBoard().get(curLoc);
            if (curLocation instanceof Lot)
            {
                Lot curLot = (Lot)game.gameBoard.get(curLoc);
                game.players.get(x).setMoneyAmt(-curLot.getPurchaseCost());
                game.players.get(x).buyProperty(curLot);
                game.players.get(x).buyLot(curLot);
                curLot.setOwner(game.players.get(x).getToken());
                // Instead of "You have bought..." as from project 1, it displays the particular player that bought it
                purchaseResult.setText(game.players.get(x).getToken() + " has bought " + game.gameBoard.get(curLoc).getLocName()
                    + " For $" + curLot.getPurchaseCost());
                add(purchaseResult);                
            }
            else if (curLocation instanceof Railroad)
            {
                Railroad curRail = (Railroad)game.gameBoard.get(curLoc);
                game.players.get(x).setMoneyAmt(-curRail.getPurchaseCost());
                game.players.get(x).buyProperty(curRail);
                game.players.get(x).buyRailroad();
                curRail.setOwner(game.players.get(x).getToken());
                // Instead of "You have bought..." as from project 1, it displays the particular player that bought it
                purchaseResult.setText(game.players.get(x).getToken() + " has bought " + game.gameBoard.get(curLoc).getLocName()
                    + " For $" + curRail.getPurchaseCost());
                add(purchaseResult);
            }
            else if (curLocation instanceof Utility)
            {
                Utility curUtil = (Utility)game.gameBoard.get(curLoc);
                game.players.get(x).setMoneyAmt(-curUtil.getPurchaseCost());
                game.players.get(x).buyProperty(curUtil);
                game.players.get(x).buyUtility();
                curUtil.setOwner(game.players.get(x).getToken());
                // Instead of "You have bought..." as from project 1, it displays the particular player that bought it
                purchaseResult.setText(game.players.get(x).getToken() + " has bought " + game.gameBoard.get(curLoc).getLocName()
                    + " For $" + curUtil.getPurchaseCost());
                add(purchaseResult);
            }
            if (d1 == d2) // This was added after project 1
            {
                add(doubles);
                x--;
            }
            if (x == (i-1))
                x = -1;            
            x++;
            turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
            buy.clearSelection();
            remove(purchase[0]);
            remove(purchase[1]);
            remove(possibleAction);
            remove(spaceInfo);
            remove(diceRoll);
            add(turn);
            add(menu);
            validate();
            repaint();
        }
        else if (ie.getSource() == purchase[1] && ie.getStateChange() == ItemEvent.SELECTED)
        {
            int curLoc = game.players.get(x).getLocation();
            // Instead of "You have chose to not buy..." as from project 1, it displays the particular player that chose not to buy
            purchaseResult.setText(game.players.get(x).getToken() + " has chosen to not buy " + game.gameBoard.get(curLoc).getLocName() + ". End turn");
            add(purchaseResult);
            if (d1 == d2) // This was added after project 1
            {
                add(doubles);
                x--;
            }
            if (x == (i-1))
                x = -1;
            x++;
            turn.setText("It is " + game.players.get(x).getToken() + "'s turn");
            buy.clearSelection();
            remove(possibleAction);
            remove(purchase[0]);
            remove(purchase[1]);
            remove(spaceInfo);
            remove(diceRoll);
            add(turn);
            add(menu);
            validate();
            repaint();
        }        
        for(int k = 0; k < i; k++)
        {
            playerInfo[k].setText(game.players.get(k).getToken() + " is on " + game.gameBoard.get(game.players.get(k).getLocation()).getLocName()
                    + " (space " + game.players.get(k).getLocation() + ") " + "Owned Properties are: " + game.players.get(k).getOwnedProps() + 
                    " Amount of money is: $" + game.players.get(k).getMoneyAmt());
        }
        
        for(int k = 0; k < l; k++)
        {
            if (ie.getSource() == lotNum[k] && ie.getStateChange() == ItemEvent.SELECTED)
            {
                y = k;
                Lot lot = game.players.get(x).getLots(y);
                lotChosen.setText("You have chosen " + lot.getLocName());
                lotNumGroup.clearSelection();
                for (int z = 0; z < l; z++)
                    remove(lotNum[z]);
                add(lotChosen);
                add(buyHouse);
                add(removeHouse);
                validate();
                break;
            }
        }        
        if (ie.getSource() == buyHouse && ie.getStateChange() == ItemEvent.SELECTED)
        {
            Lot lot = game.players.get(x).getLots(y);
            if (lot.getNumHouses() < 5 && game.players.get(x).getMoneyAmt() > 0)
            {
                lot.addHouse();
                houseResult.setText("1 house has been added.");
                game.players.get(x).setMoneyAmt(-lot.getHouseCost());
            }
            else if (game.players.get(x).getMoneyAmt() <= 0)            
                houseResult.setText("You are out of money and cannot add more houses");            
            else
                houseResult.setText("No more houses can be added.");
            add(houseResult);
            houseOptions.clearSelection();
            remove(buyHouse);
            remove(removeHouse);
            menuOptions[0].setEnabled(true);
            game.setLotRent();
            validate();
        }
        else if (ie.getSource() == removeHouse && ie.getStateChange() == ItemEvent.SELECTED)
        {
            Lot lot = game.players.get(x).getLots(y);
            if (lot.getNumHouses() > 0)
            {
                lot.removeHouse();
                houseResult.setText("1 house has been removed.");
                game.players.get(x).setMoneyAmt(lot.getHouseCost() / 2);
            }
            else
                houseResult.setText("No more houses can be removed.");
            add(houseResult);
            houseOptions.clearSelection();
            remove(buyHouse);
            remove(removeHouse);
            menuOptions[0].setEnabled(true);
            game.setLotRent();
            validate();
        }
        repaint();
    }
}