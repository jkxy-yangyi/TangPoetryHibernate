package com.jkxy.support.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.jkxy.support.model.Poetries;
import com.jkxy.support.uitl.HibernateUtils;

public class Select2 {

	/**
	 * 2、分页输出诗人李白所有诗词的标题，要求每10个标题分为1页，输出的数据格式如下：
		诗人李白相关的数据总共 XXX页。
		第一页内容：
		《。。。》
		《。。。》
		最后一页内容：
		《。。。》
		《。。。》
	 */
	public static void main(String[] args) {
		Session session=null;
		Query query=null;
		try{
			session=HibernateUtils.getSession();
			String sql="select count(p.poet_id) from poetries p where p.poet_id=97";
			query = session.createSQLQuery(sql);
			List lists = query.list();
			Object object = lists.get(0);
			int count = (Integer.parseInt(object.toString()) /10) +1;
			System.out.println("诗人李白相关的数据总共 "+count+"页");
			String hql = "from Poetries where poet_id=97";
			for(int i=1;i<=count;i++){
				if(i == count){
					System.out.println("最后一页内容： ");
				}else {
					System.out.println("第"+ i +"页内容");
				}
				query = session.createQuery(hql).setFirstResult((i - 1) * 10).setMaxResults(10);
				List<Poetries> list = (List<Poetries>)query.list();
				for(Poetries poe : list){
					System.out.println("《" + poe.getTitle() + "》");
				}
			}
			System.out.println("----------完成----------");
		}catch(HibernateException he){
			he.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}

	}

}
