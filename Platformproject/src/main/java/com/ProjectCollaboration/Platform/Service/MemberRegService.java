package com.ProjectCollaboration.Platform.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectCollaboration.Platform.Repository.MemberRegRepository;
import com.ProjectCollaboration.Platform.model.Leaderregister;
import com.ProjectCollaboration.Platform.model.MemberRegi;
import com.ProjectCollaboration.Platform.model.Project;

@Service
public class MemberRegService {
	
	@Autowired
	private MemberRegRepository memberregrepos;
	
	public Optional<MemberRegi> findByEmail(String email) {
        Optional<MemberRegi> member = memberregrepos.findByEmail(email);

        // Debugging: Print the result to console
        System.out.println("Checking email: " + email);
        System.out.println("Existing leader found: " + member.isPresent());

        return member;
    }

    public void saveMember(MemberRegi member) {
    	memberregrepos.save(member);
        System.out.println("New user registered: " + member.getEmail());
    }

	public boolean inviteMemberToProject(Project project, Long memberId) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
