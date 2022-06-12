package com.invest.invesBlog.Controllers;


import com.invest.invesBlog.Entity.Comment;
import com.invest.invesBlog.Services.CommentService;
import com.invest.invesBlog.Services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {

  private final CommentService commentService;
  private final ApplicationUserService applicationUserService;

  @Autowired
  public CommentController(CommentService commentService, ApplicationUserService applicationUserService) {
    this.commentService = commentService;
    this.applicationUserService = applicationUserService;
  }

  @PostMapping("/comment/{id}")
  public String postComment(@ModelAttribute("newComment") Comment comment, @RequestParam("id") long id, HttpServletRequest request) {
    commentService.save(id, comment, applicationUserService.getCurrentUser(request));
    return "redirect:/viewpost/{id}";
  }

  @PostMapping("/reply/{postId}/{commentId}")
  public String replyToComment(@ModelAttribute("newComment") Comment comment,@PathVariable("postId") long postId, @PathVariable("commentId") long commentId, HttpServletRequest request){
    commentService.addReply(postId, comment,commentId,applicationUserService.getCurrentUser(request));
    return "redirect:/viewpost/"+postId;
  }

}
