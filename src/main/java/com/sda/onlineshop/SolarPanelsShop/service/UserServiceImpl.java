package com.sda.onlineshop.solarpanelsshop.service;

import com.sda.onlineshop.solarpanelsshop.model.constant.UserRole;
import com.sda.onlineshop.solarpanelsshop.model.User;
import com.sda.onlineshop.solarpanelsshop.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void createUser(
            String email,
            String password,
            UserRole role,
            String name,
            String phoneNumber
    ) {
        User user = new User(
                name,
                email,
                passwordEncoder.encode(password),
                role,
                phoneNumber
        );
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Wrong username or password");
        }
        User user = userOptional.get();
        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole().name()))
        );
    }
}
