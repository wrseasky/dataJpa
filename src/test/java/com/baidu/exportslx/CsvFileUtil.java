package com.baidu.exportslx;
//package com.baidu;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVPrinter;
//
//import com.baidu.AnnotationUtil.ColumnTypeInfo;
//import com.yunlook.bean.BarrageInfo;
//import com.yunlook.filter.SessionFilter;
//
//public class CsvFileUtil {
//
//
//	// CSV文件头
//	private static final Object[] FILE_HEADER = {"渠道", "剧集", "弹幕所在位置", "弹幕内容", "点赞量", "发送日期", "发送时间", "最新更新日期", "最新更新时间" };
//	/**
//	 * 写CSV文件
//	 * 
//	 * @param fileName
//	 */
//	
//	public static void writeBarrageCsvFile(OutputStream os, Collection<BarrageInfo> list) {
//		CSVPrinter csvFilePrinter = null;
//		// 创建 CSVFormat
////		CSVFormat csvFileFormat = CSVFormat.INFORMIX_UNLOAD_CSV.withRecordSeparator(NEW_LINE_SEPARATOR);
//		try {
//			csvFilePrinter = new CSVPrinter(new BufferedWriter(new OutputStreamWriter(os, "gbk")), CSVFormat.DEFAULT);
//			csvFilePrinter.print("云合数据  - 数据启迪娱乐");
//			csvFilePrinter.println();
//			csvFilePrinter.print("ENLIGHTENT - Enlighten Entertainment by Data");
//			csvFilePrinter.println();
//			csvFilePrinter.println();
//			// 创建CSV文件头
//			csvFilePrinter.printRecord(FILE_HEADER);
//			
//			for (BarrageInfo barrageInfo : list) {
//				String content = barrageInfo.getContent();
//				Integer upCount = barrageInfo.getUpCount();
//				Long createTime = barrageInfo.getCreateTime();
//				String name = barrageInfo.getName();
//				Long startTime = barrageInfo.getStartTime();
//				Long updateTime = barrageInfo.getUpdateTime() * 1000;
//				String type = barrageInfo.getType().split("_")[1];
//				type = SessionFilter.channelMap.get(type);
//				startTime = startTime / 1000;
//				int minutes = (int) (startTime / 60);
//				int seconds = (int)(startTime - minutes * 60);
//				String stime = minutes + "分" + seconds + "秒";
//				Object[] dataRecord = new Object[]{
//						type,
//						name, 
//						stime, 
//						content,
//						upCount,
//						DateUtil.YYYY_MM_DD.format(new Date(createTime.longValue())),
//						DateUtil.HH_mm.format(new Date(createTime.longValue())),
//						DateUtil.YYYY_MM_DD.format(new Date(updateTime)),
//						DateUtil.HH_mm.format(new Date(updateTime))
//				};
//				csvFilePrinter.printRecord(dataRecord);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				csvFilePrinter.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	private static Object[] buildCsvHeader(List<ColumnTypeInfo> columnTypeInfos){
//		Object[] objects = new Object[columnTypeInfos.size()];
//		for (int i = 0; i < columnTypeInfos.size(); i++) {
//			objects[i] = columnTypeInfos.get(i).getColumnName();
//		}
//		return objects;
//	}
//	public static <T> void writeCSVFile(HttpServletRequest request, OutputStream os, List<T> list) {
//		if (list.size() < 1) {
//			return;
//		}
//		CSVPrinter csvFilePrinter = null;
//		try {
//			String charset = "gbk";
//			boolean isMoblie = StringUtil.judgeIsMoblie(request);
//			if (isMoblie) {
//				charset = "utf-8";
//			}
//			csvFilePrinter = new CSVPrinter(new BufferedWriter(new OutputStreamWriter(os, charset)), CSVFormat.DEFAULT);
//			csvFilePrinter.print("云合数据  - 数据启迪娱乐");
//			csvFilePrinter.println();
//			csvFilePrinter.print("ENLIGHTENT - Enlighten Entertainment by Data");
//			csvFilePrinter.println();
//			csvFilePrinter.println();
//			
//			List<ColumnTypeInfo> columnTypeInfos = AnnotationUtil.getColumnTypeInfos(list.get(0).getClass());
//			// 创建CSV文件头
//			csvFilePrinter.printRecord(buildCsvHeader(columnTypeInfos));
//			for (T t : list) {
//				Map<String, String> describe = BeanUtils.describe(t);
//				Object[] objects = new Object[columnTypeInfos.size()];
//				for (int i = 0; i < columnTypeInfos.size(); i++) {
//					String fieldName = columnTypeInfos.get(i).getFieldName();
//					objects[i] = describe.get(fieldName);
//				}
//				csvFilePrinter.printRecord(objects);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				csvFilePrinter.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//}