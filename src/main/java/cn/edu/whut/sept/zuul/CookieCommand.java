package UI;

public class CookieCommand extends Command
{
    public boolean execute(GameFrame game)
    {
    	Room currentRoom = game.getCurrentRoom();
        if(currentRoom.isCookie())
        {
        	currentRoom.setCookie(false);
            game.getPlayer().setWeightLimit(game.getPlayer().getWeightLimit()*1.3);
            //System.out.println("Your WeightLimit is up to "+game.getPlayer().getWeightLimit());
            game.raiseInfor("Your WeightLimit is up to "+game.getPlayer().getWeightLimit());
        }
        else
            //System.out.println("There is no magic cookie in this room!");
        	game.raiseError("There is no magic cookie in this room!");
        return false;
    }
}
