package spms.listener;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/* 웹 어플리케이션이 실행되었을때 자동으로 호출되는 클래스
 * ServletContext영역이 준비되었습니다...
 * */

public class ContextLoaderListener implements ServletContextListener{
	
	Connection conn;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext sc = sce.getServletContext();
			
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
	}
}
