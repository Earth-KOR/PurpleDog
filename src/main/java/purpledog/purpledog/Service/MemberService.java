package purpledog.purpledog.Service;

import purpledog.purpledog.DTO.MemberDeleteDto;
import purpledog.purpledog.DTO.MemberSaveRequestDto;
import purpledog.purpledog.DTO.MemberUpdatePasswordDto;

public interface MemberService {

    boolean joinMember(MemberSaveRequestDto member) throws Exception;

    boolean updateMember(MemberUpdatePasswordDto member) throws Exception;

    String deleteMember(MemberDeleteDto member) throws Exception;
}
