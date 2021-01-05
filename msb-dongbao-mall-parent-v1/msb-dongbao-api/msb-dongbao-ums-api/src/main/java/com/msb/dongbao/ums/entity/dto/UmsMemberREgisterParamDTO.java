package com.msb.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2021/1/5
 */
@Data
@ToString
public class UmsMemberREgisterParamDTO {

	private String username;
	private String password;
	private String icon;
	private String email;
	private String nickName;

}
