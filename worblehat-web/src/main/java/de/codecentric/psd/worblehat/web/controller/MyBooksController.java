package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.domain.Borrowing;
import de.codecentric.psd.worblehat.web.formdata.ShowMyBooksFormData;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Controller class for the book table result. */
@Controller
@RequestMapping("/myBooks")
public class MyBooksController {

  private BookService bookService;
  private String borrower;

  @Autowired
  public MyBooksController(BookService bookService) {
    this.bookService = bookService;
    // this.borrower = getBorrower();
  }

  @RequestMapping("/myBooks/{borrower}")
  public String getBorrower(@PathVariable String borrower) {
      return borrower;
  }



  @GetMapping
  public String setupForm(ModelMap modelMap) {
    List<Book> books = bookService.findAllBooksByBorrower(this.borrower);
    modelMap.addAttribute("books", books);
    modelMap.put("showMyBooksFormData", new ShowMyBooksFormData());
    return "myBooks";
  }
  

  @PostMapping
  public String showMyBooks(
      @ModelAttribute("showMyBooksFormData") @Valid ShowMyBooksFormData formData,
      BindingResult result) {
    if (result.hasErrors()) {
      return "myBooks";
    } else {
        this.borrower = formData.getEmailAddress();
      return "myBooks/"+this.borrower;
    }
  }
}
