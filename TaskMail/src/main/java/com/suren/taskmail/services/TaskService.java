package com.suren.taskmail.services;

import com.suren.taskmail.model.Task;
import com.suren.taskmail.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final EmailService emailService;

    @Autowired
    public TaskService(TaskRepository taskRepository, EmailService emailService) {
        this.taskRepository = taskRepository;
        this.emailService = emailService;
    }

    public Task saveTask(Task task) {
        Task savedTask = taskRepository.save(task);
        sendTaskAssignmentEmail(savedTask.getEmail(), savedTask.getDescription());
        return savedTask;
    }

    private void sendTaskAssignmentEmail(String toEmail, String taskDescription) {
        String subject = "New Task Assigned";
        String body = "Dear Student,\n\nA new task has been assigned to you:\n\n" + taskDescription + "\n\nPlease review and complete the task.\n\nRegards,\nSKCT";
        emailService.sendSimpleEmail(toEmail, subject, body);
    }
}
