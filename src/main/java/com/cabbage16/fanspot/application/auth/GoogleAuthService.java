package com.cabbage16.fanspot.application.auth;

import com.cabbage16.fanspot.domain.auth.exception.ExpiredGoogleIdTokenException;
import com.cabbage16.fanspot.domain.user.User;
import com.cabbage16.fanspot.infrastructure.auth.JwtProvider;
import com.cabbage16.fanspot.infrastructure.persistence.user.UserRepository;
import com.cabbage16.fanspot.presentation.auth.dto.request.GoogleAuthRequest;
import com.cabbage16.fanspot.presentation.auth.dto.response.TokenResponse;
import com.cabbage16.fanspot.shared.config.properties.GoogleOAuthProperties;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class GoogleAuthService {

    private final GoogleOAuthProperties googleOAuthProperties;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public TokenResponse execute(GoogleAuthRequest request) throws GeneralSecurityException, IOException {
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(googleOAuthProperties.getClientId()))
                .build();

        GoogleIdToken idToken = verifier.verify(request.idToken());

        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            String email = payload.getEmail();
            String name = (String) payload.get("name");

            User user = userRepository.findByEmail(email)
                    .orElseGet(() -> userRepository.save(new User(email, name)));

            return new TokenResponse(
                    jwtProvider.generateAccessToken(user.getUuid(), email, name),
                    jwtProvider.generateRefreshToken(user.getUuid())
            );
        } else {
            throw new ExpiredGoogleIdTokenException();
        }
    }
}
