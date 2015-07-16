package com.caocao.server.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.caocao.nio.server.NettyServer;

public class NioServerListener implements ServletContextListener, Runnable {
	private WebApplicationContext ctx;
	private ExecutorService e = Executors.newSingleThreadExecutor();

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stubs
		ctx = WebApplicationContextUtils.getWebApplicationContext(sce
				.getServletContext());

		e.execute(this);

	}

	public void run() {
		// TODO Auto-generated method stub
		((NettyServer) ctx.getBean("nettyServer")).initAndStart();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		e.shutdown();
		System.out.println("销毁监听");
	}

}
