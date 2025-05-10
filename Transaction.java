import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fromAccount;
    private int toAccount;
    private double amount;
    private Date timestamp;

    public Transaction(int from, int to, double amount) {
        this.fromAccount = from;
        this.toAccount = to;
        this.amount = amount;
        this.timestamp = new Date();
    }

    // Getters, Setters
}
