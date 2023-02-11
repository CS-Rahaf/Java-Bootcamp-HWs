package com.example.project5.Service;


import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Store;
import com.example.project5.Repository.BookRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {


    private final BookRepository bookRepository;
    private final StoreService storeService;


    public List<Book> getBooks(){
        return bookRepository.findAll();
    }


    public Book getBook(Integer id){
        Book Book = bookRepository.findBookById(id);
        if(Book==null){
            throw new ApiException("Book not found");
        }

        return Book;
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void updateBook(Integer id, Book book){
        Book currentBook = bookRepository.findBookById(id);
        if(currentBook==null){
            throw new ApiException("Book not found");
        }

        book.setId(currentBook.getId());
        bookRepository.save(book);
    }

    public void deleteBook(Integer id){
        Book currentBook = bookRepository.findBookById(id);

        if(currentBook == null){
            throw new ApiException("Book not found");
        }
        bookRepository.deleteById(id);
    }


    public void assignBookToStore(ObjectNode objectNode){

        Integer storeId= objectNode.get("storeId").asInt();
        Store store = storeService.getStore(storeId);

        Integer bookId = objectNode.get("bookId").asInt();
        Book book= getBook(bookId);

        book.setStore(store);
        bookRepository.save(book);
    }

    public int getNumberOfBook(Integer bookId){
        Book book = getBook(bookId);
        return book.getBookCount();
    }

    public Book findBookByName(String name){
        Book book = bookRepository.findBookByName(name);
        return book;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books = bookRepository.findAllByGenre(genre);
        return books;
    }
    
}
