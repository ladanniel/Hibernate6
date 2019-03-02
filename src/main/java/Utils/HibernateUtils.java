package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	//��׼�Ͻ�д��
  private static final Configuration configuration ;
  private static final SessionFactory sessionFactory;
	static{
		//���غ��������ļ�hibernate.cfg.xml
		 configuration = new Configuration().configure("hibernate.cfg.xml");
		 sessionFactory = configuration.buildSessionFactory();
	}
//�ṩ����sessionFactory���� ��Configuration��SessionFactory��ȡ��ȫ�ֶ��󣬲��ܷ���
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
		
	}
	public static void main(String[] args) {
		
	}
}
