package com.baidu.exportslx;
//package com.baidu;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.yunlook.bean.FileName;
//import com.yunlook.util.DateUtil.DateRange;
//
//public class StringUtil {
//	public static String hideNumbers(String phone){
//		StringBuilder sBuilder = new StringBuilder(phone);
//		StringBuilder replace = sBuilder.replace(3, 7, "****");
//		return replace.toString();
//	}
//	
//	public static Map<String, Long> playTimesStages(Long playTimes) {
//		int length = playTimes.toString().length();
//		if (length > 10) {
//			return playTimesStages2(playTimes);
//		}
//		return playTimesStages1(playTimes);
//	}
//	
//	private static Map<String, Long> playTimesStages1(Long playTimes) {
//		int length = playTimes.toString().length();
//		
//		Long p = (long) Math.pow(10, length - 1);
//		Long s1 = p / 10;
//		
//		Long s4 = playTimes / p * p;
//		
//		Long s3 = p * 5;
//		Long s2 = p * 2;
//		if (s3 >= s4) {
//			s3 = p * 2;
//			s2 = p;
//		}
//		
//		if (s3.equals(s4)) {
//			s3 = p;
//			s2 = p / 2;
//		}
//		
//		if (s2 >= s4) {
//			s3 = s2 / 2;
//			s2 = 2 * (long) Math.pow(10, s3.toString().length() - 1);
//		}
//		
//		Long s5 = s4 + p;
//		Map<String, Long> map = new HashMap<>();
//		map.put("s1", s1);
//		map.put("s2", s2);
//		map.put("s3", s3);
//		map.put("s4", s4);
//		map.put("s5", s5);
//		return map;
//	}
//	
//	private static Map<String, Long> playTimesStages2(Long playTimes) {
//		int length = playTimes.toString().length();
//		
//		Long p = (long) Math.pow(10, length - 2);
//		Long s1 = p;
//		
//		Long s4 = playTimes / p * p;
//		Long denominator = 5000000000L;
//		Long count = s4 / denominator;
//		Long s3 = count * denominator;
//		if (s3.equals(s4)) {
//			count --;
//			s3 = count * denominator;
//		}
//		Long s2 = (count - 1) * denominator;
//		if (count < 2) {
//			s2 = 2000000000L;
//		}
//		
//		Long s5 = s4 + p;
//		Map<String, Long> map = new HashMap<>();
//		map.put("s1", s1);
//		map.put("s2", s2);
//		map.put("s3", s3);
//		map.put("s4", s4);
//		map.put("s5", s5);
//		return map;
//	}
//	
//	public static void main(String[] args) {
////		playTimesStages(5076477537L);
//		Map<String, Long> playTimesStages2 = playTimesStages(192000000L);
//		System.out.println(playTimesStages2);
//	}
//	
//	public static String filterEmoji(String source) {
//		if (source != null) {
//			source = filterEmoji2(source);
//			Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
//					Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
//			Matcher emojiMatcher = emoji.matcher(source);
//			if (emojiMatcher.find()) {
//				source = emojiMatcher.replaceAll(" ");
//				return source;
//			}
//			return source;
//		}
//		return source;
//	}
//	
//	private static boolean isNotEmojiCharacter(char codePoint) {
//		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
//				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
//				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
//	}
//
//	/**
//	 * 过滤emoji 或者 其他非文字类型的字符
//	 * 
//	 * @param source
//	 * @return
//	 */
//	public static String filterEmoji2(String source) {
//		int len = source.length();
//		StringBuilder buf = new StringBuilder(len);
//		for (int i = 0; i < len; i++) {
//			char codePoint = source.charAt(i);
//			if (isNotEmojiCharacter(codePoint)) {
//				buf.append(codePoint);
//			} else {
//				buf.append(" ");
//			}
//		}
//		return buf.toString();
//	}
//	
//	public static String removeParams(String url) {
//		if (url.contains("?")) {
//			url = url.substring(0, url.indexOf("?"));
//		}
//		return url;
//	}
//	
//	public static boolean judgeIsMoblie(HttpServletRequest request) {
//		boolean isMoblie = false;
//		String[] mobileAgents = { "iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
//				"opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
//				"nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
//				"docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
//				"techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
//				"wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
//				"pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
//				"240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
//				"blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
//				"kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
//				"mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
//				"prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
//				"smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
//				"voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
//				"Googlebot-Mobile" };
//		if (request.getHeader("User-Agent") != null) {
//			for (String mobileAgent : mobileAgents) {
//				if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
//					isMoblie = true;
//					break;
//				}
//			}
//		}
//		return isMoblie;
//	}
//	
//	public static String buildFileName(FileName fn) {
//		
//		DateRange parseDate = DateUtil.parseDate(fn.getFromDate(), fn.getToDate());
//		Long startL = parseDate.getFromDate();
//		Long endL = parseDate.getToDate();
//		String name = fn.getName();
//		String fileName = "《"+name+"》"
//				+ "("+DateUtil.YYYY_MM_DD_HH_MM.format(new Date(startL))+" "
//						+ "- "+DateUtil.YYYY_MM_DD_HH_MM.format(new Date(endL))+") "+fn.getEndStr()+".csv";
//		try {
//			fileName = new String( fileName.getBytes("UTF-8"), "ISO8859-1" );
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return fileName;
//	}
//	
//	public static String buildHistoryFileName(FileName fn) {
//		
//		String name = fn.getName();
//		String fileName = "《"+name+"》"
//				+ "( 截止到 "+DateUtil.YYYY_MM_DD_HH_MM.format(new Date())+") "+fn.getEndStr()+".csv";
//		try {
//			fileName = new String( fileName.getBytes("UTF-8"), "ISO8859-1" );
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return fileName;
//	}
//
//	public static Integer StringToInteger(String s) {
//		int parseInt = 0;
//		try {
//			parseInt = Integer.parseInt(s);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		return parseInt;
//	}
//	
//	public static Double StringToDouble(String s) {
//		Double parseDouble = 0.0;
//		try {
//			parseDouble = Double.parseDouble(s);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		return parseDouble;
//	}
//	
//	public static  String realName(String name) {
//		if (name.endsWith(StaticString.MOVIE)) {
//			name = name.substring(0, name.length() - StaticString.MOVIE.length());
//		} else if (name.endsWith(StaticString.TV)) {
//			name = name.substring(0, name.length() - StaticString.TV.length());
//		} else if (name.endsWith(StaticString.HUA_XU)) {
//			name = name.substring(0, name.length() - StaticString.HUA_XU.length());
//		} else if (name.endsWith(StaticString.ART)) {
//			name = name.substring(0, name.length() - StaticString.ART.length());
//		} else if (name.endsWith(StaticString.ANIMATION)) {
//			name = name.substring(0, name.length() - StaticString.ANIMATION.length());
//		}
//		return name;
//	}
//	
//	public static String getFirstKey(String name) {
//		String firstKey = "";
//		if (name.endsWith(StaticString.MOVIE)) {
//			firstKey = "movie";
//		} else if (name.endsWith(StaticString.TV)) {
//			firstKey = "tv";
//		} else if (name.endsWith(StaticString.HUA_XU)) {
//			firstKey = "tv:hua_xu";
//		} else if (name.endsWith(StaticString.ART)) {
//			firstKey = "art";
//		} else if (name.endsWith(StaticString.ANIMATION)) {
//			firstKey = "animation";
//		}
//		return firstKey;
//	}
//	
//	/**
//	 * mysql monitor表中的数字channelType 转为对应的 str
//	 * @param channelType
//	 * @return
//	 */
//	public static String numChannelTypeToStr(String channelType) {
//		String string = null;
//		switch (channelType) {
//		case "0":
//			string = StaticString.TV_TYPE;
//			break;
//		case "1":
//			string = StaticString.MOVIE_TYPE;
//			break;
//		case "2":
//			string = StaticString.ART_TYPE;
//			break;
//		case "3":
//			string = StaticString.ACTOR_TYPE;
//			break;
//		case "6":
//			string = StaticString.ANIMATION_TYPE;
//			break;
//		}
//		return string;
//	}
//}
