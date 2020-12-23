package com.msb.msbdongbaoums.mapper;

import com.msb.msbdongbaoums.entity.UmsMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2020/12/23
 */
@SpringBootTest
public class UmsMemberMapperTest {

	@Autowired
	UmsMemberMapper umsMemberMapper;

	@Test
	void testInsert(){
		UmsMember u = new UmsMember();
		u.setEmail("asdasd@qq.com");
		u.setIcon("s");
		u.setNickName("nicknamn");
		u.setNote("s");
		u.setPassword("d");
		u.setStatus(0);
		u.setUsername("usernam1e");
		umsMemberMapper.insert(u);
	}

}
