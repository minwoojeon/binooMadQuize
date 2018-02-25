package co.binoofactory.bmq.commons;

import java.util.List;

/**
 * @Class Name : CommonMapper
 * @Description : Common sql Mapper
 * @author botbinoo@naver.com
 * @since 2018.02.22
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */

public interface CommonMapper<VO> {
	public void insertItem(VO item) throws Exception;
	public void updateItem(VO item) throws Exception;
	public void deleteItem(VO item) throws Exception;
	public VO selectItem(VO item) throws Exception;
	public List<VO> selectItemList(VO item) throws Exception;
	public int selectItemListTotCnt(VO item) throws Exception;
}