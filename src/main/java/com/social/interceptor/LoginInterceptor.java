package com.social.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.social.commonpojo.CookieUtils;
import com.social.service.impl.UserServiceImpl;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//��Handlerִ��֮ǰ����
		//�ж��û��Ƿ��¼
		String userName = CookieUtils.getCookieValue(request, "user");
		
			
		if ("".equals(userName) || null == userName ) {
			
			response.sendRedirect("http://localhost:8088");
			
			return false;
		}
			//ȡ���û���Ϣ������
			//����ֵ����handler�Ƿ�ִ�С�true��ִ�У�false����ִ�С�
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// handlerִ��֮�󣬷���ModelAndView֮ǰ
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// ����ModelAndView֮��
		//��Ӧ�û�֮��
	}
	

	
}