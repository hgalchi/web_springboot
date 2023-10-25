package com.example.WebSpringboot.part05.security.service;

import com.example.WebSpringboot.part05.Entity.ClubMember;
import com.example.WebSpringboot.part05.Entity.ClubMemberRole;
import com.example.WebSpringboot.part05.repository.ClubMemberRepoistory;
import com.example.WebSpringboot.part05.security.dto.ClubAuthMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClubOauth2UserDetailService extends DefaultOAuth2UserService {

    private final ClubMemberRepoistory repoistory;
    private final PasswordEncoder passwordEncoder;



    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{

        log.info("----------------------------");
        log.info("userRequest :" + userRequest);

        String clientName = userRequest.getClientRegistration().getClientName();
        log.info("clientName:" + clientName);
        log.info(userRequest.getAdditionalParameters());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("==============================");
        oAuth2User.getAttributes().forEach((k,v)->{
            log.info(k + ":" + v);
        });

        String email = null;

        if (clientName.equals("Google")) {
            email = oAuth2User.getAttribute("email");
        }
        log.info("email:" + email);

        ClubMember member = saveSocialMember(email);

        ClubAuthMemberDTO clubAuthMember = new ClubAuthMemberDTO(
                member.getEmail(),
                member.getPassword(),
                true,
                member.getRoleSet().stream().map(r ->
                        new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList())
                , oAuth2User.getAttributes());

        clubAuthMember.setName(member.getName());

        return clubAuthMember;
    }

    private ClubMember saveSocialMember(String email) {
        Optional<ClubMember> result = repoistory.findByEmail(email, true);


        if (result.isPresent()) {
            return result.get();
        }
        ClubMember clubMember = ClubMember.builder()
                .name(email)
                .password(passwordEncoder.encode("1111"))
                .fromSocial(true)
                .build();

        clubMember.addMemberRole(ClubMemberRole.USER);

        repoistory.save(clubMember);
        return clubMember;
    }
}
