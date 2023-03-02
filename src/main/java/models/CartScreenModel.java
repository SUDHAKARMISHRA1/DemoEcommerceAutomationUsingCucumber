package models;

public class CartScreenModel {

	private String HeadingCartScreen;
	private String AppliedCoupon;
	private String FailedErrorCoupon;
	private String RemoveAlertMessage;
	private String ProductQuantity;
	private int TotalAmount;
	private int SubTotal;
	
	public String getHeadingCartScreen() {
		return HeadingCartScreen;
	}
	public void setHeadingCartScreen(String headingCartScreen) {
		HeadingCartScreen = headingCartScreen;
	}
	public String getAppliedCoupon() {
		return AppliedCoupon;
	}
	public void setAppliedCoupon(String appliedCoupon) {
		AppliedCoupon = appliedCoupon;
	}
	public String getFailedErrorCoupon() {
		return FailedErrorCoupon;
	}
	public void setFailedErrorCoupon(String failedErrorCoupon) {
		FailedErrorCoupon = failedErrorCoupon;
	}
	public String getRemoveAlertMessage() {
		return RemoveAlertMessage;
	}
	public void setRemoveAlertMessage(String removeAlertMessage) {
		RemoveAlertMessage = removeAlertMessage;
	}
	public String getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		ProductQuantity = productQuantity;
	}
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}
	public int getSubTotal() {
		return SubTotal;
	}
	public void setSubTotal(int subTotal) {
		SubTotal = subTotal;
	}
	
}
