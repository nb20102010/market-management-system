package com.runli.controllers;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.runli.daos.GoodsDao;
import com.runli.util.HibernateUtil;

public class GoodOperations {
	
	public static TableModel addGood(String gname, Double gprice, Integer gnum, String keyword) {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		GoodsDao good = new GoodsDao();
		good.setGname(gname);
		good.setGprice(gprice);
		good.setGnum(gnum);
		session.save(good);
		t.commit();
		session.close();
		return select(keyword);
	}
	
	public static TableModel delGood(Integer gid, String keyword) {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		GoodsDao good = session.load(com.runli.daos.GoodsDao.class, gid);
		session.delete(good);
		t.commit();
		session.close();
		return select(keyword);
	}
	
	public static TableModel modifyGood(Integer gid, String gname, Double gprice, Integer gnum, String keyword) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		GoodsDao good = session.load(com.runli.daos.GoodsDao.class, gid);
		good.setGname(gname);
		good.setGprice(gprice);
		good.setGnum(gnum);
		session.update(good);
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
			hql = "select gid, gname, gprice, gnum from com.runli.daos.GoodsDao";
		} else {
			hql = "select gid, gname, gprice, gnum from com.runli.daos.GoodsDao where gname like '%" + keyword + "%'";
		}
		Query query = session.createQuery(hql);
		List result = query.getResultList();
		Object[][] data = new Object[result.size()][];
		for(int i = 0; i < result.size(); i++) {
			data[i] = (Object[])(result.get(i));
		}
		session.close();
		return new DefaultTableModel(data, new String[] {"ID", "商品名称", "商品价格", "商品数量"});
	}	
	
}
