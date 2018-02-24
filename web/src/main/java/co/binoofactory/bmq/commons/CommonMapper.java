package co.binoofactory.bmq.commons;

import java.util.ArrayList;

/**
 * @Class Name : CommonMapper
 * @Description : Common sql Mapper
 * @author botbinoo@naver.com
 * @since 2018.02.22
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */

public interface CommonMapper {
	public void insertItem(Object item) throws Exception;
	public void updateItem(Object item) throws Exception;
	public void deleteItem(Object item) throws Exception;
	public Object selectItem(Object item) throws Exception;
	@SuppressWarnings("rawtypes")
	public ArrayList selectItemList(Object item) throws Exception;
	public int selectItemListTotCnt(Object item) throws Exception;
}