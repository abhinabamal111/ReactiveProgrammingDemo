package com.demo.reactive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.reactivex.Observable;
import io.reactivex.Single;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveProgrammingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingDemoApplication.class, args);
		
		  List<Integer> l = Arrays.asList(5, 2, 4, 0, 3, 2, 8); 
		  List<Integer> newList = Arrays.asList(5, 2, 4); 
		  
		  
		  Single.just(l)
		  .map(i->i.stream() .map(j -> 10 / j) .collect(Collectors.toList()))
		  
		  .onErrorResumeNext(e->/*Single.error(e)*/ Single.just(newList))
		  .subscribe(i -> System.out.println("RECEIVED: " + i),
				  e ->System.out.println("RECEIVED ERROR: " + e));
		 
		
		/*
		 * Observable.just(5, 2, 4, 0, 3, 2, 8) .map(i -> 10 / i)
		 * .onErrorResumeNext(Observable.just(-1).repeat(3)) .subscribe(i ->
		 * System.out.println("RECEIVED: " + i), e ->
		 * System.out.println("RECEIVED ERROR: " + e));
		 */
	}

}
