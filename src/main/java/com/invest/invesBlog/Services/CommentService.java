package com.invest.invesBlog.Services;

import com.invest.invesBlog.Entity.Comment;
import com.invest.invesBlog.Entity.ApplicationUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
  Comment save(long id, Comment comment, ApplicationUser user);
  List<Comment> findByContent(String searchTerm);
  void addReply(long postId, Comment comment, long commentId, ApplicationUser currentUser);
}
