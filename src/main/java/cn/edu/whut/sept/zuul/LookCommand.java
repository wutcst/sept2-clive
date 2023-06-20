package main.java.cn.edu.whut.sept.zuul;

public class LookCommand extends Command
{
    public boolean execute(GameFrame game)
    {
    	String text = "<html>";
    	text += game.getCurrentRoom().getShortDescription()+"<br/><br/>";
    	text += "Type 'help' if you need help.<br/><br/>";
    	
        //System.out.println(game.getCurrentRoom().getShortDescription());
        if(game.getCurrentRoom().getItem2()==null)
            //System.out.println("There is no item in this room!");
        	text += "There is no item in this room!"+"<br/>";
        else
        {
            //System.out.println("These are items in this room:");
        	text += "These are items in this room:"+"<br/>";
            for(int i=0;i<5;i++)
            {
                if(game.getCurrentRoom().getItem02(i)!=null)
                    //System.out.println(game.getCurrentRoom().getItem02(i).getName()+" weight : "+game.getCurrentRoom().getItem02(i).getWeight());
                	text += game.getCurrentRoom().getItem02(i).getName()+" weight : "+game.getCurrentRoom().getItem02(i).getWeight()+"<br/>";
            }
        }
    	text += "<html/>";
    	game.setLabel(text);
        return false;
    }
}
