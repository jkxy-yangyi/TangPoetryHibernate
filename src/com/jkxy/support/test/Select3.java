package com.jkxy.support.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jkxy.support.uitl.HibernateUtils;

public class Select3 {

	/**
	 * 3、［使用关联映射实现］输出某一个诗人所有的诗词前15个字（包括标点符号），这个诗人的名字要求用户输入，敲回车后进行查询操作
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Transaction tx=null;
		Session session=null;
		Query query=null;
		try{
			//Scanner scanner = new Scanner(System.in);
			BufferedReader read = new BufferedReader( new InputStreamReader(System.in,"UTF-8"));
			System.out.println("请输入诗人名字：  ");
			String name = read.readLine();
			
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			String sql="select SUBSTRING(p.content,1,15) from poetries p where p.poet_id in (select s.id from poets s where s.name='"+ name+"') ";
			query = session.createSQLQuery(sql);
			List<String> list=query.list();
			for(String str:list){
				System.out.println(str);
			}
			tx.commit();
		}catch(HibernateException he){
			if(tx!=null){
				tx.rollback();
			}
			he.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}

	}

}
