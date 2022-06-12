package com.invest.invesBlog.Repositories;

import com.invest.invesBlog.Entity.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
  ApplicationUser findByUsername(String username);

  boolean existsByUsername(String username);

  ApplicationUser findOneByUsername(String username);

  ApplicationUser findOneByEmail(String email);
}
