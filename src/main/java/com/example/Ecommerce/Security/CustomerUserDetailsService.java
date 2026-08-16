package com.example.Ecommerce.Security;

import com.example.Ecommerce.Constant.AppConstants.java.ErrorMessages;
import com.example.Ecommerce.Model.User;
import com.example.Ecommerce.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepo.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                ErrorMessages.INVALID_EMAIL_OR_PASSWORD));

        return new UserPrincipal(user);
    }
}