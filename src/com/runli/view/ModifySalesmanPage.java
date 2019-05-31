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

public class ModifySalesmanPage extends JDialog implements ActionListener{

	JPanel northJPanel, centerJPanel, westJPanel, southJPanel;
	JLabel jl1, jl2, jl3;
	JTextField jtf1, jtf2, jtf3;
	JButton jb1, jb2;
	
	public ModifySalesmanPage(Frame owner, String title, boolean modal, int row) {
		// TODO Auto-generated constructor stub
		
		super(owner, title, modal);
		
		//north
		northJPanel = new JPanel();
		northJPanel.add(new JLabel(new ImageIcon("image/ModifySalesman.png")));
		this.add(northJPanel, BorderLayout.NORTH);
		
		//south
		jb1 = new JButton("确认");
		jb1.setActionCommand("modifySalesman");
		jb1.addActionListener(this);
		
		jb2 = new JButton("取消");
		jb2.setActionCommand("cancel");
		jb2.addActionListener(this);
		
		southJPanel = new JPanel();
		southJPanel.add(jb1);
		southJPanel.add(jb2);
		this.add(southJPanel, BorderLayout.SOUTH);
		
		//west
		jl1 = new JLabel("柜员编号: ");
		jl2 = new JLabel("柜员姓名: ");
		jl3 = new JLabel("登录密码: ");
		
		westJPanel = new JPanel();
		westJPanel.setLayout(new GridLayout(3, 1));
		westJPanel.add(jl1);
		westJPanel.add(jl2);
		westJPanel.add(jl3);
		this.add(westJPanel, BorderLayout.WEST);
		
		//center
		
		SalesmanManagePage o = (SalesmanManagePage)owner;
		
		jtf1 = new JTextField((String.valueOf(o.tm.getValueAt(row, 0))));
		jtf1.setEditable(false);
		jtf2 = new JTextField((String) o.tm.getValueAt(row, 1));
		jtf3 = new JTextField((String.valueOf(o.tm.getValueAt(row, 2))));
		
		centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(4, 1));
		centerJPanel.add(jtf1);
		centerJPanel.add(jtf2);
		centerJPanel.add(jtf3);
		this.add(centerJPanel);
		
		this.setSize(200, 220);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("modifySalesman")) {
			Integer sid = Integer.parseInt(this.jtf1.getText());
			String sname = this.jtf2.getText();
			String spassword = this.jtf3.getText();
			
			SalesmanManagePage owner = (SalesmanManagePage)this.getOwner();
			owner.tm = SalesmanOps.modifySalesman(sid, sname, spassword, owner.jtf1.getText());
			owner.jt1.setModel(owner.tm);
			this.dispose();
		}
		
		if(e.getActionCommand().equals("cancel")) {
			this.dispose();
		}
	}
	
}
