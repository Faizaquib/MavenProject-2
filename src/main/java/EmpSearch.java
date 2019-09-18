import org.hibernate.Session;

public class EmpSearch {

	public static void main(String[] args) {
		Session session = Util.getSF().openSession();
		Emp emp = session.get(Emp.class, 111);
		System.out.println(emp.getEno());
		System.out.println(emp.getEname());
		System.out.println(emp.getSal());
		System.out.println(emp.getLaptop().getBrand());
		System.out.println(emp.getLaptop().getPrice());
		}

}
