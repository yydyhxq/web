package com.caocao.core.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caocao.util.JsonUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
@Service
public class BaseService implements Serializable {
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;

	private static final long serialVersionUID = -4259534967962440741L;

	/**
	 * 查询分页数据
	 * 
	 * @param mapperClass
	 * @param sqlId
	 * @param sqlParameter
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	protected  PageList<?> getPageList(Class<?> mapperClass, String sqlId,
			Object sqlParameter, int pageIndex, int pageSize) throws Exception {
		SqlSession session = null;
		try {
			SqlSessionFactory sessionFactory = sqlSessionFactory.getObject();
			session = SqlSessionUtils.getSqlSession(sessionFactory);
			if (pageIndex <= 0) {
				pageIndex = 1;
			}
			if (pageSize <= 0) {
				pageSize = 10;
			}
			PageBounds pageBounds = new PageBounds(pageIndex, pageSize);
			PageList<?> pageList = (PageList<?>)session.selectList(mapperClass.getName() + "." + sqlId,
					sqlParameter, pageBounds);
		    
			
			System.out.println("total:"+pageList.getPaginator().getTotalCount());
			System.out.println(JsonUtil.getJSONString(pageList.getPaginator()));
		 return pageList;
		} finally {
			session.close();
		}

	}

}
