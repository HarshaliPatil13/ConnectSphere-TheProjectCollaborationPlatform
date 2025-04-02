package com.ProjectCollaboration.Platform.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProjectCollaboration.Platform.model.Leaderregister;
import com.ProjectCollaboration.Platform.Repository.LeaderRegisRepository;
import java.util.Optional;

@Service
public class LeaderregisService {

    @Autowired
    private LeaderRegisRepository leaderRepo;

    public Optional<Leaderregister> findByEmail(String email) {
        Optional<Leaderregister> leader = leaderRepo.findByEmail(email);

        // Debugging: Print the result to console
        System.out.println("Checking email: " + email);
        System.out.println("Existing leader found: " + leader.isPresent());

        return leader;
    }

    public void saveLeader(Leaderregister leader) {
        leaderRepo.save(leader);
        System.out.println("New user registered: " + leader.getEmail());
    }
}
