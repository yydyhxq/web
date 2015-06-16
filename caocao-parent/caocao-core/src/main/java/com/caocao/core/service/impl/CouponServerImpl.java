package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.CouponMapper;
import com.caocao.core.model.Coupon;
import com.caocao.core.model.CouponExample;
import com.caocao.core.service.CouponServer;
@Service("couponServer")
public class CouponServerImpl extends CouponServer {
	@Resource
	private CouponMapper couponMapper;
	
	public List<Coupon> acquireMyCoupon(int userId)
	{
		CouponExample example=new CouponExample();
		example.createCriteria().andCustomerIdEqualTo(userId);
		return couponMapper.selectByExample(example);
	}
}
