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
	 * һ�Զ��޸�
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
			 //����id��ѯ��lucy����ϵ����Ϣ������id��ѯ�аٶȵĿͻ���Ϣ
			 Customer Baidu =  session.get(Customer.class, 1);
			 LinkMen Lucy = session.get(LinkMen.class, 3);
			 System.out.println("��ѯ�ͻ���"+Baidu);
			 System.out.println("��ѯ��ϵ�ˣ�"+Lucy);
			 //��lucy���뵽�ͻ��У��Ѱٶȷ��뵽��ϵ���У����߷�������
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
	 * ����ɾ��
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
			 System.out.println("ɾ��֮ǰ��ѯ��"+customer);
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
	 * �������棺��д��
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
			//���һ���ͻ���Ϊ����ͻ����һ����ϵ�� 
			  //�����ͻ�����ϵ�˶���
			 Customer customer = new Customer();
			 customer.setCustName("����");
			 customer.setCustLevel("�߼��ͻ�");
			 customer.setCustSource("����");
			 customer.setCustPhone("12345678912");
			 customer.setCustMobile("123457");
			 
			 LinkMen linkMen = new LinkMen();
			 linkMen.setLkm_name("С��");
			 linkMen.setLkm_gender("��");
			 linkMen.setLkm_phone("15908895076");
			  //����ϵ�˷���ͻ���
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
	 * ��ʾһ�Զ༶������,����д���������ŵģ����ظ������ϵ�˺Ϳͻ�
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
			//���һ���ͻ���Ϊ����ͻ����һ����ϵ�� 
			  //�����ͻ�����ϵ�˶���
			 Customer customer = new Customer();
			 customer.setCustName("�ٶ�");
			 customer.setCustLevel("VIP");
			 customer.setCustSource("����");
			 customer.setCustPhone("12345678911");
			 customer.setCustMobile("123456");
			 
			 LinkMen linkMen = new LinkMen();
			 linkMen.setLkm_name("jackson");
			 linkMen.setLkm_gender("��");
			 linkMen.setLkm_phone("15908895075");
			  //�ڿͻ����ʾ��ϵ�ˣ�����ϵ�˱�ʾ�ͻ��������ͻ��������ϵ�˶���Ĺ�ϵ
			    //�ڿͻ����ʾ��ϵ�ˣ�����ϵ�˶���ŵ��ͻ������set������
			 customer.getSetLinkMen().add(linkMen);
			 //�ѿͻ�����ŵ���ϵ����
			 linkMen.setCustomer(customer);
			 //���浽���ݿ�
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
