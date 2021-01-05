package com.msb.dongbao.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberREgisterParamDTO;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 晁鹏飞
 * @since 2020-12-23
 */
@Service
public class UmsMemberServiceImpl  implements UmsMemberService {

	@Autowired
	UmsMemberMapper umsMemberMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String register(UmsMemberREgisterParamDTO umsMemberREgisterParamDTO){

		UmsMember umsMember = new UmsMember();
		BeanUtils.copyProperties(umsMemberREgisterParamDTO,umsMember);

		String encode = passwordEncoder.encode(umsMemberREgisterParamDTO.getPassword());

		umsMember.setPassword(encode);

		umsMemberMapper.insert(umsMember);

		return "success";
	}
}
