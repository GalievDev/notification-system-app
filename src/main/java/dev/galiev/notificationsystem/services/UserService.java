package dev.galiev.notificationsystem.services;

import dev.galiev.notificationsystem.auth.AuthenticationRequest;
import dev.galiev.notificationsystem.auth.AuthenticationResponse;
import dev.galiev.notificationsystem.auth.RegisterRequest;

public interface UserService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
