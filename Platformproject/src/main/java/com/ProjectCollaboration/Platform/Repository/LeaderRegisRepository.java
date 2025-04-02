package com.ProjectCollaboration.Platform.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProjectCollaboration.Platform.model.Leaderregister;

@Repository
public interface LeaderRegisRepository extends JpaRepository<Leaderregister,Long>{
	Optional<Leaderregister> findByEmail(String email);

	
}
