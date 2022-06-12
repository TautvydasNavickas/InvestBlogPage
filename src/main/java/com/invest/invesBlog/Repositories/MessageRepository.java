package com.invest.invesBlog.Repositories;

import com.invest.invesBlog.Entity.ApplicationUser;
import com.invest.invesBlog.Entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
  List<Message> findAllByReceivingUser(ApplicationUser receivingUser);

  List<Message> findAllBySendingUser(ApplicationUser sendingUser);


  int countAllByUserReadIsFalseAndReceivingUserIs(ApplicationUser user);
}
