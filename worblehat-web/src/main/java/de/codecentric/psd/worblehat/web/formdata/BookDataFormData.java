package de.codecentric.psd.worblehat.web.formdata;

import de.codecentric.psd.worblehat.web.validation.ISBN;
import de.codecentric.psd.worblehat.web.validation.Numeric;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/** This class represent the form data of the add book form. */
public class BookDataFormData {

  @NotEmpty(message = "{empty.bookDataFormData.title}")
  private String title;

  @NotEmpty(message = "{empty.bookDataFormData.edition}")
  @Numeric(message = "{empty.bookDataFormData.edition}")
  private String edition;

  @NotEmpty(message = "{notvalid.bookDataFormData.yearOfPublication}")
  @Numeric(message = "{notvalid.bookDataFormData.yearOfPublication}")
  @Min(message = "{notvalid.bookDataFormData.yearOfPublication}", value = 1000)
  private String yearOfPublication;

  @NotEmpty(message = "{notvalid.validate.isbn}")
  @ISBN(message = "{notvalid.validate.isbn}")
  private String isbn;

  @NotEmpty(message = "{empty.bookDataFormData.author}")
  private String author;

  public String getYearOfPublication() {
    return yearOfPublication;
  }

  public void setYearOfPublication(String yearOfPublication) {
    this.yearOfPublication = yearOfPublication;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  @Override
  public String toString() {
    return "BookDataFormData [title=" + title + ", edition=" + edition + ", yearOfPublication=" + yearOfPublication
        + ", isbn=" + isbn + ", author=" + author + "]";
  }
}
