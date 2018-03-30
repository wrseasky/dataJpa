package com.baidu.immutable;

import static com.google.common.collect.Maps.newHashMap;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月28日 下午3:46:07 类说明
 */
public class ImmutableCollections {
	public static void main1(String[] args) {

		Map<String, List<String>> map = Maps.newHashMap();

		List<String> list = Lists.newArrayList();

		Set<String> set = Sets.newHashSet();

		ImmutableList<String> iList = ImmutableList.of("a", "b", "c");

		ImmutableMap<String, Integer> iMap = ImmutableMap.of("a", 1, "b", 2, "c", 3);

		HashMap<Object, Object> newHashMap2 = newHashMap();

		// 读文件流
		File file = new File(ImmutableCollections.class.getResource("/test.txt").getFile());
		List<String> lines = null;
		try {
			lines = Files.readLines(file, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 比较两个基本类型 < -1 >1 = 0
		int a = 1, b = 2;
		int compare = Ints.compare(a, b);

		// list转换为int数组
		List<Integer> ll = ImmutableList.of(1, 2, 3, 4);
		int[] array = Ints.toArray(ll);

		// 以/组成字符串 usr/local/lib
		String[] subdirs = { "usr", "local", "lib" };
		String join = Joiner.on("/").join(subdirs);
		System.out.println(join);

		int[] numbers = { 1, 2, 3, 4, 5 };
		String numStr = Ints.join(",", numbers);
		System.out.println(numStr);

		// 判断*数组*中是否包含指定值
		int[] ints = { 1, 2, 3 };
		boolean contains = Ints.contains(ints, 1);

		int indexOf = Ints.indexOf(ints, 1);
		int max = Ints.max(ints);
		int min = Ints.min(ints);
		// 连接多个数组
		int[] concat = Ints.concat(ints, numbers);

		// filter
		List<String> names = Lists.newArrayList("john", "janee", "admin");
		Collection<String> filter = Collections2.filter(names, Predicates.containsPattern("a"));
		Iterable<String> iterable = Iterables.filter(names, Predicates.containsPattern("a"));

		List<Integer> intss = Lists.newArrayList(1, 6, 4, 8, 7);
		// 筛选集合中大于6的
		Collection<Integer> filterInts = Collections2.filter(intss, new Predicate<Integer>() {

			@Override
			public boolean apply(Integer arg0) {
				if (arg0 >= 6)
					return true;
				return false;
			}
		});

		// 将集合中int转为字符串 + transfer
		List<String> transform = Lists.transform(intss, new Function<Integer, String>() {

			@Override
			public String apply(Integer input) {
				return String.valueOf(input) + "transfer";
			}
		});

		// 多个predicate组合 -->包含a字母或者不包含J的字母
		Collection<String> filter2 = Collections2.filter(names, Predicates.or(Predicates.containsPattern("a"), Predicates.not(Predicates.containsPattern("j"))));

		// 删除集合中null元素
		List<String> nullNames = Lists.newArrayList("abc", "def", null);
		Collection<String> filter3 = Collections2.filter(nullNames, Predicates.notNull());

		// 将list
		Collection<Integer> transform2 = Collections2.transform(names, new Function<String, Integer>() {

			@Override
			public Integer apply(String input) {
				return input.length();
			}
		});

		// 两个Function 先应用函数f1,求出每个元素的长度,然后应用函数f2,算出boolean
		Function<String, Integer> function1 = new Function<String, Integer>() {

			@Override
			public Integer apply(String input) {
				return input.length();
			}
		};
		Function<Integer, Boolean> function2 = new Function<Integer, Boolean>() {

			@Override
			public Boolean apply(Integer input) {
				return input % 2 == 0;
			}
		};
		Collection<Boolean> transform3 = Collections2.transform(names, Functions.compose(function2, function1));

		// filter和transform集合
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				return input.startsWith("j");
			}
		};
		ImmutableList<Integer> listt = FluentIterable.from(names).filter(predicate).transform(function1).toList();

	}
	public static void main(String[] args) {
		
		File file = new File("D:\\ideaworkspace\\dataJpa\\src\\main\\resources\\application-dev.properties");
		
		List<String> lines = null;
		try {
			lines = Files.readLines(file, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String string : lines) {
			System.out.println(string);
		}
	}
}
