package learner.academy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import learner.academy.model.MyClass;
import learner.academy.model.Student;
import learner.academy.model.Subject;
import learner.academy.model.Teacher;
import learner.academy.util.HibUtil;

public class DAO {

	SessionFactory sessionFactory = HibUtil.getSessionFactory();

	public boolean save(Object obj) {
		boolean flag = false;

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
			flag = true;
		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
			tx.rollback();

		} finally {
			if (session != null) {
				session.close();

			}
		}
		return flag;

	}

	public List<MyClass> getClassList() {
		Session session = sessionFactory.openSession();
		List<MyClass> classList = null;
		try {
			classList = session.createQuery("from MyClass").getResultList();
		} catch (Exception ex) {
			System.out.println("exception in getting class List");
		}
		return classList;

	}

	public void deleteClass(Long id) {
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			MyClass myclass = session.get(MyClass.class, id);
			session.delete(myclass);
			tx.commit();
		} catch (Exception exp) {
			if (tx != null) {
				tx.rollback();
			}
		}
	}

	public void editClass(Long id, String className) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			MyClass myclass = session.get(MyClass.class, id);
			myclass.setName(className);
			session.update(myclass);
			tx.commit();

		} catch (Exception exp) {
			tx.rollback();
		}

	}

	public List<Student> getStudentList() {

		Session session = sessionFactory.openSession();
		List<Student> studList = new ArrayList<>();
		try {
			studList = session.createQuery("from Student").getResultList();
		} catch (Exception exp) {
			System.out.println("Error in retieving student List");
		}
		return studList;

	}

	public MyClass getClass(Long cid) {

		Session session = sessionFactory.openSession();
		return session.get(MyClass.class, cid);
	}

	public List<Student> getStudentListByClass(Long id) {
		Session session = sessionFactory.openSession();
		List<Student> studList = null;
		try {
			Query query = session.createQuery("from Student s where s.Myclass.id = :id");
			query.setParameter("id", id);
			studList = query.getResultList();
		} catch (Exception exp) {
			System.out.println("error in retieving list of students");
		}
		return studList;
	}

	public void deleteStudent(Long id) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student stud = session.get(Student.class, id);
			if (stud != null) {
				session.delete(stud);

			}
			tx.commit();
		} catch (Exception exp) {
			exp.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Exception in delete student");
		}

	}

	public List<Subject> getSubList() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from Subject").getResultList();

	}

	public List<Teacher> getTeacherList() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from Teacher").getResultList();

	}

	public void deleteSubject(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Subject stud = session.get(Subject.class, id);
			if (stud != null) {
				session.delete(stud);

			}
			tx.commit();
		} catch (Exception exp) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Exception in delete subject");
		}

	}

	public List<Object[]> getSubTeacher(Long id) {
		Session session = sessionFactory.openSession();
		return session.createNativeQuery(
				"select t.firstName as fname ,s.name  as sub,cst.clist_id,cst.subjects_id,cst.teachers_id,t.lastName from class_subject_teacher cst inner join Teacher t on "
						+ "t.id = cst.teachers_id inner join Subject s on cst.subjects_id=s.id where cst.clist_id= :id")
				.setParameter("id", id).getResultList();

	}

	public void editSubject(Long id, String className) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();

		try {
			tx.begin();
			Subject sub = session.get(Subject.class, id);
			sub.setName(className);
			session.update(sub);
			tx.commit();

		} catch (Exception exp) {
			tx.rollback();
		}

	}

	public int addSubTeacher(Long cid, Long tid, Long sid) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int result = 0;
		try {
			tx = session.beginTransaction();
			result = session.createNativeQuery("insert into class_subject_teacher values (?,?,?)").setLong(1, cid)
					.setLong(2, sid).setLong(3, tid).executeUpdate();
			tx.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		}
		return result;
	}

	public int deletSubTeach(Long classId, Long subId, Long teacherId) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int row = 0;
		try {
			tx = session.beginTransaction();
			row = session
					.createNativeQuery(
							"delete from class_subject_teacher where clist_id= :c and subjects_id= :s and teachers_id= :t")
					.setParameter("c", classId).setParameter("s", subId).setParameter("t", teacherId).executeUpdate();
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null) {
				tx.rollback();

			}
		}
		return row;

	}

	public  Student getStudent(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Student st = session.get(Student.class, id);
		return st;
	}

	public boolean update(Student student) {
		// TODO Auto-generated method stub
		boolean flag =false;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx=session.beginTransaction();
			 session.update(student);
			tx.commit();
			flag = true;
		}
		catch(Exception exp)
		{
			  if(tx!=null)
			  {
				  tx.rollback();
			  }
		}
		return flag;
	}

	public void deleteTeacher(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Teacher stud = session.get(Teacher.class, id);
			if (stud != null) {
				session.delete(stud);

			}
			tx.commit();
		} catch (Exception exp) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Exception in delete teacher");
		}

		
	}

	public Teacher getTeacher(Long id) {
		// TODO Auto-generated method stub
		Teacher teacher = null;
		Session session = null;
		try{ session = sessionFactory.openSession();
			 teacher =	session.get(Teacher.class, id);
		}
		finally {	
		session.close();}
		return teacher;

	}
	public boolean update(Teacher teacher,Long id) {
		// TODO Auto-generated method stub
		boolean flag =false;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try
		{
			tx=session.beginTransaction();
		Teacher newTeacher=	session.get(Teacher.class, id);
		newTeacher.setFirstName(teacher.getFirstName());
		newTeacher.setLastName(teacher.getLastName());
		newTeacher.setDob(teacher.getDob());
		newTeacher.setAddress(teacher.getAddress());
		newTeacher.setPhone(teacher.getPhone());
		newTeacher.setDesignation(teacher.getDesignation());
		 session.update(newTeacher);
			tx.commit();
			flag = true;
		}
		catch(Exception exp)
		{        exp.printStackTrace();
			  if(tx!=null)
			  {
				  tx.rollback();
			  }
		}
		return flag;
	}


}
