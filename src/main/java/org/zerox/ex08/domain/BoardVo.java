package org.zerox.ex08.domain;

import java.sql.Date;

import lombok.Data;


@Data
public class BoardVo {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
	
	
	
	
	
	
	public BoardVo() {
		
	}
	public BoardVo(int bno, String title, String content, String writer) {
		
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public BoardVo(int bno, String title, String content, String writer, Date regDate, Date updateDate) {
		
		this(bno,title,content,writer);
		this.regDate = regDate;
		this.updateDate = updateDate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	

}
