package edu.luc.lakezon.business;

public class Link {
	
	private String action;
	private String url;
	
	public Link() {}
	
	public Link(String action, String url) {
		this.action = action;
		this.url = url;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
