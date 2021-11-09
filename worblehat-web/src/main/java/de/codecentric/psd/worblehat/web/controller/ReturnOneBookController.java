package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.formdata.ReturnOneBookFormData;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/** Controller class for the */
@Controller
@RequestMapping("/returnOneBook")
public class ReturnOneBookController {

  private BookService bookService;

  @Autowired
  public ReturnOneBookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public void prepareView(ModelMap modelMap) {
    modelMap.put("returnOneBookFormData", new ReturnOneBookFormData());
  }

  @PostMapping
  public String returnAllBooks(
      @ModelAttribute("returnOneBookFormData") @Valid ReturnOneBookFormData formData,
      BindingResult result) {
    if (result.hasErrors()) {
      return "returnAllBooks";
    } else {
      bookService.returnOneBookByBorrower(formData.getEmailAddress(), formData.getIsbn());
      return "home";
    }
  }
}
