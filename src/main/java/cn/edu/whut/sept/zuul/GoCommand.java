package UI;

public class GoCommand extends Command
{
    public boolean execute(GameFrame game)
    {
        //if(!hasSecondWord()) {
        //    System.out.println("Go where?");
        //}
        String direction = getSecondWord();
        Room currentRoom = game.getCurrentRoom();
        Room temp;
        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null)
        {
            //System.out.println("There is no door!");
        	game.raiseError("There is no door!");
        }
        else if(currentRoom!=game.getTemp())
        {
            temp=currentRoom;
            game.setCurrentRoom(nextRoom);
            game.setLastRoom(temp);
            //System.out.println(nextRoom.getLongDescription());
            //game.raiseInfor(nextRoom.getLongDescription());
            game.setLabel(nextRoom.getLongDescription());
        }
        else
        {
            game.setCurrentRoom(nextRoom);
            //System.out.println(nextRoom.getLongDescription());
            //game.raiseInfor(nextRoom.getLongDescription());
            game.setLabel(nextRoom.getLongDescription());
        }

        return false;
    }
}
