/**
 * 
 */
package com.java4u.ds.cart;

/**
 * @author bbadak
 *
 */
public class Product {

	private Integer  productId;
	private String productName;
	private Float price;
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
