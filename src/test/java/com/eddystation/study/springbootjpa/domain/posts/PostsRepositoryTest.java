package com.eddystation.study.springbootjpa.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith( SpringRunner.class )
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}

	@Test
	public void 게시글_저장_불러오기() {

		String title = "테스트 게시글";
		String content = "테스트 본문";
		String author = "tykim";

		Posts insertPosts = Posts.builder()
				.title( title )
				.content( content )
				.author( author )
				.build();
		postsRepository.save( insertPosts );

		List<Posts> postsList = postsRepository.findAll();
		for( Posts posts : postsList ) {
			assertThat( posts.getTitle() ).isEqualTo( title );
			assertThat( posts.getContent() ).isEqualTo( content );
			assertThat( posts.getAuthor() ).isEqualTo( author );
		}

	}
}
