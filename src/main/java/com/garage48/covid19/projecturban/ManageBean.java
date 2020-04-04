package com.garage48.covid19.projecturban;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ManageBean implements ApplicationContextAware {

	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		ManageBean.context = ctx;
	}

	public static ApplicationContext getApplicationContext() {
		return ManageBean.context;
	}

	public static <T> T getBeanByName(Class<T> classType) {
		return ManageBean.context.getBean(classType);
	}

}
