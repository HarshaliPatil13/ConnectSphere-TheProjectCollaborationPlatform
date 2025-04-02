package com.ProjectCollaboration.Platform.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invitations")
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String token; 

    @ManyToOne
    @JoinColumn(name = "leader_id", nullable = false)
    private Leaderregister leader;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private MemberRegi member;

    @Column(nullable = false)
    private String projectName; // Name of the project

    @Column(nullable = false)
    private String status; // Pending, Accepted, Declined

    public Invitation(String email, String projectName2, String token, String string) {}

    public Invitation(Leaderregister leader, MemberRegi member, String projectName, String status) {
        this.leader = leader;
        this.member = member;
        this.projectName = projectName;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Leaderregister getLeader() { return leader; }
    public MemberRegi getMember() { return member; }
    public String getProjectName() { return projectName; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
