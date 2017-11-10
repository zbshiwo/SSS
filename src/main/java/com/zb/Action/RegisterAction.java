package com.zb.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.zb.Service.User1Service;
import com.zb.model.Message;
import com.zb.model.User1;
import org.apache.struts2.json.annotations.JSON;

import java.util.List;

public class RegisterAction extends ActionSupport {
    private String username;
    private String password;
    private String repassword;
    private Message message = new Message();
    private User1Service user1Service;

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

//    public String getRepassword() {
//        return repassword;
//    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    @JSON(name = "Message")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setUser1Service(User1Service user1Service) {
        this.user1Service = user1Service;
    }

    @Override
    public String execute() throws Exception {
        if( !password.trim().equals(repassword.trim())){
            message.setSuccess(false);
            message.setMessage("两次密码输入不一致！");
            return ERROR;
        }
        else {
            User1 user1 = user1Service.getUser1(username);
            if(user1 == null){
                user1 = new User1();
                user1.setUsername(username);
                user1.setPassword(password);
                user1.setIsAdmin((byte)0);

                user1Service.saveUser1(user1);
                message.setMessage("注册成功!");
                message.setSuccess(true);
                return SUCCESS;
            }
            else{
                message.setMessage("用户名已存在!");
                message.setSuccess(false);
                return ERROR;
            }
        }
    }
}
