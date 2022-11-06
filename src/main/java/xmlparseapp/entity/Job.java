package xmlparseapp.entity;

import java.net.URL;
import java.util.Date;

public class Job {
	private String jobId;
	private String order;
	private String theme;
	private String author;
	private String title;
	private String url;
	private Date publishedDate;
	private String content;
	
	private String[] fields = {
			jobId,
			order,
			theme,
			author,
			title,
			url,
		//	publishedDate,
			content
	};
	
	public Job() {
		super();
	}

	public Job(String jobId, String order, String theme, String author, String title, String url, Date publishedDate,
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

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
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

	@Override
	public String toString() {
		return "Job [id=" + jobId + ", order=" + order + ", theme=" + theme + ", author=" + author + ", title=" + title
				+ ", url=" + url + ", publishedDate=" + publishedDate + ", content=" + content + "]";
	}

	
	
	
}
