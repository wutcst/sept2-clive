package UI;

public class ItemCommand extends Command
{
    public boolean execute(GameFrame game)
    {
    	String text = "<html>";
    	
    	
        if(game.getCurrentRoom().getItem2()==null)
            //System.out.println("There is no item in this room!");
        	text += "There is no item in this room!<br/>";
        else
        {
            //System.out.println("These are items in this room:");
        	text += "These are items in this room:<br/>";
            for(int i = 0;i<5;i++)
            {
                if(game.getCurrentRoom().getItem02(i)!=null)
                    //System.out.println(game.getCurrentRoom().getItem02(i).getName());
                	text += game.getCurrentRoom().getItem02(i).getName()+"<br/>";
            }
            //System.out.println("Room's totalWeight: "+game.getCurrentRoom().getTotalWeight2());
            text += "Room's totalWeight: "+game.getCurrentRoom().getTotalWeight2()+"<br/><br/>";
        }
        if(game.getPlayer().getItem1()==null)
            //System.out.println("There is no item with the player!");
        	text += "There is no item with the player!<br/>";
        else
        {
            //System.out.println("These are items with the player:");
        	text += "These are items with the player:<br/>";
            for (int i = 0;i<5;i++)
            {
                if (game.getPlayer().getItem01(i) != null)
                    //System.out.println(game.getPlayer().getItem01(i).getName());
            		text += game.getPlayer().getItem01(i).getName()+"<br/>";
            }
            //System.out.println("Player's totalWeight: "+game.getPlayer().getTotalWeight1());
            text += "Player's totalWeight: "+game.getPlayer().getTotalWeight1()+"<br/>";
        }
    	text += "<html/>";
    	game.setLabel(text);

        return false;
    }
}
