package com.inkhyang.userservice.oauth;


import com.inkhyang.userservice.entity.Role;
import com.inkhyang.userservice.entity.UserEntity;
import com.inkhyang.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);

        Map<String, Object> attributes = user.getAttributes();
        String email = (String) attributes.get("email");

        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);
        UserEntity dbUserEntity;
        if (optionalUser.isPresent()) {
            dbUserEntity = optionalUser.get();
        } else {
            String name = (String) attributes.get("name");
            dbUserEntity = new UserEntity(name, email, Set.of(Role.USER));
            userRepository.save(dbUserEntity);
        }
        return user;
    }
}
