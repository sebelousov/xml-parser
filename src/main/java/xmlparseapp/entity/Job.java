package xmlparseapp.entity;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Job {
	private int jobId;
	private int order;
	private String theme;
	private String author;
	private String title;
	private String url;
	private Date publishedDate;
	private String content;
	
	public Job() {
		super();
	}

	public Job(int jobId, int order, String theme, String author, String title, String url, Date publishedDate,
			String content) {
		super();
		this.jobId = jobId;
		this.order = order;
		this.author = author;
		this.theme = theme;
		this.title = title;
		this.url = url;
		this.publishedDate = publishedDate;
		this.content = content;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString() {
		return "Job [id=" + jobId + ", order=" + order + ", theme=" + theme + ", author=" + author + ", title=" + title
				+ ", url=" + url + ", publishedDate=" + publishedDate + ", content=" + content + "]";
	}
}
