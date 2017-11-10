package com.zb.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.zb.Service.User1Service;
import com.zb.model.Message;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
    private HttpServletResponse httpServletResponse;
    private User1Service user1Service;
    private HttpServletRequest httpServletRequest;
    private Message message = new Message();

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public void setUser1Service(User1Service user1Service) {
        this.user1Service = user1Service;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @JSON(name = "Message")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String execute(){
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null && cookies.length > 0){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("username") || cookie.getName().equals("password")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 立即销毁cookie
                    cookie.setPath("/");
                    httpServletResponse.addCookie(cookie);
                    message.setSuccess(true);
                    message.setMessage("成功");
                }

            }
        }
        return SUCCESS;
    }
}
