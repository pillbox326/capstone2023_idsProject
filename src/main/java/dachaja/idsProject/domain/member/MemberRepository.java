package dachaja.idsProject.domain.member;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;

    public Member save(Member member){
        member.setId(++sequence);
        log.info("save: member={}",member);
        store.put(member.getId(),member);

        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId){

        return findAll().stream()
                .filter(m->m.getLoginId().equals(loginId))
                .findFirst();


    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        //test에서 초기화 용
        store.clear();
    }


}
