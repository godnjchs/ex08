package org.zerox.ex08.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerox.ex08.domain.BoardVo;
import org.zerox.ex08.service.BoardService;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class InsertTool {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void insertTest()
	{
		for(int i=0; i <100000;i++) {
			boardService.register(new BoardVo(1,"insertTool" + i,"inserToolContent" + i,"insertToolWriter" + i));
		}
		
	}
}
