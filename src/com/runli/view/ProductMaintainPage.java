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

public class ProductMaintainPage extends JFrame implements ActionListener{
	
	JPanel northJPanel, centerJPanel, jp1, jp2, jp3, jp4, jp5, jp6;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	JLabel jl1, jl2;
	
	public ProductMaintainPage() {
		// TODO Auto-generated constructor stub
		
		jl1 = new JLabel(new ImageIcon("image/ProductMaintain.png"));
		northJPanel = new JPanel();
		northJPanel.add(jl1);
		this.add(northJPanel, BorderLayout.NORTH);
		
		jl2 = new JLabel("请选择");
		this.add(jl2, BorderLayout.SOUTH);
		
		jb1 = new JButton("添加商品");
		jb2 = new JButton("更改商品");
		jb3 = new JButton("删除商品");
		jb4 = new JButton("显示所有商品");
		jb5 = new JButton("查询商品");
		jb6 = new JButton("返回首页");
		jb6.setActionCommand("return");
		jb6.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		
		jp1.add(jb1);
		jp2.add(jb2);
		jp3.add(jb3);
		jp4.add(jb4);
		jp5.add(jb5);
		jp6.add(jb6);
		
		centerJPanel = new JPanel();
		centerJPanel.setLayout(new GridLayout(6, 1));
		centerJPanel.add(jp1);
		centerJPanel.add(jp2);
		centerJPanel.add(jp3);
		centerJPanel.add(jp4);
		centerJPanel.add(jp5);
		centerJPanel.add(jp6);
		
		this.add(centerJPanel);
		
		this.setTitle("商品维护");
		this.setSize(400, 350);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("return")) {
			new MainPage();
			this.dispose();
		}
	}
	
	public static void main(String[] args) {
		new ProductMaintainPage();
	}

}
