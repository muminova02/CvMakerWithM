//package uz.doublem.testsecurityspring.config;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Bean;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import uz.doublem.testsecurityspring.repository.UserRepository;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@RequiredArgsConstructor
//public class Config {
//    private final UserRepository userRepository;
//    private final MyFilter myFilter;
//
//
//    @Bean
//   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//       http
//               .authorizeHttpRequests(auth -> {
//                   auth.requestMatchers("/auth/**")
//                           .permitAll()
//
//                           .anyRequest()
//                           .authenticated();
//               })
//               .cors(cr -> cr.disable())
//               .csrf(c -> c.disable());
//       http.addFilterBefore(myFilter, UsernamePasswordAuthenticationFilter.class);
//       return http.build();
//   }
//
//   @Bean
//    public PasswordEncoder passwordEncoder() {
//       return new BCryptPasswordEncoder();
//   }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetailsService userDetailsService = username ->
//                userRepository.findByUsername(username).orElseThrow();
//        return userDetailsService;
//    }
//
//}
