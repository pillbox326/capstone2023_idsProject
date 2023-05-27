package dachaja.idsProject.domain.login;

import dachaja.idsProject.domain.member.Member;

import dachaja.idsProject.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginService { //로그인 기능

    private final MemberRepository memberRepository;

    /*
     * return null 이면 로그인 실패
     */
    public Member login(String loginId, String password) {


        //간단하게 만들기
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
