package com.example.baitapnhomoop.config;

import com.example.baitapnhomoop.repository.AppUserRepo;
import com.example.baitapnhomoop.repository.RoleRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringConfig {

    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public SpringConfig(AppUserRepo appUserRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

//    @PostConstruct
//    public void initApp() {
//        List<AppRole> appRoles = roleRepo.findAll();
//        if (appRoles.isEmpty()) {
//            List<AppRole> appRoleList = List.of(
//                    new AppRole("USER"),
//                    new AppRole("ADMIN")
//            );
//            appRoles = roleRepo.saveAll(appRoleList);
//        }
//
//        AppUser user = appUserRepo.findByUsername("admin");
//        if (user == null) {
//            user = new AppUser();
//            user.setUsername("admin");
//            user.setPassword(passwordEncoder.encode("admin"));
//            user.setRoles(new HashSet<>(appRoles));
//            appUserRepo.save(user);
//        }
//    }
}
