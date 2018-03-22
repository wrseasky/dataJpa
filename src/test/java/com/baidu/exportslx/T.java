package com.baidu.exportslx;
//package com.baidu;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.yunlook.bean.FileName;
//import com.yunlook.bean.csv.CsvWeiXinInfo;
//import com.yunlook.bean.restful.WeiXinInfo;
//import com.yunlook.util.CalendarUtil;
//import com.yunlook.util.CsvFileUtil;
//import com.yunlook.util.StringUtil;
//
//public class T {
//
//	
//	@RequestMapping("/downloadWeixinTrend")
//	public Object downloadWeixinTrend(HttpServletRequest request, HttpServletResponse response, String articleId, String name, String fromDate, String toDate) {
//		response.setContentType("application/octet-stream");
//
//		if ("now".equals(fromDate)) {
//			fromDate = CalendarUtil.getYesterday() + "";
//			toDate = System.currentTimeMillis() + "";
//		}
//		FileName fName = new FileName();
//		fName.setFromDate(fromDate);
//		fName.setToDate(toDate);
//		fName.setName(name);
//		fName.setEndStr("微信公众号数据");
//		String fileName = StringUtil.buildFileName(fName);
//		response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
//		List<Map> list = (List<Map>) this.getWeixinWeekTrend(articleId, 1000);
//		List<CsvWeiXinInfo> csvWeixinInfos = new ArrayList<>(list.size());
//		for (Map map : list) {
//			WeiXinInfo wInfo = new WeiXinInfo();
//			try {
//				BeanUtils.populate(wInfo, map);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			CsvWeiXinInfo csvWeiXinInfo = new CsvWeiXinInfo();
//			csvWeiXinInfo.buildCsvObj(wInfo);
//			csvWeixinInfos.add(csvWeiXinInfo);
//		}
//
//		OutputStream os;
//		try {
//			os = response.getOutputStream();
//			CsvFileUtil.writeCSVFile(request, os, csvWeixinInfos);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	
//}
