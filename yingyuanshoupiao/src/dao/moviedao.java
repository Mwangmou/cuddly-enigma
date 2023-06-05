package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import DBHelper.BASEDAO;
import DBHelper.BASEDAO;
import bean.movies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据操作类 封装sql的操作执行
public class moviedao {
	//添加数据
	public static int insert(movies m) {
		String sql="insert into tb_movies values(null,'%s','%s','%s',%f,'%s')";
		sql=String.format(sql,m.getname(),m.getduration(),m.getarea(),m.getmoviedate(),m.getprice()); 
		return BASEDAO.Update(sql); 
	}
	//根据主键删除数据
	public static int delete(int id) {
		String sql = "delete from tb_movies where id =" +  id;
		return BASEDAO.Update(sql);
	}
	//查询所有数据
	public static List<movies> select() {
		//初始化    
		String sql="select * from tb_movies"; 
		List<movies>list =new ArrayList<movies>();
		try {  
			ResultSet re =BASEDAO.Query(sql);
		    while(re.next()) {
		    	movies s=new movies();
				s.setid(re.getInt(1));
				s.setname(re.getString(2));
				s.setduration(re.getString(3));
				s.setarea(re.getString(4)); 
				s.setmoviedate(re.getFloat(5)); 
				s.setprice(re.getString(6));
				list.add(s);
			}  
		    re.close(); 
		} 
		catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return list;
	}
}
