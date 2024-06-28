package net.javaguides.springannotations.controller;

import net.javaguides.springannotations.beans.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/api")
public class BookController {

    @RequestMapping("/greeting")
//    @ResponseBody
    public String konnichiwa() {
        return "こんにちは";
    }

//    @RequestMapping(value={"/book", "/novel", "/paper-pack"}, method = RequestMethod.GET,
//        produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    @ResponseBody
//    @GetMapping(value={"/book", "/novel", "/paper-pack"})
    @GetMapping("/book")
    public Book getBook() {
        Book book = new Book(1, "Blood Moon", "This is the third part of the Ravenscliff series");
        return book;
    }

    @PostMapping("books/add")
    public ResponseEntity<Book>  createBook(@RequestBody  Book book) {
        System.out.println(book.getId());
        System.out.println(book.getTitle());
        System.out.println(book.getDescription());

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("books/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        System.out.println(id);
        book.setId(id);
        System.out.println(book.getTitle());
        System.out.println(book.getDescription());

        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @DeleteMapping("books/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
        String message = "Successfully removed the book with the " + id;
        System.out.println(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("books/pathvariable/{id}/{title}/{description}")
    public ResponseEntity<Book> pathVariableExample(@PathVariable("id") int id, @PathVariable("title") String title, @PathVariable("description") String description) {
        System.out.println("id: " + id + " title: " + title + " description: " + description);
        Book book = new Book(id, title, description);
//        book.setId(id);
        return ResponseEntity.ok(book);
    }

    //http://localhost:8080/api/books/reqparam/query?id=15&title=Hermione&description=smart girl
    @GetMapping("books/reqparam/query")
    public ResponseEntity<Book>RequestParametersExample(@RequestParam(name="id") int id, @RequestParam(name="title") String title, @RequestParam(name="description") String description) {
        System.out.println("id: " + id + " title: " + title + " description: " + description);
        Book book = new Book(id, title, description);
        return ResponseEntity.ok(book);
    }
}


