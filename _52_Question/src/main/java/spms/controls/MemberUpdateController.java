package spms.controls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/update")
@SuppressWarnings("serial")
public class MemberUpdateController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if(model.get("member") == null) {			// get 요청
			System.out.println("MemberUpdateController::execute() - get 요청");
			
			return "/member/MemberUpdateForm.jsp";
			
		}else {										// post 요청
			System.out.println("MemberUpdateController::execute() - post 요청");
			
			MemberDao memberDao = (MemberDao)model.get("memberDao");
			Member member = (Member)model.get("member");
			memberDao.update(member);
			
			return "redirect:list.do";
		}
	}
}
