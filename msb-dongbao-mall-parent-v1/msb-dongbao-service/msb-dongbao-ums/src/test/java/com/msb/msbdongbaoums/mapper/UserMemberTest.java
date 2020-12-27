package com.msb.msbdongbaoums.mapper;

import com.msb.msbdongbaoums.entity.UmsMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2020/12/23
 */
@SpringBootTest
public class UserMemberTest {

	@Autowired
	UmsMemberMapper umsMemberMapper;

	@Test
	void testInsert(){


		UmsMember t = new UmsMember();
		t.setUsername("cpf1");
		t.setStatus(0);
		t.setPassword("1");
		t.setNote("note");
		t.setNickName("nick");
		t.setEmail("email");
		t.setUpdateTime(new Date());


		umsMemberMapper.insert(t);
	}
}
