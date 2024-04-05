package spms.dao;

import java.util.List;

import spms.vo.Member;
import spms.vo.Project;

/* 데이터 입출력은 단순한 것은 1단계(즉, Controller - Dao)
 * 
 * 로직이 복잡해지면 2단계(Controller - Service - Dao)
 * 
 * Controller는 클라이언트의 통신 정보, 데이터 입출력 전달
 * Service는 다양한 비지니스 로직, 여러 개 테이블 vo에 입출력
 * Dao는 테이블과 보통 1대1 입출력 기능
 */

public interface ProjectDao {
	List<Project> selectList() throws Exception;
	int insert(Project Project) throws Exception;
	int delete(int no) throws Exception;
	Project selectOne(int no) throws Exception;
	int update(Project Project) throws Exception;
}
