package com.invest.invesBlog.Controllers;

import com.invest.invesBlog.Entity.ApplicationUser;
import com.invest.invesBlog.Entity.VerificationToken;
import com.invest.invesBlog.Services.ApplicationUserService;
import com.invest.invesBlog.Services.VerificationService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

  private final ApplicationUserService applicationUserService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final VerificationService verificationService;

  public UserController(ApplicationUserService applicationUserService, BCryptPasswordEncoder bCryptPasswordEncoder, VerificationService verificationService) {
    this.applicationUserService = applicationUserService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    this.verificationService = verificationService;
  }

  @GetMapping("/register")
  public String register(Model model) {
    model.addAttribute("newUser", new ApplicationUser());
    return "register";
  }

  @GetMapping("/login")
  public String renderLoginPage(@RequestParam(value = "error", required = false) String error, Model model) {
    model.addAttribute("error", error);
    return "login";
  }

  @PostMapping("/signup")
  public String signUp(@ModelAttribute ApplicationUser user, @RequestParam(name = "confirm") String confirm, Model model, RedirectAttributes redirectAttributes) {
    List<String> errorMessages = applicationUserService.validateSignup(user,confirm);
    if (errorMessages.size() > 0) {
      model.addAttribute("errors", errorMessages);
      return "register";
    }
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    applicationUserService.save(user);
    verificationService.startValidation(user);
    redirectAttributes.addFlashAttribute("message", verificationService.getVerificationMessage(user));
    return "redirect:/login";
  }

  @GetMapping("/confirm/{token}")
  public String validateToken(@PathVariable(value = "token") String token, RedirectAttributes redirectAttributes) {
    if (verificationService.tokenExists(token)) {
      VerificationToken vToken = verificationService.verify(token);
      verificationService.deleteToken(token);
      redirectAttributes.addFlashAttribute("message", verificationService.getVerificationMessage(vToken.getUser()));
    } else {
      redirectAttributes.addFlashAttribute("message", verificationService.getVerificationError());
    }
    return "redirect:/login";
  }

}
