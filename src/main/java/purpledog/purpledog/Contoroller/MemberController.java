package purpledog.purpledog.Contoroller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import purpledog.purpledog.DTO.MemberDeleteDto;
import purpledog.purpledog.DTO.MemberSaveRequestDto;
import purpledog.purpledog.DTO.MemberUpdatePasswordDto;
import purpledog.purpledog.Service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("members/create")
    @ResponseBody
    public boolean saveMember(
            @RequestBody MemberSaveRequestDto member) throws Exception {
      return memberService.joinMember(member);
    }

    @PutMapping("members/update")
    @ResponseBody
    public boolean updateMemberPassword(
            @RequestBody MemberUpdatePasswordDto member) throws Exception {
        return memberService.updateMember(member);
    }

    @DeleteMapping("members/delete")
    @ResponseBody
    public String deleteMember(
            @RequestBody MemberDeleteDto member) throws Exception {
        return memberService.deleteMember(member);
    }
}