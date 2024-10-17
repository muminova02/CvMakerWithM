//package uz.doublem.testsecurityspring.config;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Base64;
//
//@Component
//@RequiredArgsConstructor
//public class MyFilter extends OncePerRequestFilter {
//    @Autowired
//    @Lazy
//    private UserDetailsService userDetailsService;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            String authorization = request.getHeader("Authorization");
//            if (authorization!=null) {
//                System.out.println("this is auth "+authorization);
//                String username = new String(Base64.getDecoder().decode(authorization));
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
//                        userDetails,null,userDetails.getAuthorities()
//                );
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
////        if (auth.startsWith("Bearer ")) {
////            auth = auth.substring(8);
////            String username = "auth ichidagi username olinishi kerak!";
////            setAuthenticationToContext(username,"password");
////        }
//        }catch (Exception e){
//        }
////
//        filterChain.doFilter(request, response);
//    }
//}
