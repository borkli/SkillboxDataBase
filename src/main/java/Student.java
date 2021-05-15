import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Subscriptions> subscriptions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Subscriptions> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscriptions> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
