package UI;

public class HelpCommand extends Command
{
    private CommandWords commandWords;

    public HelpCommand(CommandWords words)
    {
        commandWords = words;
    }

    public boolean execute(GameFrame game)
    {
        //System.out.println("You are lost. You are alone. You wander");
        //System.out.println("around at the university.");
        //System.out.println();
        //System.out.println("Your command words are:");
        //commandWords.showAll();
    	String text = "<html>";
    	text += "You are lost. You are alone. You wander around at the university.<br/>";
    	text += "<br/>You can try clicking on other buttons.<br/>";
    	text += "<html/>";
    	game.setLabel(text);
        return false;
    }
}
