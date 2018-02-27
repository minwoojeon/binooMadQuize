package co.binoofactory.bmq.botbinoo.svc;

import org.apache.ibatis.annotations.Mapper;

import co.binoofactory.bmq.botbinoo.vo.UserVO;
import co.binoofactory.bmq.commons.CommonMapper;

/**
 * @Class Name : UserMapper
 * @Description : User mapper (dao)
 * @author botbinoo@naver.com
 * @since 2018.02.28
 * @version 1
 *
 * Copyright (C) by botbinoo's All right reserved.
 */

@Mapper
public interface UserMapper extends CommonMapper<UserVO> {
	// Generic super class.
}
