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
	JTable table;  	//���
	List<movies>list;  //����
	//�����
	//JTextField txtname=new JTextField(10);  
	
	public MainUI() {
		this(null);//�����вεĹ��췽��
	}
	//���췽�� ��ʼ��
	public MainUI(List<movies>li) { 
		super("��Ӱ��Ʊϵͳ");
		this.setSize(800, 600); 
		this.setLocationRelativeTo(null);
		JPanel top =new JPanel();
		JLabel labname=new JLabel("��Ӱ��Ʊϵͳ");
		Font font = new Font("΢���ź�",Font.PLAIN,20);
		labname.setFont(font);
		//������
		top.add(labname);
		this.add(top, BorderLayout.NORTH);  
		
		JPanel top1 =new JPanel();
		JButton btnAdd=new JButton("���");
		JButton btnDel=new JButton("ɾ��");
		top1.add(btnAdd);
		top1.add(btnDel);
		this.add(top1,BorderLayout.SOUTH);
		//�ж�
		if(li==null) {
			list=moviedao.select();
		}
		else {
			list=li;
		} 
		//���Ʊ�� 
		showTable();  
		//��Ӱ�ť�ĵ����¼�
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//�رյ�ǰ����
				dispose();
				//��ʾ��ӽ���
				new AddUI(); 
			}
		});
		
		//��ť�ĵ���¼�
		btnDel.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {  
				int index=table.getSelectedRow();
				//���ûѡ����
				if(index==-1) {
					JOptionPane.showMessageDialog(null, "��ѡ��һ�����ݣ�");
				}else { 
					//��Ϣ�� ȷ���Ƿ�ɾ�� ѡ��ť���ǡ� ����0 ѡ��ť���� ����1 
					int i=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��ɾ���� ");
					//���ѡ�е��ǡ��ǡ�
					if(i==0) {
						//��ȡѡ���е�����
						int id=list.get(index).getid(); 
						//ִ��ɾ��
						int j=moviedao.delete(id);
						//�жϽ��
						if(j>0) { 
							JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
							dispose();//�رյ�ǰ����
							new MainUI();//�ػ洰�� 
						}else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�"); 
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
		//��ͷ
		String[] heads= {"���","Ƭ��","��Ӱʱ��","����","��ӳ����","Ʊ��"};
		//�������� ��ά����
		Object[][] data=new Object[list.size()][6];
		//�������� �����ݴ�ŵ�������
		for (int i = 0; i < data.length; i++) {
			data[i][0]=list.get(i).getid();
			data[i][1]=list.get(i).getname();
			data[i][2]=list.get(i).getarea();
			data[i][3]=list.get(i).getduration();
			data[i][4]=list.get(i).getmoviedate(); 
			data[i][5]=list.get(i).getprice(); 
		}
		//��������
		table=new JTable(data,heads); 
		//���������� ˮƽ�ʹ�ֱ
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		//�����������
		JScrollPane jsp=new JScrollPane(table,v,h); 
		//�������ӵ������� λ���в�
		this.add(jsp,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new MainUI();
	}
}
