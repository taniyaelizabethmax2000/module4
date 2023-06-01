package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.repositorynew.Repositorynew;


@RestController
@RequestMapping("/springboot/1.0//")
public class controller {

	@Autowired
	Repositorynew repo;
	
	@PostMapping
	public ResponseEntity<Book> createbook(@RequestBody Book book){
		//return new  ResponseEntity<Book>(repo.save(book),HttpStatus.OK);
		//return ResponseEntity.ok(repo.save(book));
	//	return ResponseEntity.ok().body(repo.save(book));
		return ResponseEntity.status(HttpStatus.OK).body(repo.save(book));
	}
	
	@GetMapping
	public ResponseEntity<Book> getbook(@PathVariable int id){
		Optional<Book> opt=repo.findById(id);
		Book b=opt.get();
		if(opt.isPresent()) {
			
			return ResponseEntity.ok().body(b);		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Book> deletebook(@PathVariable int id){
		repo.deleteById(id);
		//return ResponseEntity.ok(null);
	//	return ResponseEntity.ok().body(null);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
		
		
		
	}
	
	@PutMapping
	public ResponseEntity<Book> updatebook(@RequestBody Book book){
		Optional<Book> op=repo.findById(book.getBookid());
		Book bo=null;
		if(op.isPresent()) {
		bo=op.get();
		bo.setBookid(book.getBookid());
		bo.setBookname(book.getBookname());
		return ResponseEntity.ok().body(repo.save(bo));
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getallbook(){
		return  ResponseEntity.ok().body(repo.findAll());
	}
}
