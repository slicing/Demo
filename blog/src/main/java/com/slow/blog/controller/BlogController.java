package com.slow.blog.controller;

import com.slow.blog.es.EsBlog;
import com.slow.blog.repository.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Slicing
 * @date 2019/1/4 18:29
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private EsBlogRepository repository;
    public List<EsBlog> list(@RequestParam(value = "title")String title,
                             @RequestParam(value = "summary")String summary,
                             @RequestParam(value = "content")String content,
                             @RequestParam(value = "pageIndex",defaultValue = "0")int pageIndex,
                             @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        Pageable pageable = PageRequest.of(pageSize,pageIndex);
        Page<EsBlog> page = repository.findDistinctByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        return page.getContent();
    }
}
