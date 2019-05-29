package com.runli.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NoSelectedSalesmanWarningPage extends JDialog implements ActionListener{

	JPanel jp1, jp2;
	JLabel jl1;
	JButton jb1;
	
	public NoSelectedSalesmanWarningPage(Frame owner, String title, boolean modal) {
		// TODO Auto-generated constructor stub
		
		super(owner, title, modal);
		
		jl1 = new JLabel("��ѡ��һ����Ա");
		jp1 = new JPanel();
		jp1.add(jl1);
		this.add(jp1);
		
		jb1 = new JButton("ȷ��");
		jb1.setActionCommand("OK");
		jb1.addActionListener(this);
		jp2 = new JPanel();
		jp2.add(jb1);
		this.add(jp2, BorderLayout.SOUTH);
		
		this.setSize(200, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("OK")) {
			this.dispose();
		}
	}
	
}
