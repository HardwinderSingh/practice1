package com.hsd.code;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hsd.props.AppconfigProps;
import com.hsd.props.FinalValue;

@Component
@Order(1)
public class client implements CommandLineRunner {

	@Autowired
	private AppconfigProps appconfigProps;

	@Override
	public void run(String... args) throws Exception {
		Map<String, String> map = appconfigProps.getMap();

		// user define list with Stream<jdk 1.8(lambda/Stream API >
		List<String> list = List.of("harry", "garry", "sharry", "parry", "tarry");

		// Stream<List<String>> liStream = Stream.of(list);
		Stream<String> liStream = list.stream();
		liStream.forEach(a -> System.out.println(a));

		/* ymlFile list with Stream<jdk 1.8(lambda /Stream API > */
		List<String> list2 = appconfigProps.getCustromerlist();
		Stream<String> stream = list2.stream();
		stream.forEach(a -> System.out.println(a));// Stream & lambda use for decreace no of codes

		/* this IS FOR PRACTICE THREAD OPERATIONS */

		Thread tread = Thread.currentThread();
		String treadName = tread.getName();
		System.out.println("printing" + tread + " name = " + treadName);// to check tread

		/* Use final variable */
		System.out.println(map.get(FinalValue.SUCCESS));
		System.out.println("" + map.get(FinalValue.ERROR));
		System.out.println("" + map.get(FinalValue.FAIL));
	}

}
