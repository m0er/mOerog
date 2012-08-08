package com.moerog.module.guestbook;

import java.util.Date;

public class Guestbook {
	private long gbookId;
	private Date gbookDatetime;
	private String gbookContent;
	private String gbookWriter;
	
	public long getGbookId() {
		return gbookId;
	}
	public String getGbookWriter() {
		return gbookWriter;
	}
	public void setGbookWriter(String gbookWriter) {
		this.gbookWriter = gbookWriter;
	}
	public void setGbookId(long gbookId) {
		this.gbookId = gbookId;
	}
	public Date getGbookDatetime() {
		return gbookDatetime;
	}
	public void setGbookDatetime(Date gbookDatetime) {
		this.gbookDatetime = gbookDatetime;
	}
	public String getGbookContent() {
		return gbookContent;
	}
	public void setGbookContent(String gbookContent) {
		this.gbookContent = gbookContent;		
	}
}
