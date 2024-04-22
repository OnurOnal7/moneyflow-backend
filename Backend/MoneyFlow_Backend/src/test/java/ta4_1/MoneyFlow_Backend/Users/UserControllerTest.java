package ta4_1.MoneyFlow_Backend.Users;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Annotate the class to use WebMvcTest for only UserController
@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    // Autowire MockMvc to inject a simulated environment for performing requests
    @Autowired
    private MockMvc mockMvc;

    // MockBean for UserRepository to bypass the actual database interactions
    @MockBean
    private UserRepository userRepository;

    // MockBean for BCryptPasswordEncoder since it's used in the controller
    @MockBean
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
        // Assuming you have a mock user that you'd like to reuse in several tests
        User mockUser = new User("John", "Doe", "password", "john@example.com", 5000.0, 60000.0);
        mockUser.setId(UUID.randomUUID());

        // Set up common mock behavior
        when(userRepository.findById(any(UUID.class))).thenReturn(Optional.of(mockUser));
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
    }

    @Test
    void testGetUsersByType() throws Exception {
        // Arrange
        String userType = "regular";
        User user1 = new User();
        user1.setId(UUID.randomUUID());
        User user2 = new User();
        user2.setId(UUID.randomUUID());

        List<User> expectedUsers = Arrays.asList(user1, user2);
        when(userRepository.findByType(userType)).thenReturn(expectedUsers);

        // Act & Assert
        mockMvc.perform(get("/users/type/{userType}", userType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Expecting 2 users in the response
    }




}
