package com.example.chatapp.service;

import com.example.chatapp.dto.reponse.AuthenticationReponse;
import com.example.chatapp.dto.reponse.IntrospectReponse;
import com.example.chatapp.dto.request.AuthenticationRequest;
import com.example.chatapp.dto.request.IntrospectRequest;
import com.example.chatapp.mapper.UserMapper;
import com.example.chatapp.model.User;
import com.example.chatapp.model.UserExample;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    PasswordEncoder passwordEncoder;
    UserMapper userMapper;
    JwtService jwtService;

    public AuthenticationReponse authenticate(AuthenticationRequest request) {
        // Lấy user theo email
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(request.getEmail());
        List<User> users = userMapper.selectByExample(example);

        if (users.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = users.get(0);

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Tạo token và trả response
        String token = jwtService.generateToken(user);
        return AuthenticationReponse.builder()
                .token(token)
                .Authenticated(true)
                .build();
    }

    public IntrospectReponse introspectReponse(IntrospectRequest request) {
        boolean isValid = jwtService.isTokenValid(request.getToken());
        return IntrospectReponse.builder()
                .valid(isValid)
                .build();
    }
}
