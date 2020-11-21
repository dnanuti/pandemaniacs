//package com.ing.pandemaniacs.hackathon.interfaces;
//
//import com.ing.pandemaniacs.hackathon.model.Transaction;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@RequestMapping("/aggregate")
//public interface AggregateOperations {
//
//    @GetMapping("/")
//    List<Transaction> getAll();
//
//    @GetMapping("/{id}")
//    Optional<Book> getById(@PathVariable int id);
//
//    @PostMapping("/save/{id}")
//    public void save(@RequestBody Book book, @PathVariable int id);
//}