/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;
import java.util.Random ;
public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Room nextRoom;
    private Room lastRoom;
    private Room temp;
    private Player player = new Player();
    Random r = new Random();

    public Game()
    {
        createRooms();
        createPlayer();
        parser = new Parser();
    }

    public boolean transform(int i)
    {
        if(i==1)
            return true;
        else
            return false;
    }

    private void createRooms()
    {
        Room outside, theater, pub, lab, office,canteen,auditorium;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        canteen = new Room("in the campus canteen");
        auditorium = new Room("in a auditorium");

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);

        lab.setExit("east", office);
        office.setExit("west", lab);

        office.setExit("north",theater);
        theater.setExit("south",office);

        outside.setExit("north",canteen);
        canteen.setExit("south",outside);

        canteen.setExit("east",auditorium);
        auditorium.setExit("west",canteen);

        theater.setExit("north",auditorium);
        auditorium.setExit("south",theater);

        currentRoom = outside;  // start game outside
        lastRoom = outside;
        setTemp(outside);

        theater.setCookie(transform(r.nextInt()%2));
        canteen.setCookie(transform(r.nextInt()%2));
        auditorium.setCookie(transform(r.nextInt()%2));
        pub.setCookie(transform(r.nextInt()%2));
        lab.setCookie(transform(r.nextInt()%2));
        office.setCookie(transform(r.nextInt()%2));

        Item mask = new Item(1,"mask",0.1);
        Item popcorn = new Item(2,"popcorn",0.5);
        Item ticket = new Item(3,"ticket",0.1);
        Item microphone = new Item(4,"microphone",1);
        Item bowl = new Item(5,"bowl",0.3);
        Item chopsticks = new Item(6,"chopsticks",0.1);
        Item plate = new Item(7,"plate",0.3);
        Item dustbin = new Item(8,"dustbin",0.3);
        Item loudspeaker = new Item(9,"loudspeaker",1);
        Item note = new Item(10,"note",0.2);
        Item pen = new Item(11,"pen",0.2);
        Item water = new Item(12,"water",0.5);
        Item glass = new Item(13,"glass",0.5);
        Item whisky = new Item(14,"whisky",1.5);
        Item beer = new Item(15,"beer",1);
        Item soft_drinks = new Item(16,"soft_drinks",2);
        Item screen = new Item(17,"screen",4);
        Item mouse = new Item(18,"mouse",0.5);
        Item keyboard = new Item(19,"keyboard",1.5);
        Item disk = new Item(20,"disk",0.1);
        Item PC = new Item(21,"PC",7);
        Item cup = new Item(22,"cup",0.3);
        Item snack = new Item(23,"snack",0.5);
        Item paper = new Item(24,"paper",0.1);

        Item item01[] = {mask,popcorn,ticket,microphone,null};
        Item item02[] = {bowl,chopsticks,plate,dustbin,null};
        Item item03[] = {loudspeaker,note,pen,water,null};
        Item item04[] = {glass,whisky,beer,soft_drinks,null};
        Item item05[] = {screen,mouse,keyboard,disk,null};
        Item item06[] = {PC,cup,snack,paper,null};

        outside.setItem2(null);
        theater.setItem2(item01);
        canteen.setItem2(item02);
        auditorium.setItem2(item03);
        pub.setItem2(item04);
        lab.setItem2(item05);
        office.setItem2(item06);

        theater.setItemNum2(4);
        canteen.setItemNum2(4);
        auditorium.setItemNum2(4);
        pub.setItemNum2(4);
        lab.setItemNum2(4);
        office.setItemNum2(4);

        theater.setTotalWeight2(1.7);
        canteen.setTotalWeight2(1);
        auditorium.setTotalWeight2(1.9);
        pub.setTotalWeight2(5);
        lab.setTotalWeight2(6.1);
        office.setTotalWeight2(7.9);

    }

    public void createPlayer()
    {
        player.setCurrentRoom(currentRoom);
        player.setId(1);
        player.setName("mushroom");
        player.setItemNum1(2);
        player.setWeightLimit(10);
        player.setTotalWeight1(1.5);
        Item glasses = new Item(25,"glasses",0.5);
        Item cellphone= new Item(26,"cellphone",1);
        Item item07[] = { glasses,cellphone,null,null,null };
        player.setItem1(item07);
    }


    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            if(command == null) {
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(this);
            }
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }

    public Room getNextRoom() { return  nextRoom; }

    public void setNextRoom(Room room){this.nextRoom=room; }

    public Room getLastRoom() { return  lastRoom; }

    public void setLastRoom(Room room){this.lastRoom=room; }

    public Room getTemp()
    {
        return temp;
    }

    public void setTemp(Room temp)
    {
        this.temp = temp;
    }

    public Player getPlayer()
    {
        return player;
    }
}