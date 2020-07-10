package org.zerox.ex08.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerox.ex08.domain.BoardVo;
import org.zerox.ex08.mapper.BoardMapper;


public interface BoardService {
	public void register(BoardVo vo);
	
	public BoardVo getOne(int bno);
	
	public boolean update(BoardVo vo);
	
	public boolean delete(int num);
	
	public List<BoardVo> getList();
	
	

	
}
