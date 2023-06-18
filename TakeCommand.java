package cn.edu.whut.sept.zuul;

import  java.util.Scanner;

public class TakeCommand extends Command
{
    Scanner scanner = new Scanner(System.in);

    public boolean execute(Game game)
    {
        int temp = 0;
        if (game.getCurrentRoom().getItemNum2() == 0)
            System.out.println("There is no items in this room,so you can not take anything");
        else if (game.getPlayer().getItemNum1() == 5)
        {
            System.out.println("You can not take more items with you!");
        }
        else
        {
            System.out.println("These are items in this room:");
            for (int i = 0; i < 5; i++)
            {
                if(game.getCurrentRoom().getItem02(i)!=null)
                    System.out.println(game.getCurrentRoom().getItem02(i).getName());
            }
            System.out.println("Please input the item's name that you want to take: ");
            String selection = scanner.nextLine();
            for (int i = 0; i < 5; i++)
            {
                if(game.getCurrentRoom().getItem02(i)!=null)
                {
                    if (selection.equals(game.getCurrentRoom().getItem02(i).getName()))
                    {
                        temp = i;
                        break;
                    }
                    else
                    {
                        System.out.println("There is no such item in this room");
                    }
                }
            }

            for(int i=0;i<5;i++)
            {
                if(game.getPlayer().getItem01(i)==null)
                {
                    game.getPlayer().setItem01(i, game.getCurrentRoom().getItem02(temp));
                    break;
                }
            }

            game.getCurrentRoom().setTotalWeight2(game.getCurrentRoom().getTotalWeight2()-game.getCurrentRoom().getItem02(temp).getWeight());
            game.getCurrentRoom().setItemNum2(game.getCurrentRoom().getItemNum2()-1);
            game.getPlayer().setTotalWeight1(game.getPlayer().getTotalWeight1()+game.getCurrentRoom().getItem02(temp).getWeight());
            game.getPlayer().setItemNum1(game.getPlayer().getItemNum1()+1);
            game.getCurrentRoom().setItem02(temp, null);

        }
        return false;
    }
}
