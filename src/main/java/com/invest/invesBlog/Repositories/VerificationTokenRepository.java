package com.invest.invesBlog.Repositories;

import com.invest.invesBlog.Entity.ApplicationUser;
import com.invest.invesBlog.Entity.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Long> {

  VerificationToken findByToken(String token);

  VerificationToken findByUser(ApplicationUser user);

  @Transactional
  void deleteByToken(String token);
}
