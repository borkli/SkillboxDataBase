import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "linked_purchase_list")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedKey key;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


    public LinkedPurchaseList(LinkedKey key, int price, Date subscriptionDate) {
        this.key = key;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }

    public LinkedKey getKey() {
        return key;
    }

    public void setKey(LinkedKey key) {
        this.key = key;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
