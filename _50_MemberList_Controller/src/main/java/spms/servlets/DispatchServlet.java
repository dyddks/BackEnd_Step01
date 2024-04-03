package spms.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.controlls.Controller;
import spms.controlls.MemberListController;
import spms.vo.Member;

/* DispatchServlet은 Spring에서 사용하는 DesignPattren을 사용한 클래스 명칭이다.
 * 이 역할은 *.do로 들어오는 모든 주소를 일단 받아서 분기시켜주는 역할이다.
 * 이 서블릿을 설계상에서 FrontController라고 부른다.
 * */

@WebServlet("*.do")
public class DispatchServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		// 요청 주소를 얻는다. 이 주소에 따라 Page Controller를 찾아서 분기처리한다.
		String servletPath = req.getServletPath();
		System.out.println("DispatchServlet::service() - servletPath = " + servletPath);
		
		// Page Controller한테 전달할 Map객체를 준비한다.
		Map<String, Object> model = new ConcurrentHashMap<>();
		model.put("memberDao", this.getServletContext().getAttribute("memberDao"));
		model.put("session", req.getSession());
		
		Controller pageController = null;
		
		try {
			String pageControllerPath = null;
			
			if("/member/list.do".equals(servletPath)) {
				// 기존에 Servlet을 호출하던 구조에서 일반 Java객체를 호출하는 방식으로 변경
//				pageControllerPath = "/member/list";
				pageController=  new MemberListController();
			}else if("/member/add.do".equals(servletPath)) {
				pageControllerPath = "/member/add";
				if(req.getParameter("email") != null) {
					req.setAttribute("member", new Member()
							.setEmail(req.getParameter("email"))
							
							.setPassword(req.getParameter("password"))
							.setName(req.getParameter("name")));
				}
			}else if("/member/update.do".equals(servletPath)) {
				pageControllerPath = "/member/update";
				if(req.getParameter("email") != null) {
					req.setAttribute("member", new Member()
							.setEmail(req.getParameter("email"))
							.setNo(Integer.parseInt(req.getParameter("no")))
							.setName(req.getParameter("name")));
				}
			}else if("/member/delete.do".equals(servletPath)) {
				pageControllerPath = "/member/delete";
			}else if("/member/login.do".equals(servletPath)) {
				pageControllerPath = "/auth/login";
			}else if("/member/logout.do".equals(servletPath)) {
				pageControllerPath = "/auth/logout";
			}
			
			String viewUrl = null;
			if(pageController != null) {
				viewUrl = pageController.execute(model);
				
				for(String key: model.keySet()) {
					req.setAttribute(key, model.get(key));
				}
			}else {
				RequestDispatcher rd = req.getRequestDispatcher(pageControllerPath);
				rd.include(req, resp);
			}
			
			RequestDispatcher rd = req.getRequestDispatcher(pageControllerPath);
			rd.include(req, resp);
			
			// pageControllerPath가 지정해준 viewUrl값을 꺼내서 화면 생성을 맡긴다.
			viewUrl = (String)req.getAttribute("viewUrl");
			if(viewUrl.startsWith("redirect:")) {
				// viewUrl에서 'redirect:' 글자를제외한 나머지 url을 추출해서
				// 브라우저에 redirect 요청을 보낸다.
				// 브라우저는 redirect 요청을 받으면 해당 url로 새롭게 다시 접속한다.
				resp.sendRedirect(viewUrl.substring("redirect:".length()));
				return;
			}else {
				// 만약 'redirect:'로 시작되는 viewUrl이 아니면 내부 jsp이동으로 판단한다.
				rd = req.getRequestDispatcher(viewUrl);
				rd.include(req, resp);
			}
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e);
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req, resp);
		}
	}
}
