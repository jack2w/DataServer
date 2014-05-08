package com.jyg.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static Logger logger = LogManager.getLogger(HibernateUtil.class); 

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
        	logger.error("初始化HibernateSessionFactory失败", ex);
            throw new ExceptionInInitializerError(ex);
        }
        logger.info("初始化HibernateSessionFactory成功");
    }
    
    public static SessionFactory getSessionFactory(){
    	return sessionFactory;
    }

}