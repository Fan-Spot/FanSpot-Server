package com.cabbage16.fanspot.presentation.auth;

import com.cabbage16.fanspot.application.auth.GoogleAuthService;
import com.cabbage16.fanspot.presentation.auth.dto.request.GoogleAuthRequest;
import com.cabbage16.fanspot.presentation.auth.dto.response.TokenResponse;
import com.cabbage16.fanspot.shared.response.CommonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final GoogleAuthService googleAuthService;

    @PostMapping("/google")
    public ResponseEntity<CommonResponse<TokenResponse>> authWithGoogle(
            @RequestBody @Valid GoogleAuthRequest request
    ) {
        TokenResponse response = googleAuthService.execute(request);

        return ResponseEntity.ok(CommonResponse.ok(response));
    }
}
