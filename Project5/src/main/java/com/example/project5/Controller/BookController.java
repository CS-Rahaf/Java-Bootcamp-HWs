package com.example.project5.Controller;

import com.example.project5.Model.Book;
import com.example.project5.Service.BookService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apis/v1/books")
public class BookController {


    private final BookService bookService;



    @GetMapping("")
    public ResponseEntity getBooks(){
        List<Book> books= bookService.getBooks();

        return ResponseEntity.status(200).body(books);
    }

    //First required endpoint
    @GetMapping("/{id}")
    public ResponseEntity getBook(@PathVariable Integer id){
        Book book= bookService.getBook(id);

        return ResponseEntity.status(200).body(book);
    }

    @PostMapping("")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book book){

        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body("Book has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book has been deleted Successfully");
    }


    @PostMapping("/assign")
    public ResponseEntity assignBookToStore(@Valid @RequestBody ObjectNode objectNode){
        bookService.assignBookToStore(objectNode);
        return ResponseEntity.status(200).body("Book has been assigned to store Successfully");
    }

    @GetMapping("/{bookId}/number")
    public ResponseEntity getNumberOfBook(@PathVariable Integer bookId){
        int numberOfBook= bookService.getNumberOfBook(bookId);
        return ResponseEntity.status(200).body("The number of copies of this book are: " + numberOfBook);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getBook(@PathVariable String name){
        Book book= bookService.findBookByName(name);
        return ResponseEntity.status(200).body(book);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity findBooksByGenre(@PathVariable String genre){
        List<Book> books = bookService.findBooksByGenre(genre);
        return ResponseEntity.status(200).body(books);
    }



}
