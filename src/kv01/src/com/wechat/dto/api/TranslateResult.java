package com.wechat.dto.api;

/**
 * 翻译结果
 * @类名	TranslateResult.java
 */
public class TranslateResult {

	private int errorCode;// 错误码
	private String query;// 原文
	private String translation;// 翻译结果
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
}
