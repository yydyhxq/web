package com.caocao.nio.biz;

import java.util.HashSet;

public interface DriverInteface <T>{
	public void add(T t, String geoPath);
	public void update(T t, String oldpath, String newPath);
	public void remove(T t, String geoPath);
	public HashSet<T> getSet(String geoPath);
}
