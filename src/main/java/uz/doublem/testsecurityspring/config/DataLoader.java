//package uz.doublem.testsecurityspring.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import uz.doublem.testsecurityspring.entity.Role;
//import uz.doublem.testsecurityspring.entity.User;
//import uz.doublem.testsecurityspring.entity.UserRole;
//import uz.doublem.testsecurityspring.repository.UserRepository;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        securityUser();
//    }
//    private void securityUser()
//    {
//        String s = "admin-cha";
//
//        if (!userRepository.existsByUsername(s))
//        {
//            User user = new User();
//            user.setRole(new UserRole(Role.ADMIN));
//            user.setUsername(s);
//            user.setPassword(passwordEncoder.encode("root123"));
//            userRepository.save(user);
//        }
//
//    }
//}
