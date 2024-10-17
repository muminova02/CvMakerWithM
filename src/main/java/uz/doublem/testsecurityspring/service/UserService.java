//package uz.doublem.testsecurityspring.service;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import uz.doublem.testsecurityspring.entity.User;
//import uz.doublem.testsecurityspring.payload.ResponseTemplate;
//import uz.doublem.testsecurityspring.payload.UserDTO;
//import uz.doublem.testsecurityspring.repository.UserRepository;
//import uz.doublem.testsecurityspring.util.Mepper;
//
//import java.util.Base64;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
////    private final PasswordEncoder passwordEncoder;
//    private final Mepper mepper;
//
//    public ResponseTemplate save(UserDTO userDTO) {
//        if (userRepository.existsByUsername(userDTO.getUsername())) {
//            return getResp("This username already Exists",false,null);
//        }
//        User user = mepper.mepNewDtoToUser(userDTO);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        User userSave = userRepository.save(user);
//        return getResp("successfully saved user",true,userSave);
//    }
//
//
//    public ResponseTemplate getResp(String message, boolean success, Object data) {
//        return ResponseTemplate.builder().message(message).success(success).data(data).build();
//    }
//
//    public ResponseEntity<?> getStringResponseEntity(UserDTO userDTO) {
//        System.out.println(userDTO);
//        User user = userRepository.findByUsername(userDTO.getUsername()).orElseThrow(RuntimeException::new);
//        boolean matches = passwordEncoder.matches(userDTO.getPassword(), user.getPassword());
//        if (!matches){
//            throw new RuntimeException("Wrong password");
//        }
//        String username = user.getUsername();
//        String s = new String(Base64.getEncoder().encode(username.getBytes()));
//        return ResponseEntity.ok().body(s);
//    }
//}
