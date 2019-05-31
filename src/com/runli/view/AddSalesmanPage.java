package com.runli.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.runli.controllers.SalesmanOps;

public class AddSalesmanPage extends JDialog implements ActionListener{

	JPanel northJPanel, centerJPanel, westJPanel, southJPanel;
	JLabel jl1, jl2;
	JTextField jtf1, jtf2;
	JButton jb1, jb2;
	
	public AddSalesmanPage(Frame owner, String title, boolean modal) {
		// TODO Auto-generated constructor stub
		
		super(owner, title, modal);
		
		//north
		northJPanel = new JPanel();
		northJPanel.add(new JLabel(new ImageIcon("image/AddSalesman.png")));
		this.add(northJPanel, BorderLayout.NORTH);
		
		//south
		jb1 = new JButton("添加");
		jb1.setActionCommand("addSalesman");
		jb1.addActionListener(this);
		
		jb2 = new JButton("取消");
		jb2.setActionCommand("cancel");
		jb2.addActionListener(this);
		
		southJPanel = new JPanel();
		southJPanel.add(jb1);
		southJPanel.add(jb2);
		this.add(southJPanel, BorderLayout.SOUTH);
		
		//west
		jl1 = new JLabel("柜员姓名: ");
		jl2 = new JLabel("登陆密码: ");
		
		westJPanel = new JPanel();
		westJPanel.setLayout(new GridLayout(2, 1));
		westJPanel.add(jl1);
		westJPanel.add(jl2);
		this.add(westJPanel, BorderLayout.WEST);
		
		//center
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		
		centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(2, 1));
		centerJPanel.add(jtf1);
		centerJPanel.add(jtf2);
		this.add(centerJPanel);
		
		this.setSize(200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("addSalesman")) {
			String sname = this.jtf1.getText();
			String spassword = this.jtf2.getText();
			
			SalesmanManagePage owner = (SalesmanManagePage)this.getOwner();
			owner.tm = SalesmanOps.addSalesman(sname, spassword, owner.jtf1.getText());
			owner.jt1.setModel(owner.tm);
			this.dispose();
		}
		
		if(e.getActionCommand().equals("cancel")) {
			this.dispose();
		}
	}	
	
}
