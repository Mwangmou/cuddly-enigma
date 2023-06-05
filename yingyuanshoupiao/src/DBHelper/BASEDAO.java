package DBHelper;
import java.sql.*;        //���� BASEDAO �����࣬ʹ�� JDBC ������ݱ����ݵĲ�ѯ��ɾ�������.
public class BASEDAO { 
	//���ݿ�����  
	public static Connection getConn() {
		 Connection conn=null;
		 try { 
			 Class.forName("com.mysql.jdbc.Driver");	 //1.����������
			 String url="jdbc:mysql://localhost:3306/tb_movies"; 
			 conn=DriverManager.getConnection(url, "root", "123456");	 //2.��ȡ���Ӷ���
		} catch (Exception e) {
			e.printStackTrace(); 
		} 
		return conn;
	}
	//ִ�в�ѯ ResultSet
	public static ResultSet Query(String sql){
		ResultSet re=null;
		try {
		
			Connection conn=getConn();	//1.�������ݿ� 
			PreparedStatement ps= conn.prepareStatement(sql);	//2.Ԥ����sql���
			re=ps.executeQuery();	//3.ִ��sql��� ���ض�ά���Ľ����
		} catch (Exception e) { 
		}
		return re;
	}
	//ִ����ɾ�����
	public static int Update(String sql){
		int n=-1;
		try { 
			Connection conn=getConn();//1.�������ݿ�
			PreparedStatement ps= conn.prepareStatement(sql);//2.Ԥ����sql���
			n=ps.executeUpdate(); //3.ִ��sql��� ������Ӱ����
			ps.close();		//�ر�Ԥ������ 
			conn.close();//�ر����ݿ�����
		} catch (Exception e) { 
		} 
		return n;
	} 
}
