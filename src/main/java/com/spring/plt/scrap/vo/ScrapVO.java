package com.spring.plt.scrap.vo;

import org.springframework.stereotype.Component;

@Component("scrapVO")
public class ScrapVO {

	private String no;
	private String compid;
	private String expid;
	private String manuid;

	@Override
	public String toString() {
		return "ScrapVO [no=" + no + ", compid=" + compid + ", expid=" + expid + ", manuid=" + manuid + "]";
	}

	public ScrapVO() {
		super();
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public String getExpid() {
		return expid;
	}

	public void setExpid(String expid) {
		this.expid = expid;
	}

	public String getManuid() {
		return manuid;
	}

	public void setManuid(String manuid) {
		this.manuid = manuid;
	}
}
