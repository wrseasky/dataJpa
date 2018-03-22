package com.baidu.tt;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class T {
	public static void main(String[] args) {
		Bea bea = new Bea();
		bea.setMsgType("link");
		
		Map<String, Object> map = new HashMap<String, Object>();
		LinkMsg link = new LinkMsg();
		link.setText("text");
		link.setTitle("title");
		link.setPicUrl("picUrl");
		link.setMessageUrl("messageUrl");
		
		map.put("link", link);
		bea.setMap(map);
		
		String jsonString = JSONObject.toJSONString(map);
		System.out.println(jsonString);
	}
}
