package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.msb.dongbao.ums.service.UmsMemberService;
import com.msb.msbdongbaocommonutil.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String register(UmsMemberRegisterParamDTO umsMemberREgisterParamDTO){

		UmsMember umsMember = new UmsMember();
		BeanUtils.copyProperties(umsMemberREgisterParamDTO,umsMember);

		String encode = passwordEncoder.encode(umsMemberREgisterParamDTO.getPassword());

		umsMember.setPassword(encode);

		umsMemberMapper.insert(umsMember);

		return "success";
	}

	@Override
	public String login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {

		UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
		if(null !=  umsMember){
			String passwordDb = umsMember.getPassword();

			if(!passwordEncoder.matches(umsMemberLoginParamDTO.getPassword(),passwordDb)){
				return "密码不正确";
			}

		}else{
			return "用户不存在";
		}

		String token = JwtUtil.createToken(umsMember.getUsername());

		System.out.println("登录成功");
		return token;
	}
}
