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
	 * ��Զ�ά�������ű��ϵ1
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
			//��ĳ���û�û��ĳ����ɫ ����lucyû��ǰ̨�Ľ�ɫ	
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 3);
			System.out.println("�û���"+lucy+"; ��ɫ��"+role);
			//�ѽ�ɫ�ŵ��û���set������
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
	 * ��Զ�ά�������ű��ϵ2
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
			//��ĳ���û�����ĳ����ɫ ����lucy��ǰ̨�Ľ�ɫ	
			User lucy = session.get(User.class, 1);
			Role role = session.get(Role.class, 3);
			System.out.println("�û���"+lucy+"; ��ɫ��"+role);
			//�ѽ�ɫ�ŵ��û���set������
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
	 * ��Զ༶��ɾ��:��ɾ��������ɫ��һ�㲻�Ƽ�ʹ��
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
	 * ��Զ༶������
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
			//��������û���Ϊÿ���û����������ɫ
			User user1 = new User();
			user1.setUser_name("lucy");
			user1.setUser_password("123456");
			
			User user2 = new User();
			user2.setUser_name("rose");
			user2.setUser_password("456789");
			
			Role role1 = new Role();
			role1.setRole_name("�ܾ���");
			role1.setRole_descrbie("�ܾ���ְλ");
			
			Role role2 = new Role();
			role2.setRole_name("����");
			role2.setRole_descrbie("����ְλ");
			
			Role role3 = new Role();
			role3.setRole_name("ǰ̨");
			role3.setRole_descrbie("ǰְ̨λ");
			
			//������ϵ���ѽ�ɫ�ŵ��û���
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
