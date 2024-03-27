package study01.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/* GenericServlet은 1개의 추상메소드를 가진 추상 클래스이다.
 * servlet 인터페이스 상속시켜중 나머지 메서드는 default로 구현되어 있고
 * 반드시 서비스에 필요한 service만 개발자가 구현하도록 한다.
 */

public class HelloWorld extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() 호출");
		
	}

}
