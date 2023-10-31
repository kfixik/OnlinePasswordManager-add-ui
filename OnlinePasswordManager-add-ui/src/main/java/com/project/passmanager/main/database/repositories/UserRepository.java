package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.database.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long>{
    User findByUsername(String username);


}
