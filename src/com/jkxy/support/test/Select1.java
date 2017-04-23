package com.jkxy.support.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jkxy.support.uitl.HibernateUtils;


public class Select1 {

	/**
	 *  1、［使用HQL实现］输出数据中名字为三个字的诗人列表及其诗词的数量统计。格式如：姓名 － 诗词数量
	 */
	public static void main(String[] args) {
		Session session=null;
		Query query=null;
		try{
			session=HibernateUtils.getSession();
			String sql="select s.id,s.name from poets s where s.name like'___'";
			query = session.createSQLQuery(sql);
			List<Object[]> list=query.list();
			for(Object[] p:list){
				String hql="select count(p.poet_id) from poetries p where p.poet_id="+p[0];
				query = session.createSQLQuery(hql);
				List lists = query.list();
				Object object = lists.get(0);
				System.out.println(p[1]+" -- "+object);
			}
			System.out.println("----------完成----------");
		}catch(HibernateException he){
			he.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}

	}

}
