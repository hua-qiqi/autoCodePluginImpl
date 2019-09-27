package com.lyh.plugin;

import java.io.IOException;
import java.sql.SQLException;

import com.lyh.util.AutoCreateBeanUtil;
import com.lyh.util.AutoCreateRestAndServiceUtil;
import com.zte.lyh.PluginParamsConfig;
import com.zte.lyh.PluginService;

import freemarker.template.TemplateException;

public class AutoCodePlugin implements PluginService {

	@Override
	public void service(PluginParamsConfig p) {
		try {
			AutoCreateBeanUtil.autoCreateAnntation(p);
			AutoCreateRestAndServiceUtil.createRest(p);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
