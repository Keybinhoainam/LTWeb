package NHLStore.model;

import javax.validation.constraints.NotEmpty;

public class AccountDTO{
	
	private Long id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private String phone;
	private String email;
	private boolean isadmin;
	private boolean isEdit=false;
	private String confirm_password;
    private boolean remenberMe=false;
	public AccountDTO(Long id, @NotEmpty String username, @NotEmpty String password, String phone, String email,
			boolean isadmin, boolean isEdit, boolean remenberMe) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.isadmin = isadmin;
		this.isEdit = isEdit;
		this.remenberMe = remenberMe;
	}
	public AccountDTO() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	public boolean isEdit() {
		return isEdit;
	}
	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	public boolean isRemenberMe() {
		return remenberMe;
	}
	public void setRemenberMe(boolean remenberMe) {
		this.remenberMe = remenberMe;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	

}