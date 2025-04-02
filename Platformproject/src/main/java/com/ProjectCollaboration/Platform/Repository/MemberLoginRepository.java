package com.ProjectCollaboration.Platform.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProjectCollaboration.Platform.model.MemberLogin;

@Repository
public interface MemberLoginRepository extends JpaRepository<MemberLogin,Integer> {
 Optional<MemberLogin> findByEmail(String email);
}
