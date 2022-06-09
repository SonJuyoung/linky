package com.example.linky.config.security;

import com.example.linky.admin.model.AdminEntity;
import com.example.linky.admin.model.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final AdminRepository adminRepository;


    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        AdminEntity admin = adminRepository.findByUid(uid).orElseThrow(() ->
                new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + uid));

        return new CustomUserDetails(admin);
    }
}
