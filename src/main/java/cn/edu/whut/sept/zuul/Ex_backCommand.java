package UI;

public class Ex_backCommand extends Command
{
    public boolean execute(GameFrame game)
    {
        Room currentRoom = game.getCurrentRoom();
        if(currentRoom== game.getTemp())
            //System.out.println("You are at the entrance,there is no need to go back");
        	game.raiseError("You are at the entrance, there is no need to go back");
        else
        {
            game.setCurrentRoom(game.getTemp());
            game.setLabel(game.getCurrentRoom().getLongDescription());
            //System.out.println(game.getTemp().getLongDescription());
        }
        return false;
    }
}
