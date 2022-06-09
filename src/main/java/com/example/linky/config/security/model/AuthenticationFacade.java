package com.example.linky.config.security.model;

import com.example.linky.admin.model.AdminEntity;
import com.example.linky.admin.model.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    @Autowired private AdminRepository adminRepository;

    public AdminEntity getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String uid = auth.getName();

        AdminEntity data = adminRepository.findByUid(uid).get();
        if(data == null) {
            AdminEntity admin = new AdminEntity();
            admin.setId(0);
            return admin;
        }

        return data;
    }

    public boolean isAdmin() {
        boolean isAdmin = false;
        int id = getLoginUser().getId();
        if(id > 0) { isAdmin = true; }

        return isAdmin;
    }
}
