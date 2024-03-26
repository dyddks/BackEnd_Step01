package _01_FirstWebProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/calc")
public class CalculatorServlet extends GenericServlet {

//	요청,응답
//	req내에는 calculator.html이 보내는 v1,v2,op의 값이 전달된다.
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String operator= req.getParameter("op");
		int v1 = Integer.parseInt(req.getParameter("v1"));
		int v2 = Integer.parseInt(req.getParameter("v2"));
		int result = 0;
		
		// 한글 깨짐 방지
		// 서블릿이 최초 규격이정해진 시기의 문자셋이 UTF-8이 아니어서
		// 이렇게 정해줘야 html이 보내는 데이터를 UTF-8로 해석해서 깨지지 않는다.
		res.setContentType("text/html;charset=UTF-8");
		
		// 브라우저로 응답을 전송
		PrintWriter out = res.getWriter();
		
		switch(operator) {
		case "+": result = v1+v2; break;
		case "-": result = v1-v2; break;
		case "*": result = v1*v2; break;
		case "/":
			if(v2 == 0) {
				out.println("0으로 나눌수 없습니다.");
				return;
			}
			result = v1/v2;
			break;
		}
		
		out.println(v1+" "+operator+" "+v2+ "=" + result);

	}

}
