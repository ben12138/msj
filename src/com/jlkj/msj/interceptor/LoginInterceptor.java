package com.jlkj.msj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.jlkj.msj.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 将未登录的人拦截到登陆页面
 */
public class LoginInterceptor implements HandlerInterceptor{

	private String allowedPass[];
	
	public String[] getAllowedPass() {
		return allowedPass;
	}

	public void setAllowedPass(String[] allowedPass) {
		this.allowedPass = allowedPass;
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		//获取到请求的url地址
//		String url = request.getRequestURL().toString();
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		System.out.println(user);
//		if(user != null){
//			//取出的session有值，证明登陆过，进入下一个拦截器
//			return true;
//		}else{
//			//如果包含了login.do等关键字，进入下一个拦截器
//			for(String temp:allowedPass){
//				if(url.contains(temp)){
//					return true;
//				}
//			}
//		}
//		//被拦截，返回主页面
//		response.sendRedirect("/index.html");
		return true;
	}
	
}
