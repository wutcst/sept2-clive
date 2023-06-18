package cn.edu.whut.sept.zuul;

public class CookieCommand extends Command
{
    public boolean execute(Game game)
    {
        if(game.getCurrentRoom().isCookie())
        {
            game.getPlayer().setWeightLimit(game.getPlayer().getWeightLimit()*1.3);
            System.out.println("Your WeightLimit is up to "+game.getPlayer().getWeightLimit());
        }
        else
            System.out.println("There is no magic cookie in this room!");
        return false;
    }
}
