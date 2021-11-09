package de.codecentric.psd.worblehat.web.formdata;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/** This class represent the form data of the return book form. */
public class ReturnOneBookFormData {

  @NotEmpty(message = "{empty.returnOneBookFormData.emailAddress}")
  @Email(message = "{notvalid.returnOneBookFormData.emailAddress}")
  private String emailAddress;

  private String isbn;

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
