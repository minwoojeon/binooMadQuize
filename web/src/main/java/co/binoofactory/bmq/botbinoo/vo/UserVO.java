package co.binoofactory.bmq.botbinoo.vo;

import co.binoofactory.bmq.commons.CommonVO;

/**
 * @Class Name : UserVO
 * @Description : User Values Object.
 * @author botbinoo@naver.com
 * @since 2018.02.28
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

public class UserVO extends CommonVO{
	
	private static final long serialVersionUID = 5389264471148380760L;
	
	/* In menu elements */
	private Integer seq;							/* seq. */
	private String userid;							/* id. */
	private String usernick;						/* nick-name. */
	private String userpw;							/* password. */
	private String userseckey;						/* secure-key. */
	private Integer usercode;						/* code. */
	private Integer pwincorrectcnt=0;				/* incorrect count of password. */
	private Integer areacode;						/* area code. */
	private Integer age;							/* age. */
	private Integer gender;							/* gender. */
	private Integer favoritcode;					/* favorite-code. */
	private String regtime;							/* reg time. */
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernick() {
		return usernick;
	}
	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUserseckey() {
		return userseckey;
	}
	public void setUserseckey(String userseckey) {
		this.userseckey = userseckey;
	}
	public Integer getUsercode() {
		return usercode;
	}
	public void setUsercode(Integer usercode) {
		this.usercode = usercode;
	}
	public Integer getPwincorrectcnt() {
		return pwincorrectcnt;
	}
	public void setPwincorrectcnt(Integer pwincorrectcnt) {
		this.pwincorrectcnt = pwincorrectcnt;
	}
	public Integer getAreacode() {
		return areacode;
	}
	public void setAreacode(Integer areacode) {
		this.areacode = areacode;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getFavoritcode() {
		return favoritcode;
	}
	public void setFavoritcode(Integer favoritcode) {
		this.favoritcode = favoritcode;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
