package com.swag;

import com.swag.utility.IService;
import com.swag.utility.Service;

public class MainRunner {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		IService myService = Interceptor.getProxy(Service.class);
		myService.doStuff();
	}
}
