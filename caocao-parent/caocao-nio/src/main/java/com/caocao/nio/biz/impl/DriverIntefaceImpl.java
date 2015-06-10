package com.caocao.nio.biz.impl;

import java.util.HashSet;

import com.caocao.nio.biz.DriverInteface;
import com.caocao.nio.geohash.GeoTreeSet;
import com.caocao.nio.tools.Driver;

public class DriverIntefaceImpl implements DriverInteface<Driver>{
	private GeoTreeSet driverSet = new GeoTreeSet();

	@Override
	public void add(Driver t, String geoPath) {
		getSet(geoPath).add(t);
	}

	@Override
	public void update(Driver t, String oldGeoPath, String newGeoPath) {
		getSet(oldGeoPath).remove(t);
		getSet(newGeoPath).add(t);
	}

	@Override
	public void remove(Driver t, String geoPath) {
		getSet(geoPath).remove(t);
	}

	@Override
	final public HashSet<Driver> getSet(String geoPath) {
		return driverSet.getEndSet(geoPath);
	}

	
	

}
