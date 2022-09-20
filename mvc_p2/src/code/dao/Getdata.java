package code.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import code.model.DistrictModel;
import code.model.StateModel;
import code.model.UserStateModel;

@Component
public class Getdata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3404106783486703797L;
	@Autowired
	SessionFactory sessionFactory; 
	//not working
	public List<Object[]> getDataRegistSql(){
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			   SQLQuery query = session.createSQLQuery("SELECT s.state_name,d.district_name FROM mst_state as s inner join mst_district as d on cast(d.state_code as int) =s.state_code");
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();
			System.out.println("list is"+list);
			transaction.commit();
			return list;
		} catch (Exception e) {
			System.out.println("Getdata.getDataRegistSql() error");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	 public List<UserStateModel> getDataRegist(){
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query createQuery = session.createQuery("from UserStateModel");
			@SuppressWarnings("unchecked")
			List<UserStateModel> list = createQuery.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			System.out.println("Getdata.getDataRegist() error");
		}
		return null;
	}
	
	
	 public boolean saveUserRegist(UserStateModel usr){
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Integer data=(Integer)session.save(usr);
			transaction.commit();
			if (data>0) {
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println("Getdata.saveUserRegist() error");
		}
		return false;
	}
	
	
	 public List<StateModel> getStateList(){
		try {
			Session session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();
			Criteria createCriteria = session.createCriteria(StateModel.class);
			createCriteria.addOrder(Order.asc("state_name"));
			@SuppressWarnings("unchecked")
			List<StateModel> list = createCriteria.list();
			beginTransaction.commit();
			return list;
			
		} catch (Exception e) {
			System.out.println("Getdata.getStateList()");
			System.out.println("error in getData cls");
		}
		return null;
	}
	 public synchronized List<DistrictModel> getDistrictList(String stateid){
		 int int1 = Integer.parseInt(stateid);
		 if (int1<=9) {
			stateid="0"+stateid;
		}
		 System.out.println(stateid);
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(DistrictModel.class);
			criteria.add(Restrictions.eq("state_code", stateid));
			criteria.addOrder(Order.asc("district_name"));
			@SuppressWarnings("unchecked")
			List<DistrictModel> list = criteria.list();
			System.out.println(list);
			transaction.commit();
			return list;
		} catch (Exception e) {
			System.out.println("Getdata.getDistrictList() error");
		}
		return null;
	}
	 public synchronized List<Object[]> getDistrictListbySql(String stateid){
			try {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				  SQLQuery query = session.createSQLQuery("select district_code,district_name,state_code from  mst_district where state_code=:value ");
				  query.setString("value", stateid);
				//criteria.add(Restrictions.eq("state_code", stateid));
				//criteria.addOrder(Order.asc("district_name"));
				@SuppressWarnings("unchecked")
				List<Object[]> list = query.list();
				System.out.println(list);
				transaction.commit();
				return list;
			} catch (Exception e) {
				System.out.println("Getdata.getDistrictList() error");
			}
			return null;
		}
	
}
