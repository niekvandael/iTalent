package be.italent.controllers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import be.italent.web.controller.UserController;

public class TestUserController {
  @Test
  public void loginTest() {
    // MyClass is tested
	  UserController tester = new UserController();
	  
    // assert statements
    assertEquals(tester.login(), true);
  }
} 
