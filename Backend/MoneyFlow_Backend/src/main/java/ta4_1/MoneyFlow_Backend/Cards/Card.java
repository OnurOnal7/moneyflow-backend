package ta4_1.MoneyFlow_Backend.Cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ta4_1.MoneyFlow_Backend.Users.User;

import java.util.UUID;

/**
 * Entity representing a credit/debit card.
 *
 * @author Onur Onal
 * @author Kemal Yavuz
 */
@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Card {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;    // Unique identifier for the card

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;    // Name of the card

    @Column(name = "card_number", unique = true, nullable = false)
    @NonNull
    private String cardNumber;  // Card number, must be unique

    @Column(name = "expiration_date", nullable = false)
    @NonNull
    private String expirationDate;  // Expiration date of the card

    @Column(name = "cvv", nullable = false)
    @NonNull
    private String cvv; // CVV number of the card

    @Column(name = "is_default", nullable = false)
    private boolean isDefault; // If the card is the user's default card.

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // The user associated with this card

    @Override
    public String toString() {
        return id + " "
                + name + " "
                + cardNumber + " "
                + expirationDate + " "
                + cvv + " "
                + isDefault;
    }
}