package org.zerox.ex08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.zerox.ex08.domain.BoardVo;
import org.zerox.ex08.mapper.BoardMapper;


import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVo vo) {
		System.out.println("register . ......" + mapper);
		mapper.insert(vo);

	}

	@Override
	public BoardVo getOne(int bno) {
		
		return mapper.getOne(bno);
	}

	@Override
	public boolean update(BoardVo vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public boolean delete(int num) {
		
		return mapper.delete(num);
	}

	@Override
	public List<BoardVo> getList() {
		
		return mapper.getList();
	}
	
	

}
