package com.msb.dongbao.portal.web.controller;

import com.msb.dongbao.common.base.result.ResultWrapper;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import com.msb.msbdongbaocommonutil.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2020/12/29
 */
@RestController
@RequestMapping("/user-member")
public class UserMemberController {

	@Autowired
	UmsMemberService umsMemberService;

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	/**
	 * 注册
	 * @param umsMemberRegisterParamDTO
	 * @return
	 */
	@PostMapping("/register")
	public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

		return umsMemberService.register(umsMemberRegisterParamDTO);
	}

	@PostMapping("/login")
	public ResultWrapper login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){


		return umsMemberService.login(umsMemberLoginParamDTO);
	}

	/**
	 * 这是测试的 系统中的任意一个接口,
	 * 修改用户信息。
	 * @param token
	 * @return
	 */
	@GetMapping("/test-verify")
	public String verify(String token){

		String s = JwtUtil.parseToken(token);
		String token1 = JwtUtil.createToken(s);
		return token1;
	}
}