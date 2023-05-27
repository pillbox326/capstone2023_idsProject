package dachaja.idsProject.web.login;


import dachaja.idsProject.domain.login.LoginService;
import dachaja.idsProject.domain.member.Member;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form){
        return "login/loginForm";
    }

    //로그인 처리가 되는 로직
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }

        //성공한 로직
        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

        if(loginMember == null){ //안 맞는 경우
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
            //사용자가 다시 아이디와 비밀번호를 입력하게 한다.
        }

        //로그인 성공처리

        Cookie idCookie = new Cookie("memberId",String.valueOf(loginMember.getId())); //long -> String
        response.addCookie(idCookie); // 쿠키생성(세션쿠키)
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response){
        expireCookie(response, "memberId");
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String cookieName){
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
