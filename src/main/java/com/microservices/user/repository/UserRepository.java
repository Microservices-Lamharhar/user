package com.microservices.user.repository;

import com.microservices.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookingRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
