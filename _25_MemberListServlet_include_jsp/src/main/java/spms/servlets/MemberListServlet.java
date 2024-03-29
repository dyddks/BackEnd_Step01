package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.vo.Member;

@WebServlet("/member/list")
@SuppressWarnings("serial")
//public class MemberListServlet extends GenericServlet{
public class MemberListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MemberListServlet::doGet() 호출");
		
		Connection conn = null;			// DB 서버와의 연결 객체
		Statement stmt = null;			// sql문
		ResultSet rs = null;			// Select문의 결과
		
		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(
					sc.getInitParameter("url"),	// JDBC url
					sc.getInitParameter("username"),								// id
					sc.getInitParameter("password"));
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT mno, mname, email, cre_date" +
								 " FROM members" +
								 " ORDER BY mno ASC");
			System.out.println(rs);
			/* 회원목록을 list객체로 생성
			 * MemberList.jsp를 호출하면서 list객체를 전달
			 * */
			ArrayList<Member> members = new ArrayList<>();
			while(rs.next()) {
				members.add(new Member()
							.setNo(rs.getInt("mno"))
							.setName(rs.getString("mname"))
							.setEmail(rs.getString("email"))
							.setCreateDate(rs.getDate("cre_date")));
			}
			req.setAttribute("members", members);
			
			// MemberListServlet 객체에서 MemberList.jsp로
			// request객체와 response객체를 전달한다.
			res.setContentType("text/html;charset=UTF-8");
			RequestDispatcher rd = req.getRequestDispatcher("/member/MemberList.jsp");
			rd.include(req, res);
			
	
//			PrintWriter out = res.getWriter();
//			out.println("<html><head><title>회원 목록</title></head>");
//			out.println("<body><h1>회원 목록</h1>");
//			out.println("<p><a href='add'>신규 회원</a></p>");
//			
//			while(rs.next()) {
//				out.println(
//					rs.getInt("MNO") + "," +
//					"<a href='update?no=" + rs.getInt("MNO") + "'>" +
//					rs.getString("MNAME") + "</a>," +
//					rs.getString("EMAIL") + "," + 
//					rs.getDate("CRE_DATE") + 
//					"<a href='delete?no=" + rs.getInt("MNO") + 
//					"'>[삭제]</a><br>");
//			}
//			out.println("</body></html>");
			
		}catch(Exception e) {
			throw new ServletException(e);
		}finally {
			// 생성한 역순으로 닫아준다.
			try {if(rs!=null) rs.close();} catch(Exception e) {}
			try {if(stmt!=null) stmt.close();} catch(Exception e) {}
			try {if(conn!=null) conn.close();} catch(Exception e) {}
		}
	}

}











