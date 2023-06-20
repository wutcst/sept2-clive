package main.java.cn.edu.whut.sept.zuul;

public class QuitCommand extends Command
{
    public boolean execute(GameFrame game)
    {
        if(hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
