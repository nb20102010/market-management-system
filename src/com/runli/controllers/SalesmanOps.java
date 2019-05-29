package com.runli.controllers;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.runli.daos.GoodsDao;
import com.runli.daos.SalesmanDao;
import com.runli.util.HibernateUtil;

public class SalesmanOps {

	public static TableModel addSalesman(String sname, String spassword, String keyword) {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		SalesmanDao salesman = new SalesmanDao();
		salesman.setSname(sname);
		salesman.setSpassword(spassword);
		session.save(salesman);
		t.commit();
		session.close();
		return select(keyword);
	}
	
	public static TableModel delSalesman(Integer sid, String keyword) {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		SalesmanDao salesman = session.load(com.runli.daos.SalesmanDao.class, sid);
		session.delete(salesman);
		t.commit();
		session.close();
		return select(keyword);
	}
	
	public static TableModel modifySalesman(Integer sid, String sname, String spassword, String keyword) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		SalesmanDao salesman = session.load(com.runli.daos.SalesmanDao.class, sid);
		salesman.setSname(sname);
		salesman.setSpassword(spassword);
		session.update(salesman);
		t.commit();
		session.close();
		return select(keyword);
	}
	
	public static TableModel selectAll(){
		return select("");
	}
	
	public static TableModel select(String keyword) {
		Session session = HibernateUtil.openSession();
		String hql = "";
		if(keyword.equals("")) {
			hql = "select sid, sname, spassword from com.runli.daos.SalesmanDao";
		} else {
			hql = "select sid, sname, spassword from com.runli.daos.SalesmanDao where sname like '%" + keyword + "%'";
		}
		Query query = session.createQuery(hql);
		List result = query.getResultList();
		Object[][] data = new Object[result.size()][];
		for(int i = 0; i < result.size(); i++) {
			data[i] = (Object[])(result.get(i));
		}
		session.close();
		return new DefaultTableModel(data, new String[] {"ID", "ÐÕÃû", "ÃÜÂë"});
	}
	
}
