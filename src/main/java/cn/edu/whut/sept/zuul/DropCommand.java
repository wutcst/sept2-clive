package cn.edu.whut.sept.zuul;

import java.util.Scanner;

public class DropCommand extends Command
{
    Scanner scanner = new Scanner(System.in);

    public boolean execute(Game game)
    {
        int temp = 0;
        if(game.getPlayer().getItemNum1()==0)
            System.out.println("There is no item with you,so you can not drop anything!");
        else if(game.getCurrentRoom().getItemNum2()==5)
            System.out.println("This room is full,you can not put any more items here!");
        else
        {
            System.out.println("These are items with you:");
            for (int i = 0; i < 5; i++)
            {
                if(game.getPlayer().getItem01(i)!=null)
                    System.out.println(game.getPlayer().getItem01(i).getName());
            }
            System.out.println("Please input the item's name that you want to take: ");
            String selection = scanner.nextLine();
            for (int i = 0; i < 5; i++)
            {
                if(game.getPlayer().getItem01(i)!=null)
                {
                    if (selection.equals(game.getPlayer().getItem01(i).getName()))
                    {
                        temp = i;
                        break;
                    }
                    else
                    {
                        System.out.println("There is no such item with you");
                    }
                }
            }

            for(int i=0;i<5;i++)
            {
                if(game.getCurrentRoom().getItem02(i)==null)
                {
                    game.getCurrentRoom().setItem02(i, game.getPlayer().getItem01(temp));
                    break;
                }
            }

            game.getCurrentRoom().setTotalWeight2(game.getCurrentRoom().getTotalWeight2()+game.getPlayer().getItem01(temp).getWeight());
            game.getCurrentRoom().setItemNum2(game.getCurrentRoom().getItemNum2()+1);
            game.getPlayer().setTotalWeight1(game.getPlayer().getTotalWeight1()-game.getPlayer().getItem01(temp).getWeight());
            game.getPlayer().setItemNum1(game.getPlayer().getItemNum1()-1);
            game.getPlayer().setItem01(temp, null);


        }
        return false;
    }
}
