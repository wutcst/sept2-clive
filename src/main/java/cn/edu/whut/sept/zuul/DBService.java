package UI;

import java.sql.ResultSet;

public class DBService {
    private String name;
    private int currentRoom;
    private int lastRoom;
    private double weightLimit;
    private String item;
    private String[] rooms = new String[6];
    private boolean isExist;
    
	public DBService(String name) {
		this.name = name;
		this.isExist = exist();
		if(isExist) readFromDB();
	}
	
	private boolean exist() {
		DBUtil db = new DBUtil();
		boolean res = false;
		try {
			db.getConnection();
			String sql = "SELECT name from player where name=?";
			Object[] param = new Object[] { this.name };
			ResultSet rs = db.executeQuery(sql, param);
			if (rs.next()) res = true;
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private void readFromDB() {
		DBUtil db = new DBUtil();
		try {
			db.getConnection();
			String sql = "SELECT * from player where name=?";
			Object[] param = new Object[] { this.name };
			ResultSet rs = db.executeQuery(sql, param);
			if(rs.next()) {
				this.currentRoom = rs.getInt(2);
				this.lastRoom = rs.getInt(3);
				this.weightLimit = rs.getDouble(4);
				this.item = rs.getString(5);
				this.rooms[0] = rs.getString(6);
				this.rooms[1] = rs.getString(7);
				this.rooms[2] = rs.getString(8);
				this.rooms[3] = rs.getString(9);
				this.rooms[4] = rs.getString(10);
				this.rooms[5] = rs.getString(11);
			}
			db.closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean saveToDB(){
		return deleteDB() && insertDB();
	}
	
	private boolean insertDB() {
		boolean res = false;
		DBUtil db = new DBUtil();
		try {
			db.getConnection();
		    // 使用PreparedStatement发送sql语句
			String sql = "INSERT INTO player VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			// 设置参数
			Object[] param = new Object[] { 
					this.name, this.currentRoom, this.lastRoom, this.weightLimit,
					this.item, this.rooms[0], this.rooms[1], this.rooms[2], this.rooms[3], this.rooms[4], this.rooms[5]
					};
			// 判断数据是否保存成功
			if (db.executeUpdate(sql, param) > 0) {
				// 保存成功，设置返回值为true
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库的连接
			db.closeAll();
		}
		return res;
	}

	private boolean deleteDB() {
		if(!isExist) return true;

		boolean res = false;
		DBUtil db = new DBUtil();
		try {
			db.getConnection();
		    // 使用PreparedStatement发送sql语句
			String sql = "delete from player where name=?";
			// 设置参数
			Object[] param = new Object[] { this.name };
			// 判断数据是否删除成功
			if (db.executeUpdate(sql, param) > 0) {
				// 删除成功，设置返回值为true
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库的连接
			db.closeAll();
		}
		return res;
	}

	public boolean getIsExist() {
		return isExist;
	}
	
	public int getCurrentRoom() {
		return this.currentRoom;
	}
	
	public int getLastRoom() {
		return this.lastRoom;
	}
	
	public double getWeightLimit() {
		return this.weightLimit;
	}
	
	public int[] getItem() {
		return str2int(this.item);
	}
	
	public int[] getRoom(int i) {
		return str2int(this.rooms[i]);
	}
	
	
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public void setLastRoom(int lastRoom) {
		this.lastRoom = lastRoom;
	}
	
	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}
	
	public void setItem(int[] num) {
		this.item = int2str(num);
	}
	
	public void setRoom(int[] num, int i) {
		this.rooms[i] = int2str(num);
	}
	
	private int[] str2int(String str) {
		String[] strs = str.split(",");
		int[] res = new int[6];
		for (int i=0; i<6; i++) {
			res[i] = Integer.parseInt(strs[i]);
		}
		return res;
	}
	
	private String int2str(int[] num) {
		String res = ""+num[0];
		for(int i=1; i<6; i++) {
			res += ","+num[i];
		}
		return res;
	}
	
}
