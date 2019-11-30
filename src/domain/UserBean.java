package domain;

import java.util.Date;
/*
 * UserBean:封装数据
 */
public class UserBean {
private String username;
private String password;
private String gender;
private String email;
private String instroduce;//自我介绍
private String actioncode;//用来注册成功后激活使用的
private int state=0;//用来表明用户是否激活，0表示未激活，1表示激活
private String role;//用户档次
private Date registerTime;
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getInstroduce() {
	return instroduce;
}
public void setInstroduce(String instroduce) {
	this.instroduce = instroduce;
}
public String getActioncode() {
	return actioncode;
}
public void setActioncode(String actioncode) {
	this.actioncode = actioncode;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Date getRegisterTime() {
	return registerTime;
}
public void setRegisterTime(Date registerTime) {
	this.registerTime = registerTime;
}

}
