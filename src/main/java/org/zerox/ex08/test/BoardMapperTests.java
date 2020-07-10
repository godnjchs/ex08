package org.zerox.ex08.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerox.ex08.domain.BoardVo;
import org.zerox.ex08.domain.Criteria;
import org.zerox.ex08.mapper.BoardMapper;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	
	@Test
	public void getListTest() {
		boardMapper.insert(new BoardVo(0,"test","testContent","hojin"));
		boardMapper.getList().forEach(ele -> {
			System.out.println(ele.toString());
		});
	}
	
	@Test
	public void getOneTest() {
		System.out.println(boardMapper.getOne(6).toString());
	}
	
	
	/*
	 * @Test public void deleteTest() { System.out.println(boardMapper.delete(2)); }
	 */
	@Test
	public void updateTest() {
		System.out.println(boardMapper.update(new BoardVo(2,"update", "updateContent","siwon")));
	}
	
	@Test
	public void criteriaTest() {
		boardMapper.getListWithCriteria(new Criteria(2,20)).forEach(board -> System.out.println(board.toString()));
	}
	
	
}
