package co.binoofactory.bmq.botbinoo.svc;

import org.apache.ibatis.annotations.Mapper;

import co.binoofactory.bmq.botbinoo.vo.MenuVO;
import co.binoofactory.bmq.commons.CommonMapper;

/**
 * @Class Name : MenuMapper
 * @Description : Menu mapper (dao)
 * @author botbinoo@naver.com
 * @since 2018.02.26
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */

@Mapper
public interface MenuMapper extends CommonMapper<MenuVO> {
	// Generic super class.
}
