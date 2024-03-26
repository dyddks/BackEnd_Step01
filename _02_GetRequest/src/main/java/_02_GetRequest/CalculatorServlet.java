package _02_GetRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("calculate")
public class CalculatorServlet extends HttpServlet {
	private Hashtable<String, Operator> operatorTable = new Hashtable<>();
	
	public CalculatorServlet() {
		operatorTable.put("+", new AddOperator());
		operatorTable.put("-", new SubOperator());
		operatorTable.put("*", new MulOperator());
		operatorTable.put("/", new DivOperator());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String op = req.getParameter("op");
		double v1 = Double.parseDouble(req.getParameter("v1"));
		double v2 = Double.parseDouble(req.getParameter("v2"));
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>계산 결과</h1>");
		out.println("결과 : ");
		
		try {
			Operator operator= operatorTable.get(op);
			if(operator == null) {
				out.println("존재하지 않는 연산자입니다.");
			}else {
				double result = operator.execute(v1, v2);
				out.println(String.format("%.3f", result));
			}
			
		} catch(Exception e){
			out.println("오류");
		}
		
		out.println("</body></html>");
	}
}
