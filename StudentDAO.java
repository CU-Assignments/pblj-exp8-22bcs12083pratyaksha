import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import model.Student;

public class StudentDAO {
    private SessionFactory factory;

    public StudentDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void createStudent(Student student) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }

    public Student readStudent(int id) {
        Session session = factory.openSession();
        Student s = session.get(Student.class, id);
        session.close();
        return s;
    }

    public void updateStudent(int id, String name) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class, id);
        s.setName(name);
        session.update(s);
        tx.commit();
        session.close();
    }

    public void deleteStudent(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class, id);
        session.delete(s);
        tx.commit();
        session.close();
    }
}
