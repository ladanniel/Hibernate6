package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itcast.many_to_many.Role;
import com.itcast.many_to_many.User;

import Utils.HibernateUtils;

public class Hibernate_Many_To_Many {
	/**
	 * 多对多维护第三张表关系1
	 */
	@Test
	public void Many_To_Many_Maintain1(){
		 SessionFactory sessionFactory = null;
		 Session session = null;
		 Transaction trans = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			//让某个用户没有某个角色 ：让lucy没有前台的角色	
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 3);
			System.out.println("用户："+lucy+"; 角色："+role);
			//把角色放到用户的set集合里
			lucy.getSetRole().remove(role);
			
			trans.commit();
		} catch (Exception e) {
			e.getStackTrace();
			trans.rollback();
		} finally{
			session.close();
			sessionFactory.close();
		}
		
	}
	/**
	 * 多对多维护第三张表关系2
	 */
	@Test
	public void Many_To_Many_Maintain(){
		 SessionFactory sessionFactory = null;
		 Session session = null;
		 Transaction trans = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			//让某个用户具有某个角色 ：让lucy有前台的角色	
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 3);
			System.out.println("用户："+lucy+"; 角色："+role);
			//把角色放到用户的set集合里
			lucy.getSetRole().add(role);
			trans.commit();
		} catch (Exception e) {
			e.getStackTrace();
			trans.rollback();
		} finally{
			session.close();
			sessionFactory.close();
		}
		
	}
	/**
	 * 多对多级联删除:会删除其他角色，一般不推荐使用
	 */
	@Test
	public void Many_To_Many_Delete(){
		 SessionFactory sessionFactory = null;
		 Session session = null;
		 Transaction trans = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			User user = session.get(User.class, 2);
			session.delete(user);
			trans.commit();
		} catch (Exception e) {
			e.getStackTrace();
			trans.rollback();
		} finally{
			session.close();
			sessionFactory.close();
		}
		
	}
	/**
	 * 多对多级联保存
	 */
	@Test
	public void Many_To_Many_Save(){
		 SessionFactory sessionFactory = null;
		 Session session = null;
		 Transaction trans = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			//添加两个用户，为每个用户添加两个角色
			User user1 = new User();
			user1.setUser_name("lucy");
			user1.setUser_password("123456");
			
			User user2 = new User();
			user2.setUser_name("rose");
			user2.setUser_password("456789");
			
			Role role1 = new Role();
			role1.setRole_name("总经理");
			role1.setRole_descrbie("总经理职位");
			
			Role role2 = new Role();
			role2.setRole_name("秘书");
			role2.setRole_descrbie("秘书职位");
			
			Role role3 = new Role();
			role3.setRole_name("前台");
			role3.setRole_descrbie("前台职位");
			
			//建立关系，把角色放到用户里
			 //user1 --r1/r2
			user1.getSetRole().add(role1);
			user1.getSetRole().add(role2);
			
			//user2 --r1/r3
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			
			session.save(user1);
			session.save(user2);
			
			trans.commit();
		} catch (Exception e) {
			e.getStackTrace();
			trans.rollback();
		} finally{
			session.close();
			sessionFactory.close();
		}
		
	}

}
