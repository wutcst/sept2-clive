package cn.edu.whut.sept.zuul;

import java.util.Set;
import java.util.HashMap;

public class Room
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.


    private int itemNum2;
    private Item item2[] = new Item[5];
    private double totalWeight2;
    private boolean cookie;

    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public void setCookie(boolean cookie)
    {
        this.cookie = cookie;
    }

    public void setItem2(Item[] item2)
    {
        this.item2 = item2;
    }

    public void setTotalWeight2(double totalWeight2)
    {
        this.totalWeight2 = totalWeight2;
    }

    public void setItemNum2(int itemNum2)
    {
        this.itemNum2 = itemNum2;
    }

    public int getItemNum2()
    {
        return itemNum2;
    }

    public double getTotalWeight2()
    {
        return totalWeight2;
    }

    public Item[] getItem2()
    {
        return item2;
    }

    public boolean isCookie()
    {
        return cookie;
    }

    public void setItem02(int i,Item item){ this.item2[i] = item;}

    public Item getItem02(int i) { return item2[i]; }


}


