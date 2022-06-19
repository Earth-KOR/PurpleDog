package purpledog.purpledog.TestPackage.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import purpledog.purpledog.TestPackage.Service.MemberTestService;
import purpledog.purpledog.TestPackage.model.MemberTest2;

@Controller
@RequiredArgsConstructor
public class MemberTestController {

    private final MemberTestService memberTestService;

    @PostMapping("insert-member")
    public String insertMember(@RequestParam String userId, @RequestParam String password, @RequestParam String phoneNumber, @RequestParam String address) {
        String saveMemberUserId = memberTestService.inertMemberView(userId, password, phoneNumber, address);
        return saveMemberUserId;
    }

    @GetMapping("view-member/{id}")
    public MemberTest2 getMember(@PathVariable Long id) throws Exception {
        MemberTest2 memberView = memberTestService.getMemberView(id);
        return memberView;
    }

    @PutMapping("update-member")
    public String updateMember() {
        return null;
    }

    @DeleteMapping("delete-member")
    public boolean deleteMember() {

        return true;
    }
}
