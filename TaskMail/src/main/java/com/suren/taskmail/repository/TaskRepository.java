package com.suren.taskmail.repository;

import com.suren.taskmail.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
