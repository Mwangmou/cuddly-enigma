package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

import bean.movies;
import dao.moviedao; 

public class MainUI extends JFrame{ 
	JTable table;  	//表格
	List<movies>list;  //集合
	//输入框
	//JTextField txtname=new JTextField(10);  
	
	public MainUI() {
		this(null);//调用有参的构造方法
	}
	//构造方法 初始化
	public MainUI(List<movies>li) { 
		super("电影售票系统");
		this.setSize(800, 600); 
		this.setLocationRelativeTo(null);
		JPanel top =new JPanel();
		JLabel labname=new JLabel("电影售票系统");
		Font font = new Font("微软雅黑",Font.PLAIN,20);
		labname.setFont(font);
		//添加组件
		top.add(labname);
		this.add(top, BorderLayout.NORTH);  
		
		JPanel top1 =new JPanel();
		JButton btnAdd=new JButton("添加");
		JButton btnDel=new JButton("删除");
		top1.add(btnAdd);
		top1.add(btnDel);
		this.add(top1,BorderLayout.SOUTH);
		//判断
		if(li==null) {
			list=moviedao.select();
		}
		else {
			list=li;
		} 
		//绘制表格 
		showTable();  
		//添加按钮的单击事件
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//关闭当前窗体
				dispose();
				//显示添加界面
				new AddUI(); 
			}
		});
		
		//按钮的点击事件
		btnDel.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {  
				int index=table.getSelectedRow();
				//如果没选中行
				if(index==-1) {
					JOptionPane.showMessageDialog(null, "请选中一行数据！");
				}else { 
					//消息框 确认是否删除 选择按钮“是” 返回0 选择按钮“否” 返回1 
					int i=JOptionPane.showConfirmDialog(null, "是否确定删除？ ");
					//如果选中的是“是”
					if(i==0) {
						//获取选中行的主键
						int id=list.get(index).getid(); 
						//执行删除
						int j=moviedao.delete(id);
						//判断结果
						if(j>0) { 
							JOptionPane.showMessageDialog(null, "删除成功！");
							dispose();//关闭当前窗体
							new MainUI();//重绘窗体 
						}else {
							JOptionPane.showMessageDialog(null, "删除失败！"); 
						}
					}
				} 
			}
		});
		
		this.setVisible(true);
	}
	private Font Font(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	public void showTable() { 
		//表头
		String[] heads= {"序号","片名","电影时长","地区","上映日期","票价"};
		//表格的数据 二维数组
		Object[][] data=new Object[list.size()][6];
		//遍历集合 把数据存放到数组中
		for (int i = 0; i < data.length; i++) {
			data[i][0]=list.get(i).getid();
			data[i][1]=list.get(i).getname();
			data[i][2]=list.get(i).getarea();
			data[i][3]=list.get(i).getduration();
			data[i][4]=list.get(i).getmoviedate(); 
			data[i][5]=list.get(i).getprice(); 
		}
		//表格绑定数据
		table=new JTable(data,heads); 
		//创建滚动条 水平和垂直
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		//创建滚动面板
		JScrollPane jsp=new JScrollPane(table,v,h); 
		//把面板添加到容器中 位于中部
		this.add(jsp,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new MainUI();
	}
}
