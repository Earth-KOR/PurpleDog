package purpledog.purpledog.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import purpledog.purpledog.DTO.MemberDeleteDto;
import purpledog.purpledog.DTO.MemberSaveRequestDto;
import purpledog.purpledog.DTO.MemberUpdatePasswordDto;
import purpledog.purpledog.Domain.Member;
import purpledog.purpledog.Repository.MemberRepository;
import purpledog.purpledog.exception.AlreadyExistException;
import purpledog.purpledog.exception.NoExistException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public boolean joinMember(MemberSaveRequestDto member) throws Exception {

        boolean findMember = memberRepository.findById(member.getId()).isPresent();

        if(findMember) {
            throw new AlreadyExistException("이미 존재하는 아이디 입니다");
        }

        Member newMember = new Member(member.getId(), member.getPassword());

        memberRepository.save(newMember);

        return true;
    }

    @Override
    public boolean updateMember(MemberUpdatePasswordDto member) throws Exception {

        Member findMember = memberRepository.findById(member.getId()).orElseThrow(() -> new NoExistException("존재하지 않는 아이디 입니다."));

        Member changeMember = new Member(findMember.getId(), member.getPassword());

        memberRepository.save(changeMember);

        return true;
    }

    @Override
    public String deleteMember(MemberDeleteDto member) throws Exception {

        Member findMember = memberRepository.findById(member.getId()).orElseThrow(() -> new NoExistException("존재하지 않는 아이디 입니다."));

        memberRepository.delete(findMember);

        return member.getId();
    }
}
