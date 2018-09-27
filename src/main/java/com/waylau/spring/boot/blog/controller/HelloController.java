/**
 * 
 */
package com.waylau.spring.boot.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ASUS
 *
 */

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world!";
	}
}
