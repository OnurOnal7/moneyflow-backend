package ta4_1.MoneyFlow_Backend.Expenses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ta4_1.MoneyFlow_Backend.Users.User;

import java.util.UUID;

/**
 * Represents the expenses associated with a user.
 *
 * @author Kemal Yavuz
 * @author Onur Onal
 */
@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Expenses {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;    // Unique identifier for the expenses.

    @Column(name = "personal")
    @NonNull
    private double personal;    // Personal expenses.

    @Column(name = "work")
    @NonNull
    private double work;    // Work-related expenses.

    @Column(name = "home")
    @NonNull
    private double home;    // Home expenses.

    @Column(name = "other")
    @NonNull
    private double other;   // Other expenses.

    @JsonIgnore
    @OneToOne
    //@MapsId
    @JoinColumn(name = "user_id")
    private User user;  // The user associated with these expenses.

    public void setPersonal(double personal) {
        if (personal >= 0) {
            this.personal = personal;
        }
    }

    public void setWork(double work) {
        if (work >= 0) {
            this.work = work;
        }
    }

    public void setHome(double home) {
        if (home >= 0) {
            this.home = home;
        }
    }

    public void setOther(double other) {
        if (other >= 0) {
            this.other = other;
        }
    }

    public double getTotalExpenses() {
        return personal + work + home + other;
    }

    @Override
    public String toString() {
        return "Expenses{" + "id=" + id + ", personal=" + personal + ", work=" + work + ", home=" + home + ", other=" + other + '}';
    }
}