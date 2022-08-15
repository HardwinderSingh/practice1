package dev1.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dev1.cron.CronSdular;
import dev1.dao.LogOutDAO;

public class ListnerClass implements HttpSessionListener,ServletContextListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ListnerClass.sessionCreated()");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sd) {
		HttpSession s = sd.getSession();
		String uid=(String)s.getAttribute("userId");
		//HttpSession t = request.getSession(false);
		//String uid = (String) re.getAttribute("userId");
		LogOutDAO.LogOu(uid);
		System.out.println("User session time out"+uid);
		
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ListnerClass.contextDestroyed()");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ListnerClass.contextInitialized()");
		new CronSdular();
	}

}
