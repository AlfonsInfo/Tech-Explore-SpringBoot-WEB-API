package com.bca.itworks.repository;

import com.bca.itworks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    Optional<Task> findById(UUID id);

    List<Task> findAll();
}
