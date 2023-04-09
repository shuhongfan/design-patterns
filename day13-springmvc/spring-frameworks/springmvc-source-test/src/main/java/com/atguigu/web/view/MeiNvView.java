package com.atguigu.web.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MeiNvView  implements View {
	@Override  //自定义的渲染逻辑
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=utf-8");
		StringBuffer stringBuffer = new StringBuffer();
		String name = request.getParameter("name");
		stringBuffer.append("<h1>"+name+"</h1>");
		stringBuffer.append("<h2>"+model.get("info")+"</h2>");
		stringBuffer.append("<img src='https://t7.baidu.com/it/u=3676218341,3686214618&fm=193&f=GIF'/>");

		response.getWriter().write(stringBuffer.toString());

	}
}
