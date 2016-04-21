package be.italent.controllers;

import static org.junit.Assert.assertEquals;

import be.italent.web.controller.UserController;
import org.junit.Test;

public class TestUserController {
  @Test
  public void loginTest() {
    // MyClass is tested
	  UserController tester = new UserController();
	  
    // assert statements
    assertEquals(tester.login(), true);
  }
} 
