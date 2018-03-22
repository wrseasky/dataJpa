package com.baidu.exportslx;
//package com.baidu;
//
//import java.util.Date;
//
//import org.assertj.core.util.DateUtil;
//
//public class CsvWeiXinInfo {
//
//	@ColumnType(columnName = "公众号", index = 0)
//	private String uname;
//
//	@ColumnType(columnName = "标题", index = 1)
//	private String title;
//
//	@ColumnType(columnName = "日期", index = 2)
//	private String createDate;
//
//	@ColumnType(columnName = "时间", index = 3)
//	private String createTime;
//
//	@ColumnType(columnName = "阅读", index = 4)
//	private Long reads;
//
//	@ColumnType(columnName = "点赞", index = 5)
//	private Long likes;
//	
//	@ColumnType(columnName = "发布日期", index = 6)
//	private String pubTime;
//	
//	@ColumnType(columnName = "文章链接地址", index = 7)
//	private String msgLink;
//
//	public String getUname() {
//		return uname;
//	}
//
//	public void setUname(String uname) {
//		this.uname = uname;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public Long getLikes() {
//		return likes;
//	}
//
//	public void setLikes(Long likes) {
//		this.likes = likes;
//	}
//
//	public Long getReads() {
//		return reads;
//	}
//
//	public void setReads(Long reads) {
//		this.reads = reads;
//	}
//
//	public String getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(String createDate) {
//		this.createDate = createDate;
//	}
//
//	public String getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(String createTime) {
//		this.createTime = createTime;
//	}
//	
//	public String getPubTime() {
//		return pubTime;
//	}
//
//	public void setPubTime(String pubTime) {
//		this.pubTime = pubTime;
//	}
//
//	public String getMsgLink() {
//		return msgLink;
//	}
//
//	public void setMsgLink(String msgLink) {
//		this.msgLink = msgLink;
//	}
//
//	public void buildCsvObj(WeiXinInfo weixinInfo) {
//
//		Long date = weixinInfo.getTimestamp();
//		//this.setCreateDate(DateUtil.YYYY_MM_DD.format(new Date(Long.parseLong(date + "000"))));
//		//this.setCreateTime(DateUtil.HH_mm.format(new Date(Long.parseLong(date + "000"))));
//		this.setLikes(weixinInfo.getLikes());
//		this.setReads(weixinInfo.getReads());
//		this.setTitle(weixinInfo.getTitle());
//		this.setUname(weixinInfo.getUname());
//		//this.setPubTime(DateUtil.YYYY_MM_DD_HH_MM.format(new Date(weixinInfo.getPubTime() * 1000)));
//		this.setMsgLink(weixinInfo.getMsgLink());
//	}
//}
