package spms.vo;

import java.util.Date;

/* 1번째 작업
 * 
 * Projects 테이블을 설계한 후
 * 1개 행의 정보를 입출력 할 수 있도록
 * Project Vo 클래스를 생성하였다.
 * 
 * setter/getter를 생성하였고
 * 필드의 정보를 확인하기 위하여 ToString도 오버라이딩 하였다.
 * 
 * 연속적인 setter초기화 방식을 사용하기 위해
 * 모든 setter의 리턴형을 vo클래스 자료형으로 하였고
 * return this;를 추가하였다.
 * 
 */

public class Project {
	private int no;
	private String title;
	private String content;
	private Date startDate;
	private Date endDate;
	private int state;
	private Date createDate;
	private String tags;
	
	public int getNo() {
		return no;
	}
	public Project setNo(int no) {
		this.no = no;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Project setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Project setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Project setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Project setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	public int getState() {
		return state;
	}
	public Project setState(int state) {
		this.state = state;
		return this;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Project setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public String getTags() {
		return tags;
	}
	public Project setTags(String tags) {
		this.tags = tags;
		return this;
	}
	
	@Override
	public String toString() {
		return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", state=" + state + ", createDate=" + createDate + ", tags=" + tags + "]";
	}
}
