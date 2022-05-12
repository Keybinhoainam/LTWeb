package NHLStore.model;



import java.io.Serializable;
//
//
//import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class CategoryDTO implements Serializable{
	
	private Long categoryId;
//	@NotEmpty
	private String name;
	
	private Boolean isEdit=false;
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	

}
