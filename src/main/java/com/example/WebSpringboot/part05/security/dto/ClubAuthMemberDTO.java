package com.example.WebSpringboot.part05.security.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class ClubAuthMemberDTO extends User implements OAuth2User {

   /* public ClubAuthMemberDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }*/

    private String email;
    private String name;
    private boolean fromSocial;
    private String password;
    private Map<String,Object> attr;


    public ClubAuthMemberDTO(
            String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities
    ) {
        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;
        this.password = password;
    }
    public ClubAuthMemberDTO(
            String username, String password, boolean fromSocial, Collection<? extends GrantedAuthority> authorities,
            Map<String,Object> attr
    ) {
        super(username, password, authorities);
        this.attr = attr;
    }




    @Override
    public Map<String, Object> getAttributes() {
        return this.attr;
    }
}
