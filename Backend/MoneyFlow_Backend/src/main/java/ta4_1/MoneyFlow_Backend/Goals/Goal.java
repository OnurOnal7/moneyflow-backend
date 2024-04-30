package ta4_1.MoneyFlow_Backend.Goals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ta4_1.MoneyFlow_Backend.Users.User;
import java.util.UUID;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "goal_string")
    private String goalString;

    @Column(name = "amount")
    private double amount;  // The financial target of the goal

    @Column(name = "time_frame")
    private int timeFrame;  // The timeframe in months

    @Column(name = "is_completed")
    private boolean isCompleted;  // Status of the goal

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Goal() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGoalString() {
        return goalString;
    }

    public void setGoalString(String goalString) {
        this.goalString = goalString;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(int timeFrame) {
        this.timeFrame = timeFrame;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
