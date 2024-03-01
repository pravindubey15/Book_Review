package com.example.Book_Management;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @PostMapping("/book/add")
    public ResponseEntity<String> addBook(@RequestBody Book b){
        bookRepository.save(b);
        return ResponseEntity.ok("saved");
    }
    @GetMapping("book/all")
    public @ResponseBody Iterable<Book> getAll(){
        return bookRepository.findAll();
    }
@DeleteMapping("/book/delete")
    public ResponseEntity<String> getDelete(@PathParam("id") Integer id){
    bookRepository.deleteById(id);
    return ResponseEntity.ok("Done");
}
@PutMapping("/update/{id}")
    public ResponseEntity<String> getUpdate(@PathVariable Integer id, Book bk){
        if(!bookRepository.existsById(id)){
            return ResponseEntity.ok("Not found");
        }
        bk.setId(id);
        bookRepository.save(bk);
        return ResponseEntity.ok("Successfully update in Database");

}

}



