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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import com.runli.controllers.GoodOperations;

public class GoodMaintainPage extends JFrame implements ActionListener{
	
	JPanel northJPanel, centerJPanel, eastJPanel, jp1, jp2, jp3, jp4, jp5, jp6;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	JLabel jl1, jl2;
	JTextField jtf1;
	JTable jt1;
	JScrollPane jsp1;
	
	TableModel tm;
	
	public GoodMaintainPage() {
		// TODO Auto-generated constructor stub
		
		//north
		jl1 = new JLabel(new ImageIcon("image/ProductMaintain.png"));
		northJPanel = new JPanel();
		northJPanel.add(jl1);
		this.add(northJPanel, BorderLayout.NORTH);
		
		//south
		jl2 = new JLabel("请选择");
		this.add(jl2, BorderLayout.SOUTH);
		
		//east		
		jb1 = new JButton("添加");
		jb1.setActionCommand("addGood");
		jb1.addActionListener(this);
		
		jb2 = new JButton("更改");
		jb2.setActionCommand("modifyGood");
		jb2.addActionListener(this);
		
		jb3 = new JButton("删除");
		jb3.setActionCommand("delGood");
		jb3.addActionListener(this);
		
		jb4 = new JButton("所有商品");
		jb4.setActionCommand("allGoods");
		jb4.addActionListener(this);
		
		jb6 = new JButton("返回首页");
		jb6.setActionCommand("return");
		jb6.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp6 = new JPanel();
		jp1.add(jb1);
		jp2.add(jb2);
		jp3.add(jb3);
		jp4.add(jb4);
		jp6.add(jb6);
		
		eastJPanel = new JPanel();
		eastJPanel.setLayout(new GridLayout(6, 1));
		eastJPanel.add(jp4);
		eastJPanel.add(jp1);
		eastJPanel.add(jp2);
		eastJPanel.add(jp3);
		eastJPanel.add(new JPanel());
		eastJPanel.add(jp6);
		this.add(eastJPanel, BorderLayout.EAST);
		
		//center
		jtf1 = new JTextField(15);		
		jb5 = new JButton("查询");
		jb5.setActionCommand("query");
		jb5.addActionListener(this);
		
		jp5 = new JPanel();
		jp5.add(jtf1);
		jp5.add(jb5);
		
		tm = GoodOperations.selectAll();
		jt1 = new JTable(tm);
		jsp1 = new JScrollPane(jt1);
		
		centerJPanel = new JPanel();
		centerJPanel.setLayout(new BorderLayout());
		centerJPanel.add(jp5, BorderLayout.NORTH);
		centerJPanel.add(jsp1);
		
		this.add(centerJPanel);
		
		this.setTitle("商品维护");
		this.setSize(400, 350);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("addGood")) {
			new AddGoodPage(this, "添加商品", true);
		}
		
		if(e.getActionCommand().equals("delGood")) {
			int row = this.jt1.getSelectedRow();
			if(row < 0) {
				new NoSelectionWarningPage(this, "警告", true);
			} else {
				Integer gid = (Integer) tm.getValueAt(row, 0);
				tm = GoodOperations.delGood(gid, jtf1.getText());
				jt1.setModel(tm);
			}
		}
		
		if(e.getActionCommand().equals("modifyGood")) {
			int row = this.jt1.getSelectedRow();
			if(row < 0) {
				new NoSelectionWarningPage(this, "警告", true);
			} else {
				new ModifyGoodPage(this, "修改信息", true, row);
			}
		}
		
		if(e.getActionCommand().equals("allGoods")){
			tm = GoodOperations.selectAll();
			jt1.setModel(tm);			
		}
		
		if(e.getActionCommand().equals("query")) {
			String keyword = jtf1.getText();
			tm = GoodOperations.select(keyword);
			jt1.setModel(tm);
		}
		
		if(e.getActionCommand().equals("return")) {
			new MainPage();
			this.dispose();
		}
	}

}
