package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// The @Controller annotation tells the Spring Framework this class is to be added into the Spring
// Context as a controller.
@Controller
public class AuthorController {

  private final AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @RequestMapping("/authors")
  public String getAuthors(Model model) {

    model.addAttribute("authors", authorRepository.findAll());

    return "authors/list";
  }
}
