package net.codejava.demo.sv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import net.codejava.demo.repository.UserRepository;
import net.codejava.demo.user.User;
@Service
public class UserServiceImpl {
	@Autowired
   private UserRepository userRepository;

   public User registerUser  (User user) {   
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
        	return user;
        }
        throw new RuntimeException("Invalid username or password");
    }
}
