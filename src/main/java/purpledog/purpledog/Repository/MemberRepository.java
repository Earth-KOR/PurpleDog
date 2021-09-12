package purpledog.purpledog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import purpledog.purpledog.Domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
