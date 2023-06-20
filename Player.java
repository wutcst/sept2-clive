package main.java.cn.edu.whut.sept.zuul;

public class Player
{
    private Room currentRoom;
    private String name;
    private int id;
    private Item item1[] = new Item[5];
    private double totalWeight1;
    private double weightLimit;
    private int itemNum1;

    public Player(){ Room currentRoom = new Room(null);}

    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setTotalWeight1(double totalWeight1)
    {
        this.totalWeight1 = totalWeight1;
    }

    public void setWeightLimit(double weightLimit)
    {
        this.weightLimit = weightLimit;
    }

    public void setItemNum1(int itemNum1)
    {
        this.itemNum1 = itemNum1;
    }

    public void setItem1(Item[] item1)
    {
        this.item1 = item1;
    }

    public int getId()
    {
        return this.id;
    }

    public int getItemNum1()
    {
        return this.itemNum1;
    }

    public double getTotalWeight1()
    {
        return this.totalWeight1;
    }

    public double getWeightLimit()
    {
        return this.weightLimit;
    }

    public String getName()
    {
        return this.name;
    }

    public Room getCurrentRoom()
    {
        return this.currentRoom;
    }

    public Item[] getItem1()
    {
        return this.item1;
    }

    public Item getItem01(int i) { return this.item1[i]; }

    public void setItem01(int i,Item item) { this.item1[i] = item;}
}
