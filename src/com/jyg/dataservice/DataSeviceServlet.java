package com.jyg.dataservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jyg.dao.DataSourceUtil;
import com.jyg.dao.HibernateUtil;
import com.jyg.dao.RegisterDaoImpl;
import com.jyg.dataservice.common.MsgType;
import com.jyg.dataservice.common.UserBean;

/**
 * Servlet implementation class DataSeviceServlet
 */
@WebServlet("/dataseviceservlet")
public class DataSeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(DataSeviceServlet.class); 
    /**
     * Default constructor. 
     */
    public DataSeviceServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processMessage(request, response);
		RegisterDaoImpl dao = new RegisterDaoImpl();
		UserBean bn = new UserBean();
		bn.setCreatedTime(new Date());
		bn.setPasswd("123456");
		bn.setUsername("jyg");
		dao.add(bn);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processMessage(request, response);
	}
	
	private void processMessage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		try{
			if(request.getParameter("MSGTYPE") == null){
				return;
			}
			int msgType = Integer.parseInt(request.getParameter("MSGTYPE"));
			switch(msgType){
			case MsgType.LOGIN:
				processRegister(request, response);
			}
			
		} catch( NumberFormatException e){
			e.printStackTrace();
		}
			
	}

	//处理注册消息
	private void processRegister(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

}
