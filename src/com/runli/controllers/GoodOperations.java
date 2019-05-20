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
	
	public static TableModel addGood(String gname, Double gprice, Integer gnum) {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		GoodsDao good = new GoodsDao();
		good.setGname(gname);
		good.setGprice(gprice);
		good.setGnum(gnum);
		session.save(good);
		t.commit();
		session.close();
		return selectAll();
	}
	
	public static TableModel delGood(Integer gid) {
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		GoodsDao good = session.load(com.runli.daos.GoodsDao.class, gid);
		session.delete(good);
		t.commit();
		session.close();
		return selectAll();
	}
	
	public static TableModel selectAll(){
		Session session = HibernateUtil.openSession();
		String hql = "select gid, gname, gprice, gnum from com.runli.daos.GoodsDao";
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
