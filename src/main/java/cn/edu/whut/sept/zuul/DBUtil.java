package main.java.cn.edu.whut.sept.zuul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 得到数据库连接
	 */	
	public Connection getConnection() throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException {
		// 通过Config获取MySQL数据库配置信息
		String driver = Config.getValue("driver");
		String url = Config.getValue("url");
		String user = Config.getValue("user");
		String pwd = Config.getValue("password");
		try {
			// 指定驱动程序
			Class.forName(driver);
			// 建立数据库连结
			this.conn = DriverManager.getConnection(url, user, pwd);
			return this.conn;
		} catch (Exception e) {
			// 如果连接过程出现异常，抛出异常信息
			throw new SQLException("驱动错误或连接失败！");
		}
	}

	/**
	 * 释放资源
	 */
	public void closeAll() {
		// 如果rs不空，关闭rs
		if (this.rs != null) {
			try {
				this.rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 如果pstmt不空，关闭pstmt
		if (this.pstmt != null) {
			try {
				this.pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 如果conn不空，关闭conn
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行SQL语句，可以进行查询
	 */
	public ResultSet executeQuery(String preparedSql, Object[] param) {
		// 处理SQL,执行SQL
		try {
			// 得到PreparedStatement对象
			this.pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					// 为预编译sql设置参数
					this.pstmt.setObject(i + 1, param[i]);
				}
			}
			// 执行SQL语句
			this.rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// 处理SQLException异常
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
	 */
	public int executeUpdate(String preparedSql, Object[] param) {
		int num = 0;
		// 处理SQL,执行SQL
		try {
			// 得到PreparedStatement对象
			this.pstmt = this.conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					// 为预编译sql设置参数
					this.pstmt.setObject(i + 1, param[i]);
				}
			}
			// 执行SQL语句
			num = this.pstmt.executeUpdate();
		} catch (SQLException e) {
			// 处理SQLException异常
			e.printStackTrace();
		}
		return num;
	}
}
