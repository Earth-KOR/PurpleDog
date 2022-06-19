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
    public String inertMemberView(String userId, String password, String address, String phoneNumber) {
        MemberTest2 memberTest2 = new MemberTest2(userId, password, address, phoneNumber);
        MemberTest2 save = memberTestRepository.save(memberTest2);
        return save.getUserId();
    }
}
