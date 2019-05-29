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

import com.runli.controllers.GoodOps;

public class ModifyGoodPage extends JDialog implements ActionListener{
	
	JPanel northJPanel, centerJPanel, westJPanel, southJPanel;
	JLabel jl1, jl2, jl3, jl4;
	JTextField jtf1, jtf2, jtf3, jtf4;
	JButton jb1, jb2;
	
	public ModifyGoodPage(Frame owner, String title, boolean modal, int row) {
		// TODO Auto-generated constructor stub
		
		super(owner, title, modal);
		
		//north
		northJPanel = new JPanel();
		northJPanel.add(new JLabel(new ImageIcon("image/ModifyGood.png")));
		this.add(northJPanel, BorderLayout.NORTH);
		
		//south
		jb1 = new JButton("确认");
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
		jl1 = new JLabel("商品编号: ");
		jl2 = new JLabel("商品名称: ");
		jl3 = new JLabel("商品价格: ");
		jl4 = new JLabel("商品数量: ");
		
		westJPanel = new JPanel();
		westJPanel.setLayout(new GridLayout(4, 1));
		westJPanel.add(jl1);
		westJPanel.add(jl2);
		westJPanel.add(jl3);
		westJPanel.add(jl4);
		this.add(westJPanel, BorderLayout.WEST);
		
		//center
		
		GoodMaintainPage o = (GoodMaintainPage)owner;
		
		jtf1 = new JTextField((String.valueOf(o.tm.getValueAt(row, 0))));
		jtf1.setEditable(false);
		jtf2 = new JTextField((String) o.tm.getValueAt(row, 1));
		jtf3 = new JTextField((String.valueOf(o.tm.getValueAt(row, 2))));
		jtf4 = new JTextField((String.valueOf(o.tm.getValueAt(row, 3))));
		
		centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(4, 1));
		centerJPanel.add(jtf1);
		centerJPanel.add(jtf2);
		centerJPanel.add(jtf3);
		centerJPanel.add(jtf4);
		this.add(centerJPanel);
		
		this.setSize(200, 240);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("addGood")) {
			Integer gid = Integer.parseInt(this.jtf1.getText());
			String gname = this.jtf2.getText();
			Double gprice = Double.parseDouble(this.jtf3.getText());
			Integer gnum = Integer.parseInt(this.jtf4.getText());
			
			GoodMaintainPage owner = (GoodMaintainPage)this.getOwner();
			owner.tm = GoodOps.modifyGood(gid, gname, gprice, gnum, owner.jtf1.getText());
			owner.jt1.setModel(owner.tm);
			this.dispose();
		}
		
		if(e.getActionCommand().equals("cancel")) {
			this.dispose();
		}
	}
}
