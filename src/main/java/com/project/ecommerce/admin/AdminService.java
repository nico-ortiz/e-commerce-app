package com.project.ecommerce.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.exception.IdNotFoundException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin createAdmin(Admin admin) {
        Admin adminToSave = new Admin(admin.getName(), admin.getDni(), admin.getUsername(), admin.getEmail());
        return adminRepository.save(adminToSave);
    }

    public Admin deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id).
            orElseThrow(() -> new IdNotFoundException("Admin with id= " + id + " not found"));
        adminRepository.deleteById(id);
        return admin;
    }

}
