package org.udlma.persistence;

import org.springframework.data.repository.CrudRepository;
import org.udlma.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

	
}
