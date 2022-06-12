package com.invest.invesBlog.Services;

import com.invest.invesBlog.Entity.ApplicationUser;
import com.invest.invesBlog.Entity.Message;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface MessageService {

  void sendMessage(String content, String targetUser, ApplicationUser currentUser);

  List<Message> findSentMessages(HttpServletRequest request);

  List<Message> findReceivedMessages(HttpServletRequest request);

  int countUnread(HttpServletRequest request);

  List<Message> findNewMessages(List<Message> receivedMessages);

  void markAllAsRead(List<Message> newMessages);
}
