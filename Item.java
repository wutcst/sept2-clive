package cn.edu.whut.sept.zuul;

public class Item
{
    private int id;
    private String name;
    private double weight;

    public Item(int i,String s, double w)
    {
        setId(i);
        setName(s);
        setWeight(w);
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return  name;
    }

    public double getWeight()
   {
        return weight;
    }
}
