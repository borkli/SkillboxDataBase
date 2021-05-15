import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Main {

    private static final SessionFactory SESSION_FACTORY = new Configuration().
            configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static void main(String[] args) {
        Session session = SESSION_FACTORY.getCurrentSession();
        session.beginTransaction();

        fillingTable(session);
        session.getTransaction().commit();
        SESSION_FACTORY.close();
    }

    private static void fillingTable(Session session) {
        String hql = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchases = session.createQuery(hql).getResultList();
        for (PurchaseList purchase : purchases) {
            DetachedCriteria studentCriteria = DetachedCriteria.forClass(Student.class)
                    .add(Restrictions.eq("name", purchase.getKey().getStudentName()));

            Student student = (Student) studentCriteria.getExecutableCriteria(session)
                    .list().stream().findFirst().orElseThrow();
            DetachedCriteria courseCriteria = DetachedCriteria.forClass(Course.class)
                    .add(Restrictions.eq("name", purchase.getKey().getCourseName()));

            Course course = (Course) courseCriteria.getExecutableCriteria(session)
                    .list().stream().findFirst().orElseThrow();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(
                    new LinkedKey(student.getId(), course.getId()),
                    purchase.getPrice(), purchase.getSubscriptionDate());
            session.save(linkedPurchaseList);
        }
    }
}
