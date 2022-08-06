package parser;

import java.net.URL;
import java.util.Date;

public class Job {
	private String title;
	private URL url;
	private Date date;
	private String text;
	
	public Job(String title, URL url, Date date, String text) {
		super();
		this.title = title;
		this.url = url;
		this.date = date;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
