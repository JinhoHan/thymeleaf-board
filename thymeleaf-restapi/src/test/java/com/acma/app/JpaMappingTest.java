package com.acma.app;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acma.app.domain.Board;
import com.acma.app.repository.BoardRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
	
	private final String title = "테스트";
	private final String content = "내용";
	private Long idx;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Before
	public void init() {
		Board board = boardRepository.save(Board.builder()
				.title(title)
				.content(content)
				.createdDate(LocalDateTime.now())
				.updatedDate(LocalDateTime.now())
				.build());
		idx = board.getIdx();
	}
	
	@Test
	public void mappingTest4JPA() {
		Board board = boardRepository.getOne(idx);
		assertThat(board.getTitle(), is("테스트"));
		assertThat(board.getContent(), is("내용"));
	}
}
