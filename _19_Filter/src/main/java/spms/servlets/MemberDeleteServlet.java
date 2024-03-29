package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conn = null;			// DB 서버와의 연결 객체
		PreparedStatement stmt = null;
		
		try {
			// 메모리에 클래스 로딩
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(
					sc.getInitParameter("url"),	// JDBC url
					sc.getInitParameter("username"),								// id
					sc.getInitParameter("password"));							// password
			stmt = conn.prepareStatement("delete from members" + 
											" where mno=?");
			stmt.setInt(1, Integer.parseInt(req.getParameter("no")));
			stmt.executeUpdate();
			
			resp.sendRedirect("list");
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			// 생성한 역순으로 닫아준다.
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
	}
}
