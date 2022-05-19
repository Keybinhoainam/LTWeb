package NHLStore.model;

import java.io.Serializable;


import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductDTO implements Serializable{
	private Long productId;
//	@NotEmpty
	private String name;
//	@NotEmpty
	private int quantity;
//	@NotEmpty
	private double unitPrice;
	private double primeCost;
	private double savePrice;
//	@NotEmpty
	private String image;
	private MultipartFile imageFile;
	private String descrition;
//	@NotEmpty
	private String status;
//	@NotEmpty
	private Long categoryId;
	private String categoryName;
//	@NotEmpty
	private int discount;
	private Boolean isEdit=false;
	private Boolean isshow;
//	public Long getCategoryId() {
//		return categoryId;
//	}
	
	public Long getProductId() {
		return productId;
	}
	public void ProductDTO() {
		
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Boolean getIsshow() {
		return isshow;
	}
	public void setIsshow(Boolean isshow) {
		this.isshow = isshow;
	}
	public double getPrimeCost() {
		return primeCost;
	}
	public void setPrimeCost(double primeCost) {
		this.primeCost = primeCost;
	}
	public double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(double savePrice) {
		this.savePrice = savePrice;
	}
	
	
	
}
