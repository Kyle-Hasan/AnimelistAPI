package com.example.animelist.Animelist.service;

import com.example.animelist.Animelist.Exception.UnauthorizedException;
import com.example.animelist.Animelist.Exception.UsernameException;
import com.example.animelist.Animelist.dto.SignupDto;
import com.example.animelist.Animelist.dto.UserProfilePageDTO;
import com.example.animelist.Animelist.entity.User;
import com.example.animelist.Animelist.repository.UserRepository;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (DuplicateKeyException e) {
            throw new UsernameException("username is taken");
        }
    }

    public void delete(String id) {
         userRepository.deleteById(id);
    }

    public User getById(String id) {
        Optional<User> query = this.userRepository.findById(id);
        return query.orElse(null);
    }

    public UserProfilePageDTO getByIdProfile(String id) {
        User user = getById(id);

        return null;
    }

    public User signup(SignupDto signupInfo) {
      String hashedPassword =   passwordEncoder.encode(signupInfo.password());
      User user = new User(signupInfo.username(),signupInfo.email(),hashedPassword);
      return save(user);
    }

    public User login(SignupDto loginDto) {
        User user = userRepository.userByUsername(loginDto.username());
        String hashedPassword = user.getPasswordHash();
        boolean matches = passwordEncoder.matches(loginDto.password(),hashedPassword);
        if(matches) {
            return user;
        }
        else {
            throw new UnauthorizedException("bad login");
        }
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
