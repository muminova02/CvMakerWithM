//package uz.doublem.testsecurityspring.controller;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import uz.doublem.testsecurityspring.entity.User;
//import uz.doublem.testsecurityspring.payload.ResponseTemplate;
//import uz.doublem.testsecurityspring.payload.UserDTO;
//import uz.doublem.testsecurityspring.repository.UserRepository;
////import uz.doublem.testsecurityspring.service.UserService;
//
//import java.util.Base64;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/auth")
//public class UserController {
////    private final UserService userService;
//    private final UserRepository userRepository;
//
//    @PostMapping("/sign-up")
//    public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO) {
////        ResponseTemplate resp =  userService.save(userDTO);
//        return ResponseEntity.status(resp.getSuccess()?200:400).body(resp);
//    }
//
//    @PostMapping("/sign-in")
//    public ResponseEntity<?> signIn(@RequestBody UserDTO userDTO) {
////        return userService.getStringResponseEntity(userDTO);
//    }
//
//
//
//
//}
