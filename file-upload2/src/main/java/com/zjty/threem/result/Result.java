package com.zjty.threem.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
	private Boolean result;//请求是否成功：true：成功；false：请求失败
	private T data;//请求返回的具体数据内容


	private String failResult;//此错误不跳转页面
	private String exceptionFail;//系统异常导致的失败
	private String parameterIsNullFail;//请求参数为空导致的失败

}
