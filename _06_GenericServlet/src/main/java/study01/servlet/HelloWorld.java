package study01.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Servlet 인터페이스 (서블릿 생태 주기 최상위)
 * GenericServer 추상클래스 implemented Servlet
 * 	- service()만 구현한다.
 * 	- service()로 get/post 모두 전달된다.
 * HttpServlet 추상 클래스 extends GenericServlet
 * 	- doGet()은 get요청 처리
 * 	- doPost()는 post요청 처리
 */

public class HelloWorld extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget()호출");
	}
}
