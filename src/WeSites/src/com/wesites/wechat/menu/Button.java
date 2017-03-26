package com.wesites.wechat.menu;

public class Button {
	//锟剿碉拷锟斤拷锟斤拷
	private String type;
	//锟剿碉拷锟斤拷锟�	
	private String name;
	//锟斤拷锟斤拷锟剿碉拷
	private Button[] sub_button;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Button[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
}
