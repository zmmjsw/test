package com.eshipping.fba.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eshipping.fba.util.ErrorInfo;
/**
 * 
* @ClassName: GlobalExceptionHandler 
* @Description: TODO(全局异常统一处理) 
* @author zhumingming 
* @date 2017年12月7日 下午5:55:14 
*
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setUrl(req.getRequestURL().toString());
        if (e instanceof LockedAccountException) {
        	  r.setMessage("用户已经被锁定不能登录，请与管理员联系！");
       } else if (e instanceof AuthenticationException) {
    	   r.setMessage("用户名或密码不正确！");
       }
        return r;
    }



}
