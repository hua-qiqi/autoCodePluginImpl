package com.zte;

import java.io.IOException;

import com.zte.common.util.AutoCreateBeanUtil;
import com.zte.common.util.AutoCreateRestUtil;

import freemarker.template.TemplateException;

public class Test {

	public static void main(String[] args) throws IOException, TemplateException {
		AutoCreateBeanUtil.autoCreateAnntation();
		AutoCreateRestUtil.createRest();
	}

}
