package com.ProjectCollaboration.Platform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectCollaboration.Platform.Repository.LeaderLogRepository;
import com.ProjectCollaboration.Platform.model.Leaderlog;

@Service
public class LeaderLogService {
	
  @Autowired
  private LeaderLogRepository leaderlogrep;
  
  public void saveleaderLog(Leaderlog leaderlog) {
	  leaderlogrep.save(leaderlog);
  }
  
  

}
