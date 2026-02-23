import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private Map<Integer, User> users = new HashMap<>();

    public UserRepository() {
        // Sample data
        users.put(1, new User(1, "Gaurav"));
        users.put(2, new User(2, "Ravi"));
    }

    public Optional<User> findById(int id) {
        return Optional.ofNullable(users.get(id));
    }
}