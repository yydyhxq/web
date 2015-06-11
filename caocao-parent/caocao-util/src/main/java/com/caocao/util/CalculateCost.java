package com.caocao.util;

import java.math.BigDecimal;

public class CalculateCost {
public static double acquireCost(float mileageTime,float mileage,double taxStrartPrice,double taxPerTimePrice,double taxPerDistancePrice)
{
	BigDecimal t1=new BigDecimal(taxStrartPrice);
	BigDecimal t2=new BigDecimal(taxPerTimePrice);
	BigDecimal t3=new BigDecimal(taxPerDistancePrice);
	return (t3.multiply(new BigDecimal(mileage)).add(t2.multiply(new BigDecimal(mileageTime))).add(t1)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	
}
}
