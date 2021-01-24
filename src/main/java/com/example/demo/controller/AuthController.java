package com.example.demo.controller;

import com.example.demo.api.github.Github;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthController {
    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @Autowired
    Github github;

    @GetMapping(value = "/auth/index")
    public String index() {
        log.info(SecurityContextHolder.getContext().getAuthentication().toString());
//        return "Welcome " + SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Welcome " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    @GetMapping(value = "/auth/reg")
    public String registration() {
        ClientRegistration githubRegistration = this.clientRegistrationRepository.findByRegistrationId("github");
        log.info(githubRegistration.toString());
        return githubRegistration.toString();
    }

    @GetMapping(value = "/auth/token")
    public OAuth2AccessToken accessToken(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(), authentication.getName());
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        return accessToken;
    }

    @GetMapping(value = "/auth/info")
    public String info() {
        String profile = github.getProfile();
        log.info(github.getProfile());
        return profile;
    }
}
