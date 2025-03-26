package com.example.baitapnhomoop.config.filter;

import com.example.baitapnhomoop.entity.AppUser;
import com.example.baitapnhomoop.repository.AppUserRepo;
import com.example.baitapnhomoop.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    private final AppUserRepo appUserRepo;

    public JwtFilter(JwtUtil jwtUtil, AppUserRepo appUserRepo) {
        this.jwtUtil = jwtUtil;
        this.appUserRepo = appUserRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = resolveToken(request);
            if (token != null) {
                // Lấy username từ token:
                String username = jwtUtil.extractUsername(token);

                // Lấy userDetail thông qua username:

                AppUser appUser = appUserRepo.findByUsername(username);
                UserDetails userDetails = new User(appUser.getUsername(), appUser.getPassword(), appUser.getRoles());
                // Thực hiện việc xác thực thông qua token
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            } else {
                filterChain.doFilter(request, response);
            }
        } catch (Exception e) {
            logger.error("Can NOT set Can NOT set user authentication -> Message: {}", e);
        }
        filterChain.doFilter(request, response);
        filterChain.doFilter(request, response);
    }


    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.replace("Bearer ", "");
        }
        return null;
    }
}
