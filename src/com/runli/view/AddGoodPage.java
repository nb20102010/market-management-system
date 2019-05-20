package com.runli.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.runli.controllers.GoodOperations;

public class AddGoodPage extends JDialog implements ActionListener{
	
	JPanel northJPanel, centerJPanel, westJPanel, southJPanel;
	JLabel jl1, jl2, jl3;
	JTextField jtf1, jtf2, jtf3;
	JButton jb1, jb2;
	
	public AddGoodPage(Frame owner, String title, boolean modal) {
		// TODO Auto-generated constructor stub
		
		super(owner, title, modal);
		
		//north
		northJPanel = new JPanel();
		northJPanel.add(new JLabel(new ImageIcon("image/AddProduct.png")));
		this.add(northJPanel, BorderLayout.NORTH);
		
		//south
		jb1 = new JButton("添加");
		jb1.setActionCommand("addGood");
		jb1.addActionListener(this);
		
		jb2 = new JButton("取消");
		jb2.setActionCommand("cancel");
		jb2.addActionListener(this);
		
		southJPanel = new JPanel();
		southJPanel.add(jb1);
		southJPanel.add(jb2);
		this.add(southJPanel, BorderLayout.SOUTH);
		
		//west
		jl1 = new JLabel("商品名称: ");
		jl2 = new JLabel("商品价格: ");
		jl3 = new JLabel("商品数量: ");
		
		westJPanel = new JPanel();
		westJPanel.setLayout(new GridLayout(3, 1));
		westJPanel.add(jl1);
		westJPanel.add(jl2);
		westJPanel.add(jl3);
		this.add(westJPanel, BorderLayout.WEST);
		
		//center
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		
		centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(3, 1));
		centerJPanel.add(jtf1);
		centerJPanel.add(jtf2);
		centerJPanel.add(jtf3);
		this.add(centerJPanel);
		
		this.setSize(200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("addGood")) {
			String gname = this.jtf1.getText();
			Double gprice = Double.parseDouble(this.jtf2.getText());
			Integer gnum = Integer.parseInt(this.jtf3.getText());
			
			GoodMaintainPage owner = (GoodMaintainPage)this.getOwner();
			owner.tm = GoodOperations.addGood(gname, gprice, gnum);
			owner.jt1.setModel(owner.tm);
			this.dispose();
		}
		
		if(e.getActionCommand().equals("cancel")) {
			this.dispose();
		}
	}
	
	
	
}
