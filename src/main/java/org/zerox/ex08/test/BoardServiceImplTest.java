package org.zerox.ex08.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerox.ex08.domain.BoardVo;
import org.zerox.ex08.service.BoardService;
import org.zerox.ex08.service.BoardServiceImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceImplTest {

	@Autowired
	private BoardService boardService;
	
	@Test
	public void insert() {
		
		assertNotNull(boardService);
		boardService.register(new BoardVo(1,"updateService","updateServiceContent","updateServiceWriter"));
		boardService.update(new BoardVo(1,"updateService","updateServiceContent","updateServiceWriter"));
		
	}
	
}
