package com.example.demo.Users;

import org.springframework.data.repository.CrudRepository;

// Spring automatically implements this repository interface in a bean that has the same name (with a change in the case — it is called userRepository).
public interface UsersRepository extends CrudRepository<Users,Integer> {
}
