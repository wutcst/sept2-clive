package UI;

import  java.util.Scanner;

public class TakeCommand extends Command
{
    Scanner scanner = new Scanner(System.in);

    public boolean execute(GameFrame game)
    {
    	String text = "<html>";
    	
        int temp = -1;
        if (game.getCurrentRoom().getItemNum2() == 0) {
            //System.out.println("There is no items in this room,so you can not take anything");
        	game.raiseError("There is no items in this room,so you can not take anything");
        	return false;
        }
        else if (game.getPlayer().getItemNum1() == 5) {
            //System.out.println("You can not take more items with you!");
        	game.raiseError("You can not take more items with you!");
        	return false;
        }
        else {
            //System.out.println("These are items in this room:");
        	text += "These are items in this room:<br/>";
            for (int i = 0; i < 5; i++)
            {
                if(game.getCurrentRoom().getItem02(i)!=null)
                    //System.out.println(game.getCurrentRoom().getItem02(i).getName());
                	text += game.getCurrentRoom().getItem02(i).getName()+"<br/>";
            }
            //System.out.println("Please input the item's name that you want to take: ");
            //String selection = scanner.nextLine();
            for (int i = 0; i < 5; i++)
            {
                if(game.getCurrentRoom().getItem02(i)!=null)
                {
                    if (game.getText().equals(game.getCurrentRoom().getItem02(i).getName()))
                    {
                        temp = i;
                        break;
                    }
                }
            }
            if(temp==-1)   //没有对应物品
            {
            	//System.out.println("There is no such item in this room");
            	game.raiseError("There is no such item in this room");
            	//return false;
            }
            else
            {
	            double Weight_item = game.getCurrentRoom().getItem02(temp).getWeight();
	            double Weight_player = game.getPlayer().getTotalWeight1();
	            if (game.getPlayer().getWeightLimit() >= Weight_item+Weight_player) {   //未超重
		            for(int i=0;i<5;i++)
		            {
		                if(game.getPlayer().getItem01(i)==null)
		                {
		                    game.getPlayer().setItem01(i, game.getCurrentRoom().getItem02(temp));
		                    break;
		                }
		            }
		            game.getCurrentRoom().setTotalWeight2(game.getCurrentRoom().getTotalWeight2() - Weight_item);
		            game.getCurrentRoom().setItemNum2(game.getCurrentRoom().getItemNum2()-1);
		            game.getPlayer().setTotalWeight1(Weight_player + Weight_item);
		            game.getPlayer().setItemNum1(game.getPlayer().getItemNum1()+1);
		            game.getCurrentRoom().setItem02(temp, null);
		            game.raiseInfor("成功拿起！");
	            }
	            else {    //超重
	            	//System.out.println("You can not take more items with you!");
	            	game.raiseError("You can not take more items with you!");
	            }
            }
        }
        text += "<html/>";
        game.setLabel(text);
        return false;
    }
}
