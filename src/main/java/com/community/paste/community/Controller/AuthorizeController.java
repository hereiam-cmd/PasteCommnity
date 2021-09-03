package com.community.paste.community.Controller;


import com.community.paste.community.DTO.AccessTokenDTO;
import com.community.paste.community.Provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("402a312524420728fa17");
        accessTokenDTO.setClient_secret("1ac6b5afe3662dac542d856de3a0c33d714bb2dd");
        accessTokenDTO.setRedirect_uri("https://localhost:8887/callback");
        accessTokenDTO.setState(state);

        githubProvider.getAccessToken(accessTokenDTO);
        return "index";

    }
}
