package com.caocao.nio.tools;

import io.netty.channel.Channel;

import java.util.HashSet;

public class Driver {
	public double lantitude;
	public double longtitude;
	public HashSet<Driver> currentSet;
	public Channel channel;
	public DriverDO driverDO;
	public long lastHeartBeat;//最后一次心跳时间
}
