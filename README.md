🌐 ConnectSphere - Project Collaboration Platform
Tech Stack
Frontend :
HTML, CSS, JavaScript – For building a user-friendly interface
Thymeleaf – Used for dynamic rendering of HTML templates

Backend :
Spring Boot – Framework for developing RESTful APIs
Hibernate – ORM framework for database interaction
MySQL – Database for storing user and project information
Java Mail Sender – Sends project invitations via email

Additional Integrations:
VS Code API – Enables collaborative coding within the platform
Slack API – Facilitates real-time team communication and notifications
Spring Boot REST API – Facilitates communication between frontend and backend

Project Modules
1️⃣ User Management
Team Leader and Team Members can register and log in securely.
Role-based access control: Team Leaders can create projects, while Team Members contribute.

2️⃣ Project Management
Team Leaders can create, update, delete, and manage multiple projects.
Team Members can be invited via email to join a project.

3️⃣ Task Management
Create To-Do lists and assign tasks to team members.
Tasks can be updated and tracked using CRUD operations.

4️⃣ Invitation System
Team Leaders can invite members via email (powered by Java Mail Sender).
Members can accept invitations and be redirected to the specific project page.

5️⃣ VS Code Integration
Members can collaborate on the project using the VS Code API directly within the platform.

6️⃣ Slack API Integration
Send real-time notifications for project updates to Slack channels.
Team members can communicate within a dedicated Slack workspace for better collaboration.

Implementation Flow:
User Registration & Login – Secure authentication for Team Leaders and Members.

Project Creation – Team Leaders can create projects and manage details.

Invite Members – Emails are sent using Java Mail Sender with a project-specific invitation link.

Task Assignment – Team Leaders can assign tasks, and members can track them.

VS Code Collaboration – Team Members can code within the platform using the VS Code API.

Slack Integration – Notifications are sent to Slack when tasks are created, updated, or completed.

Project & Task CRUD Operations – Users can perform Create, Read, Update, and Delete operations on projects and tasks.

Future Enhancements:
🔹 Real-time chat integration within the platform
🔹 Kanban-style task board for better visualization
🔹 File sharing & document collaboration
