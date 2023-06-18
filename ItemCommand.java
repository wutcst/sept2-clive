package cn.edu.whut.sept.zuul;

public class ItemCommand extends Command
{
    public boolean execute(Game game)
    {
        if(game.getCurrentRoom().getItem2()==null)
            System.out.println("There is no item in this room!");
        else
        {
            System.out.println("These are items in this room:");
            for(int i = 0;i<5;i++)
            {
                if(game.getCurrentRoom().getItem02(i)!=null)
                    System.out.println(game.getCurrentRoom().getItem02(i).getName());
            }
            System.out.println("Room's totalWeight: "+game.getCurrentRoom().getTotalWeight2());
        }
        if(game.getPlayer().getItem1()==null)
            System.out.println("There is no item with the player!");
        else
        {
            System.out.println("These are items with the player:");
            for (int i = 0;i<5;i++)
            {
                if (game.getPlayer().getItem01(i) != null)
                    System.out.println(game.getPlayer().getItem01(i).getName());
            }
            System.out.println("Player's totalWeight: "+game.getPlayer().getTotalWeight1());
        }

        return false;
    }
}
