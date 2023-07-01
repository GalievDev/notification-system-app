package dev.galiev.notificationsystem.services.impl;

import dev.galiev.notificationsystem.auth.AuthenticationRequest;
import dev.galiev.notificationsystem.auth.AuthenticationResponse;
import dev.galiev.notificationsystem.auth.RegisterRequest;
import dev.galiev.notificationsystem.models.Role;
import dev.galiev.notificationsystem.models.User;
import dev.galiev.notificationsystem.repository.UsersRep;
import dev.galiev.notificationsystem.services.JwtService;
import dev.galiev.notificationsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UsersRep usersRep;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .role(Role.USER)
                .password(request.getPassword())
                .subscriptions(Set.of())
                .build();

        usersRep.save(user);
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = usersRep.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
