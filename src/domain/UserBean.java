package domain;

import java.util.Date;
/*
 * UserBean:��װ����
 */
public class UserBean {
private String username;
private String password;
private String gender;
private String email;
private String instroduce;//���ҽ���
private String actioncode;//����ע��ɹ��󼤻�ʹ�õ�
private int state=0;//���������û��Ƿ񼤻0��ʾδ���1��ʾ����
private String role;//�û�����
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
