package com.msb.dongbao.ums.service;

import com.msb.dongbao.ums.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.ums.entity.dto.UmsMemberREgisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author 晁鹏飞
 * @since 2020-12-23
 */
public interface UmsMemberService {

	String register(UmsMemberREgisterParamDTO umsMemberREgisterParamDTO);
}