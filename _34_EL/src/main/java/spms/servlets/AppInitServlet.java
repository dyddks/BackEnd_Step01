package spms.servlets;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AppInitServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		/* 데이터베이스 Connection객체를 생성해서 ServeltContext 영역에 저장한다.
		 * 다른 서블릿이 꺼내어 쓸 수 있도록
		 * */
		
		System.out.println("AppInitServlet::init() 호출");
		
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			Connection conn = DriverManager.getConnection(
						sc.getInitParameter("url"),
						sc.getInitParameter("username"),
						sc.getInitParameter("password")
					);
			// ServeltContext 공간에 저장
			sc.setAttribute("conn", conn);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("AppInitServlet::destroy() 호출");
		Connection conn = (Connection)this.getServletContext().getAttribute("conn");
		
		try {
			if(conn != null && conn.isClosed() == false) {
				conn.close();
			}
		}catch(Exception e) {
			
		}
	}
}
