package co.binoofactory.bmq.commons;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Class Name : CommonDAO
 * @Description : Common DB access object
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */

public abstract class CommonDAO<VO> implements CommonMapper<VO>{
	@Autowired
    private SqlSessionTemplate sqlSession;
	
	public String mapper;
	
	@Override
	public void insertItem(VO item) throws Exception{
		sqlSession.insert(mapper+".insertItem", item);
	}
	@Override
	public void updateItem(VO item) throws Exception{
		sqlSession.update(mapper+".updateItem", item);
	}
	@Override
	public void deleteItem(VO item) throws Exception{
		sqlSession.delete(mapper+".deleteItem", item);
	}
	@Override
	public VO selectItem(VO item) throws Exception{
		return sqlSession.selectOne(mapper+".selectItem", item);
	}
	@Override
	public List<VO> selectItemList(VO item) throws Exception{
		System.out.println("log:" + mapper);
		return sqlSession.selectList(mapper+".selectItemList", item);
	}
	@Override
	public int selectItemListTotCnt(VO item) throws Exception{
		return sqlSession.selectOne(mapper+".selectItemListTotCnt", item);
	}
}