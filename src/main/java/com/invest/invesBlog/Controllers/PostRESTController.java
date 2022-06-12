package com.invest.invesBlog.Controllers;

import com.invest.invesBlog.Entity.ApplicationUser;
import com.invest.invesBlog.Entity.Post;
import com.invest.invesBlog.Entity.PostDTO;
import com.invest.invesBlog.Services.ApplicationUserService;
import com.invest.invesBlog.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class PostRESTController {

  private final PostService postService;
  private final ApplicationUserService applicationUserService;

  @Autowired
  public PostRESTController(PostService postService, ApplicationUserService applicationUserService) {
    this.postService = postService;
    this.applicationUserService = applicationUserService;
  }

  @GetMapping("/allposts")
  private ResponseEntity<?> getAllPosts() {
    System.out.println("hi");
    return ResponseEntity.status(HttpStatus.OK)
        .body(postService.getAllPostsDTO());
  }

  @PostMapping("/newpost")
  private ResponseEntity<?> newPost(@RequestBody Post post, HttpServletRequest req) {
    if (req != null && post != null) {
      ApplicationUser user = postService.setUser(post, req);
      if (user != null) {
        postService.setDate(post);
        postService.save(post);
        return ResponseEntity.status(HttpStatus.OK)
            .body("Post successfully added!");
      }
    }
    return ResponseEntity.status(HttpStatus.FORBIDDEN)
        .body("Posting unsuccesful!");
  }

  @PostMapping("/multiplepost")
  private void addMultiplePosts(@RequestBody PostDTO postDTO, HttpServletRequest req) {
    if (postDTO != null && req != null) {
      ApplicationUser user = applicationUserService.getCurrentUser(req);
      if (user != null) {
        postService.savePostsFromDTO(postDTO, user);
      }
    }
  }

  @DeleteMapping("/delete/{id}")
  private ResponseEntity<?> deletePost(@PathVariable(value="id") Long id, HttpServletRequest req){
    if (postService.deletePost(id,req)){
      return ResponseEntity.status(HttpStatus.OK)
          .body("Post successfully deleted!");
    }
    else return ResponseEntity.status(HttpStatus.FORBIDDEN)
        .body("Could not delete post!");
  }


}
