import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    void testOpeningBalance() {
        BankAccount acc = new BankAccount(1000);
        assertEquals(1000, acc.getBalance());
    }

    @Test
    void testDepositAmount() {
        BankAccount acc = new BankAccount(1000);
        acc.deposit(500);
        assertEquals(1500, acc.getBalance());
    }

    @Test
    void testNegativeDeposit() {
        BankAccount acc = new BankAccount(1000);
        assertThrows(IllegalArgumentException.class,
                () -> acc.deposit(-200));
    }

    @Test
    void testWithdrawAmount() {
        BankAccount acc = new BankAccount(1000);
        acc.withdraw(400);
        assertEquals(600, acc.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        BankAccount acc = new BankAccount(1000);
        assertThrows(IllegalArgumentException.class,
                () -> acc.withdraw(2000));
    }
}
