package com.itimoshin.spring_cloud_mastering.auth.repository;

import com.itimoshin.spring_cloud_mastering.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
