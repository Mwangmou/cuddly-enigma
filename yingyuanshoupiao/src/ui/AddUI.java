package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import bean.movies;
import dao.moviedao; 

public class AddUI extends JFrame{
	//�����
	JTextField name1txt=new JTextField(10); 
	JTextField name2txt=new JTextField(10); 
	JTextField name3txt=new JTextField(10);
	JTextField name4txt=new JTextField(10);
	JTextField name5txt=new JTextField(10);
	
	public AddUI() {
		super("��ӵ�Ӱ��Ϣ");  
		this.setSize(600, 400); 
		this.setLocationRelativeTo(null);
		//���ÿղ���
		this.setLayout(null);
		
		JLabel name=new JLabel("��ӵ�Ӱ��Ϣ");
		Font font = new Font("����",Font.PLAIN,20);
		name.setFont(font);
		
		JLabel name1=new JLabel("Ƭ����");
		JLabel name2=new JLabel("��Ӱʱ����");
		JLabel name3=new JLabel("������");
		JLabel name4=new JLabel("��ӳʱ�䣺");
		JLabel name5=new JLabel("Ʊ�ۣ�");
		
		//��ť
		JButton btn1=new JButton("���");
		JButton btn2=new JButton("������ҳ");	
		
		//���ô�С��λ��
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
		//��ӵ�������
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();//�ر�
				new MainUI(); 
			}
		});
		//���水ť
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				movies student=new movies(0,name1txt.getText(),name2txt.getText(),name3txt.getText(),Float.parseFloat(name4txt.getText()),name5txt.getText());
				//������ӷ���
				int i=moviedao.insert(student);
				if(i>0) {
					JOptionPane.showMessageDialog(null, "������ӳɹ�");
					dispose();//�ر�
					new MainUI(); 
				}else {
					JOptionPane.showMessageDialog(null, "�������ʧ��");	
				}
			}
		});
	}
}
