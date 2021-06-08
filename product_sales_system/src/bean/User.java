package bean;

public class User {
	/**ユーザーID*/
	private String userId;
	/**ユーザー名*/
	private String userName;
	/**パスワード*/
	private String pass;
	/**生年月日*/
	private String birthday;
	/**発送先*/
	private String address;
	/**性別*/
	private int gender;
	/**電話番号*/
	private String tel;
	/**権限*/
	private int authority;
	/**論理削除用フラグ*/
	private int deleteFlag;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getBirthDay() {
		return birthday;
	}

	public void setBirthDay(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}