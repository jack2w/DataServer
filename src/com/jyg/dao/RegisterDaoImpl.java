package com.jyg.dao;


import java.sql.SQLException;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.jyg.dataservice.common.DataBean;
import com.jyg.dataservice.common.UserBean;


public class RegisterDaoImpl{

	private static Logger logger = LogManager.getLogger(RegisterDaoImpl.class); 
	
	public void add(UserBean bean) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(bean);
			session.getTransaction().commit();
			if(session.isConnected()){
				session.close();
			}
			logger.debug("����û�" + bean.toString() + "�ɹ���");
		} catch(HibernateException e){
			logger.error("����û�ʧ��", e);
		}

	}

	public boolean delete(DataBean bean) throws NamingException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modify(DataBean bean) throws NamingException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public DataBean query(DataBean bean) throws NamingException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
