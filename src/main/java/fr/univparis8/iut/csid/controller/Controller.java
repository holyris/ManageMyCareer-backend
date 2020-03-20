package fr.univparis8.iut.csid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

  @GetMapping("")
  public String sendHello() {
    return "Hello";
  }

  @GetMapping("/protected")
  public String sendProtected() {
    return "Protected!";
  }
}
