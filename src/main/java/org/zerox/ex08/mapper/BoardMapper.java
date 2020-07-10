package org.zerox.ex08.mapper;

import java.util.List;


import org.zerox.ex08.domain.BoardVo;
import org.zerox.ex08.domain.Criteria;


public interface BoardMapper {

	
//	@Select("select * from tb1_board")
	public List<BoardVo> getList();
	
	
	public int insert(BoardVo vo);
	
	
	public BoardVo getOne(int bno);
	
	
	public boolean delete(int num);
	
	
	public boolean update(BoardVo vo);
	
	public List<BoardVo> getListWithCriteria(Criteria ria);
	
	
}
