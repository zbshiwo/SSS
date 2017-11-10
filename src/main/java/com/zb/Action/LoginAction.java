package com.zb.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.zb.Service.User1Service;
import com.zb.model.Message;
import com.zb.model.User1;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.annotations.JSON;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;


public class LoginAction extends ActionSupport implements ServletResponseAware {
    private HttpServletResponse httpServletResponse;
    private String username;
    private String password;
    private User1Service user1Service;
    private Message message = new Message();

    @JSON(name = "Message")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser1Service(User1Service user1Service) {
        this.user1Service = user1Service;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public String execute() throws Exception {
        List<User1> list = (List<User1>)user1Service.findAll();
        User1 user1 = new User1();
        Iterator<User1> it = list.iterator();
        while (it.hasNext()){
            user1 = it.next();
            if(username.trim().equals(user1.getUsername()) && password.trim().equals(user1.getPassword())){
                Cookie c1 = new Cookie("username", username);
                Cookie c2 = new Cookie("password", password);
                c1.setPath("/");
                c2.setPath("/");
                c1.setMaxAge(30000);
                c2.setMaxAge(30000);
                httpServletResponse.addCookie(c1);
                httpServletResponse.addCookie(c2);
                message.setSuccess(true);
                message.setMessage("密码正确！");
                return SUCCESS;
            }
        }
        message.setSuccess(false);
        message.setMessage("密码错误！");
        return SUCCESS;
    }
}
