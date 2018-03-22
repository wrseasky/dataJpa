package com.baidu.tt;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bea {
private String msgType;
private Map<String,Object> map = new LinkedHashMap<>();
public String getMsgType() {
	return msgType;
}
public void setMsgType(String msgType) {
	this.msgType = msgType;
}
public Map<String, Object> getMap() {
	return map;
}
public void setMap(Map<String, Object> map) {
	this.map = map;
}


}
