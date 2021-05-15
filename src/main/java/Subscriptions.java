import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @EmbeddedId
    private SubKey key;

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public SubKey getKey() {
        return key;
    }

    public void setKey(SubKey key) {
        this.key = key;
    }
}