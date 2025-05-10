import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {
    private SessionFactory factory;

    public BankService() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Account from = session.get(Account.class, fromId);
            Account to = session.get(Account.class, toId);

            if (from.getBalance() < amount) {
                throw new RuntimeException("Insufficient funds!");
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            session.update(from);
            session.update(to);
            session.save(new model.Transaction(fromId, toId, amount));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Transaction failed: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
