package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Random ;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class GameFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DBService dbs;
	
    private Parser parser;
    private Room currentRoom;
    private Room nextRoom;
    private Room lastRoom;
    private Room temp;
    private Player player = new Player();
    Random r = new Random();
    private Room[] rooms = new Room[7];
    private Item[] items = new Item[27];

    private void initRooms() {
        // create the rooms
    	rooms[0] = new Room("outside the main entrance of the university");
    	rooms[1] = new Room("in a lecture theater");
    	rooms[2] = new Room("in the campus pub");
    	rooms[3] = new Room("in a computing lab");
    	rooms[4] = new Room("in the computing admin office");
    	rooms[5] = new Room("in the campus canteen");
    	rooms[6] = new Room("in a auditorium");
    }
    
    private void initItems() {
        items[0] = null;
        items[1] = new Item(1,"mask",0.1);
        items[2] = new Item(2,"popcorn",0.5);
        items[3] = new Item(3,"ticket",0.1);
        items[4] = new Item(4,"microphone",1);
        items[5] = new Item(5,"bowl",0.3);
        items[6] = new Item(6,"chopsticks",0.1);
        items[7] = new Item(7,"plate",0.3);
        items[8] = new Item(8,"dustbin",0.3);
        items[9] = new Item(9,"loudspeaker",1);
        items[10] = new Item(10,"note",0.2);
        items[11] = new Item(11,"pen",0.2);
        items[12] = new Item(12,"water",0.5);
        items[13] = new Item(13,"glass",0.5);
        items[14] = new Item(14,"whisky",1.5);
        items[15] = new Item(15,"beer",1);
        items[16] = new Item(16,"soft_drinks",2);
        items[17] = new Item(17,"screen",4);
        items[18] = new Item(18,"mouse",0.5);
        items[19] = new Item(19,"keyboard",1.5);
        items[20] = new Item(20,"disk",0.1);
        items[21] = new Item(21,"PC",7);
        items[22] = new Item(22,"cup",0.3);
        items[23] = new Item(23,"snack",0.5);
        items[24] = new Item(24,"paper",0.1);
        items[25] = new Item(25,"glasses",0.5);
        items[26]= new Item(26,"cellphone",1);
	}
    
	/**
	 * Create the frame.
	 */
	public GameFrame(String name, boolean newGame) {
		super("zuul");
		player.setName(name);
		dbs = new DBService(name);
		initRooms();
		initItems();
        createRooms();
        createPlayer();
        parser = new Parser();
        //System.out.println(dbs.getIsExist());
        //System.out.println(newGame);
		if (dbs.getIsExist() && !newGame)
			setData();
		else if(!newGame)
			JOptionPane.showMessageDialog(null,"查询不到您的游戏记录，开始新游戏","错误提示",JOptionPane.ERROR_MESSAGE);
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("当前房间");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 26));
		lblNewLabel.setBounds(302, 10, 120, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("向北移动");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setBounds(25, 68, 120, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("向南移动");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_1.setBounds(25, 128, 120, 30);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("向东移动");
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_2.setBounds(25, 190, 120, 30);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("向西移动");
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_3.setBounds(25, 252, 120, 30);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("后退");
		btnNewButton_4.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_4.setBounds(25, 310, 120, 30);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("一键后退");
		btnNewButton_5.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_5.setBounds(25, 371, 120, 30);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("帮助");
		btnNewButton_6.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_6.setBounds(562, 68, 120, 30);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("查看");
		btnNewButton_7.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_7.setBounds(562, 128, 120, 30);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("拿起物品");
		btnNewButton_8.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_8.setBounds(562, 190, 120, 30);
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("放下物品");
		btnNewButton_9.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_9.setBounds(562, 252, 120, 30);
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("物品");
		btnNewButton_10.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_10.setBounds(562, 310, 120, 30);
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("魔法饼干");
		btnNewButton_11.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_11.setBounds(562, 371, 120, 30);
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("退出");
		btnNewButton_12.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_12.setBounds(493, 418, 120, 30);
		panel.add(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 显示确认对话框，当选择YES_OPTION时退出系统
				if (JOptionPane.showConfirmDialog(null, "您确定要退出系统吗？", "退出系统",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					// 退出系统
					saveData();
					dbs.saveToDB();
					System.exit(0);
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("输入框：");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(133, 415, 90, 35);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(224, 419, 247, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setBounds(180, 68, 352, 333);
		panel.add(imgLabel);
		this.setVisible(true);
	}

    private void setData() {
		currentRoom = rooms[dbs.getCurrentRoom()];
		lastRoom = rooms[dbs.getCurrentRoom()];
		//setTemp(currentRoom);
		
		for(int i=1; i<7; i++) {
			int[] nums = dbs.getRoom(i-1);
			int n=0;
			double w=0.0;
			for(int j=0; j<5; j++) {
				rooms[i].setItem02(j, items[nums[j]]);
				n += nums[j]!=0? 1:0;
				w += items[nums[j]] != null? items[nums[j]].getWeight():0;
			}
			rooms[i].setCookie(nums[5]==1);
			rooms[i].setItemNum2(n);
			rooms[i].setTotalWeight2(w);
		}
		
		player.setCurrentRoom(currentRoom);
		int[] nums = dbs.getItem();
		int n=0;
		double w=0.0;
		for(int j=0; j<5; j++) {
			player.setItem01(j, items[nums[j]]);
			n += nums[j]!=0? 1:0;
			w += items[nums[j]] != null? items[nums[j]].getWeight():0;
		}
		player.setItemNum1(n);
		player.setTotalWeight1(w);
		player.setWeightLimit(dbs.getWeightLimit());
	}
    
    private void saveData() {
    	for(int i=0; i<7; i++) {
    		if(rooms[i].getShortDescription().equals(currentRoom.getShortDescription()))
    	    	dbs.setCurrentRoom(i);
    		if(rooms[i].getShortDescription().equals(lastRoom.getShortDescription()))
    	    	dbs.setLastRoom(i);
    	}
    	
    	dbs.setWeightLimit(player.getWeightLimit());
    	int[] nums = new int[6];
    	Item[] item_p = player.getItem1();
    	for(int i=0; i<5; i++)
    		nums[i] = item_p[i]==null? 0:item_p[i].getId();
    	nums[5] = 0;
    	dbs.setItem(nums);
    	
    	for(int i=1; i<7; i++) {
    		nums = new int[6];
    		item_p = rooms[i].getItem2();
    		for(int j=0; j<5; j++) {
    			nums[j] = item_p[j]==null? 0:item_p[j].getId();
    		}
    		nums[5] = rooms[i].isCookie()? 1:0;
    		dbs.setRoom(nums, i-1);
    	}
    }

	private void createRooms()
    {
        Room outside, theater, pub, lab, office,canteen,auditorium;

        // create the rooms
        outside = rooms[0];
        theater = rooms[1];
        pub = rooms[2];
        lab = rooms[3];
        office = rooms[4];
        canteen = rooms[5];
        auditorium = rooms[6];

        currentRoom = outside;  // start game outside
        lastRoom = outside;
        setTemp(outside);

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

        theater.setCookie(r.nextInt()%2==1);
        canteen.setCookie(r.nextInt()%2==1);
        auditorium.setCookie(r.nextInt()%2==1);
        pub.setCookie(r.nextInt()%2==1);
        lab.setCookie(r.nextInt()%2==1);
        office.setCookie(r.nextInt()%2==1);

        Item mask = items[1];
        Item popcorn = items[2];
        Item ticket = items[3];
        Item microphone = items[4];
        Item bowl = items[5];
        Item chopsticks = items[6];
        Item plate = items[7];
        Item dustbin = items[8];
        Item loudspeaker = items[9];
        Item note = items[10];
        Item pen = items[11];
        Item water = items[12];
        Item glass = items[13];
        Item whisky = items[14];
        Item beer = items[15];
        Item soft_drinks = items[16];
        Item screen = items[17];
        Item mouse = items[18];
        Item keyboard = items[19];
        Item disk = items[20];
        Item PC = items[21];
        Item cup = items[22];
        Item snack = items[23];
        Item paper = items[24];

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
        player.setItemNum1(2);
        player.setWeightLimit(10);
        player.setTotalWeight1(1.5);
        Item glasses = items[25];
        Item cellphone= items[26];
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
                finished = command.execute(this, textField.getName());
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
        return this.temp;
    }

    public void setTemp(Room temp)
    {
        this.temp = temp;
    }

    public Player getPlayer()
    {
        return player;
    }
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame("", true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
