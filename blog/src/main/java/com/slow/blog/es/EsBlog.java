package com.slow.blog.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * EsBlog文档
 * @author Slicing
 * @date 2019/1/4 8:39
 */
@Document(indexName = "blog",type = "blog")
@Data
public class EsBlog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String title;
	private String summary;
	private String content;

	protected EsBlog() {
	}

	public EsBlog(String title, String summary, String content) {
		this.title = title;
		this.summary = summary;
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("EsBlog[id='%s',title='%s',summary='%s'," +
				"content='%s']",id,title,summary,content);
	}
}
