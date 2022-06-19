package purpledog.purpledog.TestPackage.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import purpledog.purpledog.TestPackage.Repository.MemberTest2Repository;
import purpledog.purpledog.TestPackage.model.MemberTest2;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberTestService {

    private final MemberTest2Repository memberTestRepository;

    @Transactional
    public MemberTest2 getMemberView(Long id) throws Exception {
        Optional<MemberTest2> memberTest = memberTestRepository.findById(id);
        MemberTest2 memberTest21 = memberTest.orElseThrow(Exception::new);
        return memberTest21;
    }

    @Transactional
    public MemberTest2 updateMember(Long id, String address) throws Exception {
        Optional<MemberTest2> memberTest = memberTestRepository.findById(id); // -> JPA Context 1차 캐싱 -> 여기에 이미 저장이 되어있음. ->
        MemberTest2 memberTest21 = memberTest.orElseThrow(Exception::new);
        memberTest21.updateAddress(address); // 업데이트를 -> 데이터가 바낌 -> @Transactional이 끝나는 시점에서 -> 1차 캐시 <-> 현재 데이터 비교를함 -> 내가 그냥 바꿔야징 ㅋ -> 바꿈~! -> Dirty Checking
//        memberTestRepository.save(memberTest21);
        // 1차 캐싱
        //
        return memberTest21;
    }

    @Transactional
    public void deleteMember(Long id) throws Exception {
        Optional<MemberTest2> memberTest = memberTestRepository.findById(id); // -> JPA Context 1차 캐싱 -> 여기에 이미 저장이 되어있음. ->
        MemberTest2 memberTest21 = memberTest.orElseThrow(Exception::new);
        memberTestRepository.delete(memberTest21);
    }

    @Transactional
    public String inertMemberView(String userId, String password, String address, String phoneNumber) {
        MemberTest2 memberTest2 = new MemberTest2(userId, password, address, phoneNumber);
        MemberTest2 save = memberTestRepository.save(memberTest2);
        return save.getUserId();
    }
}
