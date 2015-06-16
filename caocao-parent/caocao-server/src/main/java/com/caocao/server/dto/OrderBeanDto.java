package com.caocao.server.dto;

import org.hibernate.validator.constraints.NotBlank;

public class OrderBeanDto {
/**订单编号**/
private int orderId;
/**中间点**/
private String midPoint;
/**里程**/
private double distancekm;
/**目的地经度**/
private double destinlg;
/**目的地纬度**/
private double destlt;

private String token;
private float version;
@NotBlank
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
@NotBlank
public String getMidPoint() {
	return midPoint;
}
public void setMidPoint(String midPoint) {
	this.midPoint = midPoint;
}
@NotBlank
public double getDistancekm() {
	return distancekm;
}
public void setDistancekm(double distancekm) {
	this.distancekm = distancekm;
}
@NotBlank
public double getDestinlg() {
	return destinlg;
}
public void setDestinlg(double destinlg) {
	this.destinlg = destinlg;
}
@NotBlank
public double getDestlt() {
	return destlt;
}
public void setDestlt(double destlt) {
	this.destlt = destlt;
}
@NotBlank
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
@NotBlank
public float getVersion() {
	return version;
}
public void setVersion(float version) {
	this.version = version;
}

}
