package DBHelper;
import java.sql.*;        //创建 BASEDAO 工具类，使用 JDBC 完成数据表数据的查询、删除和添加.
public class BASEDAO { 
	//数据库连接  
	public static Connection getConn() {
		 Connection conn=null;
		 try { 
			 Class.forName("com.mysql.jdbc.Driver");	 //1.加载驱动器
			 String url="jdbc:mysql://localhost:3306/tb_movies"; 
			 conn=DriverManager.getConnection(url, "root", "123456");	 //2.获取连接对象
		} catch (Exception e) {
			e.printStackTrace(); 
		} 
		return conn;
	}
	//执行查询 ResultSet
	public static ResultSet Query(String sql){
		ResultSet re=null;
		try {
		
			Connection conn=getConn();	//1.连接数据库 
			PreparedStatement ps= conn.prepareStatement(sql);	//2.预处理sql语句
			re=ps.executeQuery();	//3.执行sql语句 返回二维表格的结果姐
		} catch (Exception e) { 
		}
		return re;
	}
	//执行增删改语句
	public static int Update(String sql){
		int n=-1;
		try { 
			Connection conn=getConn();//1.连接数据库
			PreparedStatement ps= conn.prepareStatement(sql);//2.预处理sql语句
			n=ps.executeUpdate(); //3.执行sql语句 返回受影响行
			ps.close();		//关闭预处理器 
			conn.close();//关闭数据库连接
		} catch (Exception e) { 
		} 
		return n;
	} 
}
