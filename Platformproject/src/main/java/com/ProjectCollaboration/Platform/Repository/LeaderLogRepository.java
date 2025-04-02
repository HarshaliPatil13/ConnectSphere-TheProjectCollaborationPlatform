package com.ProjectCollaboration.Platform.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProjectCollaboration.Platform.model.Leaderlog;

@Repository
public interface LeaderLogRepository extends JpaRepository<Leaderlog,Integer>{
	Optional<Leaderlog> findByEmail(String email);

}
