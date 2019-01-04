package com.slow.blog.repository;

import com.slow.blog.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Slicing
 * @date 2019/1/4 8:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

	@Autowired
	private EsBlogRepository repository;

	@Before
	public void initRRepositoryData(){
		//清除所有数据
		repository.deleteAll();
		repository.save(new EsBlog("登鹤雀楼","王之涣的登鹤雀楼","白日依山尽，黄河入海流，欲穷千里目，更上一层楼"));
		repository.save(new EsBlog("相思","王维的相思","红豆生南国，春来发几枝，愿君多采撷，此物最相思"));
		repository.save(new EsBlog("静夜思","李白的静夜思","床前明月光，疑是地上霜，举头望明月，低头思故乡"));
	}

	@Test
	public void findDistinctByTitleContainingOrSummaryContainingOrContentContaining() {
		PageRequest pageable = PageRequest.of(0,20);
		String title = "思";
		String summary = "相思";
		String content = "相思";
		Page<EsBlog> page =  repository.findDistinctByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
		assertThat(page.getTotalElements()).isEqualTo(2);

		System.out.println("------start---");
		for (EsBlog blog : page.getContent()){
			System.out.println(blog.toString());
		}
		System.out.println("-------end---");
	}
}