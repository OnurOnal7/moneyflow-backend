package ta4_1.MoneyFlow_Backend.Budget;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ta4_1.MoneyFlow_Backend.Users.User;

import java.util.UUID;

@Entity
@Table(name = "budgets")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "personal_limit")
    @NonNull
    private double personalLimit;

    @Column(name = "work_limit")
    @NonNull
    private double workLimit;

    @Column(name = "home_limit")
    @NonNull
    private double homeLimit;

    @Column(name = "other_limit")
    @NonNull
    private double otherLimit;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
