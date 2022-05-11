package com.mySampleApplication.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Mirimas
 */
public class AppContext implements ApplicationContextAware {

	private static ApplicationContext appContext;

	private AppContext() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		appContext = applicationContext;
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		return appContext.getBean(name, clazz);
	}

	public static Object getBean(String name) {
		return appContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		return appContext.getBean(clazz);
	}
}
