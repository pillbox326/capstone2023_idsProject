package dachaja.idsProject.web.member;


import dachaja.idsProject.domain.member.Member;
import dachaja.idsProject.domain.member.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    //의존관계주입
    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member){ //import 주의하기
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "members/addMemberForm";
            //문제가 있는 경우 addMemberForm으로 보낸다.
        }

        //문제 없는 경우
        memberRepository.save(member);
        return "redirect:/";

    }
}
