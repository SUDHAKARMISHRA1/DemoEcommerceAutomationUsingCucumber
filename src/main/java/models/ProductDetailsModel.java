package models;

public class ProductDetailsModel {

	
	private String ProductTitle;
	private String ProductDescription;
	private String ProductReviews;
	private int ProductCount;
	private int ProductPrice;
	private int TotalStock;
	

	public String getProductTitle() {
		return ProductTitle;
	}
	public void setProductTitle(String productTitle) {
		ProductTitle = productTitle;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public String getProductReviews() {
		return ProductReviews;
	}
	public void setProductReviews(String productReviews) {
		ProductReviews = productReviews;
	}
	public int getProductCount() {
		return ProductCount;
	}
	public void setProductCount(int productCount) {
		ProductCount = productCount;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}
	public int getTotalStock() {
		return TotalStock;
	}
	public void setTotalStock(int totalStock) {
		TotalStock = totalStock;
	}
	
	
}
