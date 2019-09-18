import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class EmpList {

	public static void main(String[] args) {

		Criteria cr = Util.getSF().openSession().createCriteria(Emp.class);
		SessionFactory sf = Util.getSF();
		Session session = sf.openSession();
		//QBC by Orders
		Order order1 = Order.desc("sal");
		cr.addOrder(order1);
		List<Emp> emps = cr.list();
		for(Emp e : emps)
		{
			System.out.println("Retrival by QBC Orders");
			System.out.println(e.getEno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
			System.out.println("_________________");
		}
		
		
		//QBC by Criteria restriction
		Criterion crt = Restrictions.between("sal", 5000, 500000);
		cr.add(crt);
		List<Emp> emps1 = cr.list();
		for(Emp e : emps1)
		{
			System.out.println("Retrival by QBC  Criteria restriction");
			System.out.println(e.getEno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
			System.out.println("_________________");
		}
		
		//QBC by Projection
		Projection projection = Projections.property("Ename"); 
		cr.setProjection(projection);
		List<Emp> emps2 = cr.list();
		for(Emp e : emps2)
		{
			System.out.println("Retrival by QBC  Projection");
			System.out.println(e.getEno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
			System.out.println("_________________");
		}
		
		
		String Hql1 = "select Ename from Emp";
		Query query=session.createQuery(Hql1);
		List<Emp> emps3 = query.list();
		for(Emp e : emps3)
		{
			System.out.println("Retrival by HQL Projection");
			System.out.println(e.getEno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
			System.out.println("_________________");
		}
		
		String Hql2 = "select Ename from Emp where sal>=50000";
		Query query1 = session.createQuery(Hql2);
		List<Emp> emps4 = query1.list();
		for(Emp e : emps4)
		{
			System.out.println("Retrival by HQL Filtering");
			System.out.println(e.getEno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
			System.out.println("_________________");
		}
		
		String hql3 = "select Ename from Emp order by desc";
		Query query3 = session.createQuery(hql3);
		List<Emp> emps5 = query3.list();
		for(Emp e : emps5)
		{
			System.out.println("Retrival by HQL Orders");
			System.out.println(e.getEno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
			System.out.println("_________________");
		}
		
		String hql4 = "delete from Emp where sal=:salary";
		Query query4 = session.createQuery(hql4);
		query4.setParameter("salary", 60000);
		query4.executeUpdate();
		List<Emp> emps6 = query4.list();
		for(Emp e : emps6)
		{
			System.out.println("Retrival by HQL DML");
			System.out.println("after deletion!");
			System.out.println(e.getEno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
			System.out.println("_________________");
		}
		
		
		String sql = "select * from Emp";
		SQLQuery query5 = session.createSQLQuery(sql);
		List<Emp> emps7 = query5.list();
		for(Emp e:emps7)
		{
			System.out.println("Retrival by SQL");
			System.out.println(e.getEno());
			System.out.println(e.getEname());
			System.out.println(e.getSal());
			System.out.println("_________________");
		}
		
		
	}

}
