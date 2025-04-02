package com.ProjectCollaboration.Platform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProjectCollaboration.Platform.Repository.MemberRegRepository;
import com.ProjectCollaboration.Platform.model.MemberRegi;

import java.util.Optional;

@Service
public class MemberLoginService {

    @Autowired
    private MemberRegRepository memberregrepos;

    public Optional<MemberRegi> findByEmail(String email) {
        return memberregrepos.findByEmail(email);  // Ensure this method returns an Optional
    }
}
