package com.example.WebSpringboot.part05.controller;

import com.example.WebSpringboot.part05.security.dto.ClubAuthMemberDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/all")
    @PreAuthorize("permitAll()")
    @ResponseBody
    public String exAll() {
        System.out.println("all");
        return "All";
    }

    @GetMapping("/member")
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public String exmember(@AuthenticationPrincipal ClubAuthMemberDTO clubAuthMember) {
        log.info("exMember..........................");
        log.info(clubAuthMember);
        return "member";
    }

    @GetMapping("/admin")
    @PreAuthorize("#clubAuthMember!=null && #clubAuthMember.username eq \"user90@naver.com\"")
    public void exadmin() {

        log.info("exadmin...");
    }


}

