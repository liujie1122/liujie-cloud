package com.zjty.threem.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
	private String succeed;//请求是否成功：true：成功；false：请求失败
	private T Data;//请求返回的具体数据内容


	private String failResult;//此错误不跳转页面
	private String exceptionFail;//系统异常导致的失败
	private String parameterIsNullFail;//请求参数为空导致的失败

}
