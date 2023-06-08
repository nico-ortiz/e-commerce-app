package com.project.ecommerce.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping()
    public ResponseEntity<List<Admin>> getAdmins() {
        return ResponseEntity.ok(adminService.getAdmins());
    }

    @PostMapping()
    public ResponseEntity<Admin> createAdmin(@RequestBody @Valid Admin admin) {
        return new ResponseEntity<Admin>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }
}
