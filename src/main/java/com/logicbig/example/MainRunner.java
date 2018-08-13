package com.logicbig.example;

import java.util.ArrayList;
import java.util.List;

public class MainRunner {

	public static void main(String[] args) {
		
		List<String> list = MyInterceptor.getProxy(new ArrayList<>(), List.class);
		list.add("one");
		System.out.println(list);
		list.remove("one");
	}
}
