package cn.edu.whut.sept.zuul;

public class LookCommand extends Command
{
    public boolean execute(Game game)
    {
        System.out.println(game.getCurrentRoom().getShortDescription());
        if(game.getCurrentRoom().getItem2()==null)
            System.out.println("There is no item in this room!");
        else
        {
            System.out.println("These are items in this room:");
            for(int i=0;i<5;i++)
            {
                if(game.getCurrentRoom().getItem02(i)!=null)
                    System.out.println(game.getCurrentRoom().getItem02(i).getName()+" weight : "+game.getCurrentRoom().getItem02(i).getWeight());
            }
        }
        return false;
    }
}
