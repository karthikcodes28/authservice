package Service;

import Dto.LoginRequest;
import Dto.RegisterRequest;
import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public String registerUser(RegisterRequest registerRequest){

        User user=new User();
        user.setEmail(registerRequest.getEmail());
        user.setName(registerRequest.getName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        userRepository.save(user);
        return "user is registered succesfully";


    }

    public String loginUser(LoginRequest loginRequest){
        String email=loginRequest.getEmail();
        String password=loginRequest.getPassword();
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User is not found/Invalid credentials"));
        if(!passwordEncoder.matches(user.getPassword(),password)){
            throw new RuntimeException("Invalid credentials");
        }
        return "Login Succesful";
    }
}
