package com.ProjectCollaboration.Platform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProjectCollaboration.Platform.model.Invitation;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    List<Invitation> findByMemberEmail(String email);
    Optional<Invitation> findById(Long id);
	Invitation findByToken(String token);
}
