package dachaja.idsProject;

import dachaja.idsProject.domain.member.Member;
import dachaja.idsProject.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {


    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        //기본 설정 -> DB 연결 전에 사용할 아이디와 비밀번호

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test");
        member.setName("test");

        memberRepository.save(member);


    }

}