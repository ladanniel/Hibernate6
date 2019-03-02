package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;

import com.itcast.entity.Customer;
import com.itcast.entity.LinkMen;
public class HibernateOneToMany {
	/**
	 * 一对多修改
	 */
	@Test
	public void testOneToManyModify(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trans = null;
		try {
			 sessionFactory = HibernateUtils.getSessionFactory();
			 session = sessionFactory.openSession();
			 trans = session.beginTransaction();
			 //根据id查询叫lucy的联系人信息，根据id查询叫百度的客户信息
			 Customer Baidu =  session.get(Customer.class, 1);
			 LinkMen Lucy = session.get(LinkMen.class, 3);
			 System.out.println("查询客户："+Baidu);
			 System.out.println("查询联系人："+Lucy);
			 //把lucy放入到客户中，把百度放入到联系人中，两者发生关联
			Baidu.getSetLinkMen().add(Lucy);
			Lucy.setCustomer(Baidu);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	
	
	
	
	/**
	 * 级联删除
	 */
	@Test
	public void testOneToManyDelete(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trans = null;
		try {
			 sessionFactory = HibernateUtils.getSessionFactory();
			 session = sessionFactory.openSession();
			 trans = session.beginTransaction();
			 Customer customer = session.get(Customer.class, 2);
			 System.out.println("删除之前查询："+customer);
			 session.delete(customer);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	/**
	 * 级联保存：简化写法
	 */
	@Test
	public void testOneToManySimpleMethod(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trans = null;
		try {
			 sessionFactory = HibernateUtils.getSessionFactory();
			 session = sessionFactory.openSession();
			 trans = session.beginTransaction();
			//添加一个客户，为这个客户添加一个联系人 
			  //创建客户和联系人对象
			 Customer customer = new Customer();
			 customer.setCustName("新浪");
			 customer.setCustLevel("高级客户");
			 customer.setCustSource("网络");
			 customer.setCustPhone("12345678912");
			 customer.setCustMobile("123457");
			 
			 LinkMen linkMen = new LinkMen();
			 linkMen.setLkm_name("小李");
			 linkMen.setLkm_gender("男");
			 linkMen.setLkm_phone("15908895076");
			  //把联系人放入客户中
			 customer.getSetLinkMen().add(linkMen);
			 session.save(customer);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	/**
	 * 表示一对多级联保存,这种写法不是最优的，会重复添加联系人和客户
	 */
	@Test
	public void testOneToManySave(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trans = null;
		try {
			 sessionFactory = HibernateUtils.getSessionFactory();
			 session = sessionFactory.openSession();
			 trans = session.beginTransaction();
			//添加一个客户，为这个客户添加一个联系人 
			  //创建客户和联系人对象
			 Customer customer = new Customer();
			 customer.setCustName("百度");
			 customer.setCustLevel("VIP");
			 customer.setCustSource("网络");
			 customer.setCustPhone("12345678911");
			 customer.setCustMobile("123456");
			 
			 LinkMen linkMen = new LinkMen();
			 linkMen.setLkm_name("jackson");
			 linkMen.setLkm_gender("男");
			 linkMen.setLkm_phone("15908895075");
			  //在客户里表示联系人，在联系人表示客户，建立客户对象和联系人对象的关系
			    //在客户里表示联系人：把联系人对象放到客户对象的set集合里
			 customer.getSetLinkMen().add(linkMen);
			 //把客户对象放到联系人里
			 linkMen.setCustomer(customer);
			 //保存到数据库
			 session.save(linkMen);
			 session.save(customer);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}

}
