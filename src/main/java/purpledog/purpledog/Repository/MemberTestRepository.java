package purpledog.purpledog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import purpledog.purpledog.Domain.Member;
import purpledog.purpledog.Domain.MemberTEst;

public interface MemberTestRepository extends JpaRepository<MemberTEst, Long> {
}
