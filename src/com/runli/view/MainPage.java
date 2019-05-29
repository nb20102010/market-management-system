package com.runli.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPage extends JFrame implements ActionListener {
	
	JPanel northJPanel, centerJPanel, jp1, jp2, jp3, jp4;
	
	JButton jb1, jb2, jb3, jb4;
	
	JLabel jl1, jl2;
	
	public MainPage() {
		// TODO Auto-generated constructor stub
		jb1 = new JButton("商品维护");
		jb1.setActionCommand("productMaintain");
		jb1.addActionListener(this);
		
		jb2 = new JButton("前台收银");
		jb3 = new JButton("柜员管理");
		jb3.setActionCommand("salesmanManage");
		jb3.addActionListener(this);
		
		jb4 = new JButton("退出");
		jb4.setActionCommand("exit");
		jb4.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		
		jl1 = new JLabel("请选择");
		jl2 = new JLabel(new ImageIcon("image/MainTitle.png"));
		
		jp1.add(jb1);
		jp2.add(jb2);
		jp3.add(jb3);
		jp4.add(jb4);
		
		centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(4, 1));
		
		centerJPanel.add(jp1);
		centerJPanel.add(jp2);
		centerJPanel.add(jp3);
		centerJPanel.add(jp4);
		
		northJPanel = new JPanel();
		northJPanel.add(jl2);
		
		
		this.add(centerJPanel);
		this.add(jl1, BorderLayout.SOUTH);
		this.add(northJPanel, BorderLayout.NORTH);
		
		this.setTitle("超市管理系统");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.requestFocus();
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainPage();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("productMaintain")) {
			new GoodMaintainPage();
			this.dispose();
		}
		
		if(e.getActionCommand().equals("salesmanManage")) {
			new SalesmanManagePage();
			this.dispose();
		}
		
		if(e.getActionCommand().equals("exit")) {
			this.dispose();
		}
	}

}
