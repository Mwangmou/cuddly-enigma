package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import bean.movies;
import dao.moviedao; 

public class AddUI extends JFrame{
	//输入框
	JTextField name1txt=new JTextField(10); 
	JTextField name2txt=new JTextField(10); 
	JTextField name3txt=new JTextField(10);
	JTextField name4txt=new JTextField(10);
	JTextField name5txt=new JTextField(10);
	
	public AddUI() {
		super("添加电影信息");  
		this.setSize(600, 400); 
		this.setLocationRelativeTo(null);
		//设置空布局
		this.setLayout(null);
		
		JLabel name=new JLabel("添加电影信息");
		Font font = new Font("宋体",Font.PLAIN,20);
		name.setFont(font);
		
		JLabel name1=new JLabel("片名：");
		JLabel name2=new JLabel("电影时长：");
		JLabel name3=new JLabel("地区：");
		JLabel name4=new JLabel("上映时间：");
		JLabel name5=new JLabel("票价：");
		
		//按钮
		JButton btn1=new JButton("添加");
		JButton btn2=new JButton("返回主页");	
		
		//设置大小和位置
		name.setBounds( 240, 10, 120, 30);
		name1.setBounds(180, 60,  50, 30);
		name2.setBounds(180, 100, 50, 30);
		name3.setBounds(180, 140, 50, 30);
		name4.setBounds(180, 180, 50, 30);
		name5.setBounds(180, 220, 50, 30);
		
		name1txt.setBounds(230,  60, 150, 30);
		name2txt.setBounds(230, 100, 150, 30); 
		name3txt.setBounds(230, 140, 150, 30);
		name4txt.setBounds(230, 180, 150, 30);
		name5txt.setBounds(230, 220, 150, 30);
		
		btn1.setBounds(130,280,140,30);
		btn2.setBounds(300,280,140,30);
		
		add(name);
		add(name1);
		add(name2);
		add(name3);
		add(name4);
		add(name5);
		
		add(name1txt);
		add(name2txt);
		add(name3txt);
		add(name4txt);
		add(name5txt);
		
		add(btn1);
		add(btn2);
		this.setVisible(true);
		//添加到容器中
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();//关闭
				new MainUI(); 
			}
		});
		//保存按钮
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				movies student=new movies(0,name1txt.getText(),name2txt.getText(),name3txt.getText(),Float.parseFloat(name4txt.getText()),name5txt.getText());
				//调用添加方法
				int i=moviedao.insert(student);
				if(i>0) {
					JOptionPane.showMessageDialog(null, "数据添加成功");
					dispose();//关闭
					new MainUI(); 
				}else {
					JOptionPane.showMessageDialog(null, "数据添加失败");	
				}
			}
		});
	}
}
