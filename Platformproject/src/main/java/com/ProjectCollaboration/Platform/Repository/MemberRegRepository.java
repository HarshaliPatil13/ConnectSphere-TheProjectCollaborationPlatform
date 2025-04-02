package com.ProjectCollaboration.Platform.Repository;

import java.lang.reflect.Member;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProjectCollaboration.Platform.model.MemberRegi;

@Repository
public interface MemberRegRepository extends JpaRepository<MemberRegi,Integer>{
	Optional<MemberRegi> findByEmail(String email);
}
