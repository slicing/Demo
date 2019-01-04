package com.slow.blog.repository;

import com.slow.blog.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlogRepository
 * @author Slicing
 * @date 2019/1/4 8:52
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
	/**
	 * 分页查询博客（去重）
	 * @param title
	 * @param summary
	 * @param content
	 * @return
	 */
	Page<EsBlog> findDistinctByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
