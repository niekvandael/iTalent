package be.pxl.model;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import be.italent.model.Like;
import be.italent.model.Project;
import be.italent.model.SubscriberDocent;
import be.italent.model.SubscriberStudent;
import be.italent.model.User;
import be.italent.model.WantedSubscriber;

public class ProjectTestClass {
  @Test
  public void test_new_backer_should_update_project_backer_percentage() {
	  // Arrange
	  Project project = new Project();
	  ArrayList<SubscriberDocent> backers = new ArrayList<SubscriberDocent>();
	  SubscriberDocent subscriberDocent= new SubscriberDocent();
	  subscriberDocent.setBackingPct(100);
	  backers.add(subscriberDocent);
	  project.setSubscribersDocent(backers);
	  
	  
	  // Act
	  project.updateBackingPct();
	  
	  // Assert
	  Assert.assertEquals(100, project.getBackingPct());
  }
  
  @Test
  public void test_new_subscriber_should_not_update_wanted_seats() {
	  // Arrange
	  Project project = new Project();
	  ArrayList<WantedSubscriber> wanted = new ArrayList<WantedSubscriber>();
	  WantedSubscriber wantedsubscriber1 = new WantedSubscriber();
	  WantedSubscriber wantedsubscriber2 = new WantedSubscriber();
	  
	  wantedsubscriber1.setNumber(5);
	  wantedsubscriber2.setNumber(7);
	  
	  wanted.add(wantedsubscriber1);
	  wanted.add(wantedsubscriber2);
	  
	  project.setWantedSubscribers(wanted);
	  
	  SubscriberStudent subscriberStudent1 = new SubscriberStudent();
	  SubscriberStudent subscriberStudent2 = new SubscriberStudent();
	  ArrayList<SubscriberStudent> students = new ArrayList<SubscriberStudent>();
	  students.add(subscriberStudent1);
	  students.add(subscriberStudent2);
	  project.setSubscribersStudent(students);
	  
	  	  
	  // Act
	  project.getWantedSeats();
	  
	  // Assert
	  Assert.assertEquals(12, project.getWantedSeats());
  }
  
  @Test
  public void test_new_student_subscriber_should_increase_taken_seats() {
	  // Arrange
	  Project project = new Project();
	  ArrayList<WantedSubscriber> wanted = new ArrayList<WantedSubscriber>();
	  WantedSubscriber wantedsubscriber1 = new WantedSubscriber();
	  WantedSubscriber wantedsubscriber2 = new WantedSubscriber();
	  
	  wantedsubscriber1.setNumber(5);
	  wantedsubscriber2.setNumber(7);
	  
	  wanted.add(wantedsubscriber1);
	  wanted.add(wantedsubscriber2);
	  
	  project.setWantedSubscribers(wanted);
	  
	  SubscriberStudent subscriberStudent1 = new SubscriberStudent();
	  SubscriberStudent subscriberStudent2 = new SubscriberStudent();
	  ArrayList<SubscriberStudent> students = new ArrayList<SubscriberStudent>();
	  students.add(subscriberStudent1);
	  students.add(subscriberStudent2);
	  project.setSubscribersStudent(students);
	  
	  	  
	  // Act
	  project.getTakenSeats();
	  
	  // Assert
	  Assert.assertEquals(2, project.getTakenSeats());
  }
  
  
  @Test
  public void test_user_can_not_back_if_already_backing() {
	  // Arrange
	  Project project = new Project();
	  SubscriberDocent docent1 = new SubscriberDocent();
	  User user1 = new User();
	  user1.setUserId(5);
	  docent1.setUser(user1);

	  ArrayList<SubscriberDocent> docents = new ArrayList<SubscriberDocent>();
	  docents.add(docent1);
	  project.setSubscribersDocent(docents);
	  
	  // Act
	  project.updateCanBack(5);
	  
	  // Assert
	  Assert.assertEquals(false, project.isCanBack());
  }
  
  @Test
  public void test_user_can_back_if_not_already_backing() {
	  // Arrange
	  Project project = new Project();
	  SubscriberDocent docent1 = new SubscriberDocent();
	  User user1 = new User();
	  user1.setUserId(7);
	  docent1.setUser(user1);

	  ArrayList<SubscriberDocent> docents = new ArrayList<SubscriberDocent>();
	  docents.add(docent1);
	  project.setSubscribersDocent(docents);
	  
	  // Act
	  project.updateCanBack(5);
	  
	  // Assert
	  Assert.assertEquals(true, project.isCanBack());
  }
  
  @Test
  public void test_project_is_archived_if_begindate_plus_duration_exceeded() {
	  // Arrange
	  Project project = new Project();
	  project.setBackingPct(100);
	  project.setStartDate(new Date(System.currentTimeMillis()-24*60*60*1000));
	  project.setDuration(100);
	  
	  // Act
	  project.isArchived();
	  
	  // Assert
	  Assert.assertEquals(true, project.isArchived());
  }
  
  @Test
  public void test_project_not_archived_if_begindate_plus_duration_not_exceeded() {
	  // Arrange
	  Project project = new Project();
	  project.setBackingPct(100);
	  project.setStartDate(new Date());
	  project.setDuration(100);
	  
	  // Act
	  project.isArchived();
	  
	  // Assert
	  Assert.assertEquals(false, project.isArchived());
  }
  
  @Test
  public void test_project_is_running_if_begindate_plus_duration_not_exceeded() {
	  // Arrange
	  Project project = new Project();
	  project.setBackingPct(100);
	  project.setStartDate(new Date());
	  project.setDuration(100);
	  
	  // Act
	  project.isRunning();
	  
	  // Assert
	  Assert.assertEquals(true, project.isRunning());
  }
  
  @Test
  public void test_project_not_running_if_begindate_plus_duration_not_exceeded() {
	  // Arrange
	  Project project = new Project();
	  project.setBackingPct(100);
	  project.setStartDate(new Date(System.currentTimeMillis()-24*60*60*1000));
	  project.setDuration(100);
	  
	  // Act
	  project.isRunning();
	  
	  // Assert
	  Assert.assertEquals(false, project.isRunning());
  }
  
  @Test
  public void test_liked_should_return_true_when_user_exists_in_liked_array() {
	  // Arrange
	  Project project = new Project();
	  ArrayList<Like> likes = new ArrayList<Like>();
	  
	  Like like1 = new Like();
	  User user1 = new User();
	  user1.setUserId(5);
	  
	  like1.setUser(user1);
	  likes.add(like1);
	  project.setLikes(likes);
	  
	  // Act
	  project.setLiked(5);
	  
	  // Assert
	  Assert.assertEquals(true, project.isLiked());
  }
} 
