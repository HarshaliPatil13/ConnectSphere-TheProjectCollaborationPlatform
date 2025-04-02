package com.ProjectCollaboration.Platform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import com.ProjectCollaboration.Platform.Service.*;
import com.ProjectCollaboration.Platform.model.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class LeaderController {

    @Autowired
    private LeaderregisService leaderService;

    @Autowired
    private MemberRegService memberService;

    @Autowired
    private MemberLoginService memberLoginService;

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private TaskService taskService;

    @GetMapping("frontpage")
    public String showFrontPage() {
        return "Frontpage";
    }

    @GetMapping("leader/register")
    public String showLeaderRegisterPage() {
        return "leaderregister";
    }

    @PostMapping("leader/register")
    public String registerLeader(@RequestParam String name, @RequestParam String email, 
                                 @RequestParam String password, Model model) {
        if (leaderService.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Email already exists! Please login.");
            return "leaderregister";
        }
        leaderService.saveLeader(new Leaderregister(0, name, email, password));
        return "redirect:/leader/login";
    }

    @GetMapping("leader/login")
    public String showLeaderLoginPage() {
        return "leaderlogin";
    }

    @PostMapping("leader/login")
    public String loginLeader(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Optional<Leaderregister> leader = leaderService.findByEmail(email);
        if (leader.isEmpty() || !leader.get().getPassword().equals(password)) {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "leaderlogin";
        }
        session.setAttribute("leader", leader.get());
        return "redirect:/leader/createnewproject";
    }

    @GetMapping("leader/createnewproject")
    public String showCreateNewProjectPage(Model model) {
        model.addAttribute("project", new Project());
        return "createnewproject";
    }

    @PostMapping("leader/createnewproject")
    public String createNewProject(@ModelAttribute("project") Project project, HttpSession session, Model model) {
        Leaderregister leader = (Leaderregister) session.getAttribute("leader");
        if (leader == null) {
            model.addAttribute("error", "Session expired. Please log in again.");
            return "redirect:/leader/login";
        }
        project.setLeaderId(leader.getId());
        projectService.saveProject(project);
        session.setAttribute("currentProjectId", project.getId());
        return "redirect:/leader/projectdetails?id=" + project.getId();
    }

    @GetMapping("leader/projectdetails")
    public String showProjectDetails(@RequestParam("id") Long projectId, Model model, HttpSession session) {
        Optional<Project> projectOpt = projectService.findById(projectId);
        if (projectOpt.isEmpty()) {
            model.addAttribute("error", "Project not found.");
            return "redirect:/leader/createnewproject";
        }
        model.addAttribute("project", projectOpt.get());
        model.addAttribute("tasks", taskService.getTasksByProjectId(projectId));
        session.setAttribute("currentProjectId", projectId);
        return "projectdetails";
    }

    @PostMapping("leader/invite")
    public String inviteMember(@RequestParam String email, @RequestParam Long projectId, Model model) {
        Optional<Project> projectOpt = projectService.findById(projectId);
        if (projectOpt.isEmpty()) {
            model.addAttribute("error", "Project not found.");
            return "redirect:/leader/projectdetails?id=" + projectId;
        }
        String invitationLink = "http://localhost:8080/member/accept-invitation?email=" + email + "&projectId=" + projectId;
        invitationService.sendInvitationEmail(email, "Project Invitation",
                "You have been invited to collaborate on the project: " + projectOpt.get().getName() +
                        ". Click <a href='" + invitationLink + "'>here</a> to join.");
        model.addAttribute("success", "Invitation sent successfully!");
        return "redirect:/leader/projectdetails?id=" + projectId;
    }
}