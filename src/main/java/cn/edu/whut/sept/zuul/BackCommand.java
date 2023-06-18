package cn.edu.whut.sept.zuul;

public class BackCommand extends Command
{
    public boolean execute(Game game)
    {
        Room currentRoom = game.getCurrentRoom();
        if(currentRoom==game.getTemp())
            System.out.println("You are at the entrance,there is no need to go back");
        else
        {
            game.setCurrentRoom(game.getLastRoom());
            System.out.println(game.getLastRoom().getLongDescription());
        }

        return false;
    }
}
