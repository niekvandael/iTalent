package be.pxl.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import be.italent.model.Department;
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
  
  @Test
  public void test_liked_should_return_false_when_user_not_exists_in_liked_array() {
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
	  project.setLiked(4);
	  
	  // Assert
	  Assert.assertEquals(false, project.isLiked());
  }
  
  @Test
  public void test_mySuscribed_hours_should_return_amount_of_hours() {
	  // Arrange
	  Project project = new Project();
	  SubscriberStudent subscriberStudent1 = new SubscriberStudent();
	  User user1 = new User();
	  user1.setUserId(1);
	  subscriberStudent1.setUser(user1);
	  subscriberStudent1.setHours(100);
	  
	  SubscriberStudent subscriberStudent2 = new SubscriberStudent();
	  User user2 = new User();
	  user2.setUserId(2);
	  subscriberStudent2.setUser(user2);
	  subscriberStudent2.setHours(120);
	  
	  ArrayList<SubscriberStudent> students = new ArrayList<SubscriberStudent>();
	  students.add(subscriberStudent1);
	  students.add(subscriberStudent2);
	  project.setSubscribersStudent(students);
	  
	  // Act
	  project.setMySubscribedHours(2);
	  
	  // Assert
	  Assert.assertEquals(120, project.getMySubscribedHours());
  }
  
  @Test
  public void test_mySuscribed_hours_should_return_0_if_not_registered() {
	  // Arrange
	  Project project = new Project();
	  SubscriberStudent subscriberStudent1 = new SubscriberStudent();
	  User user1 = new User();
	  user1.setUserId(1);
	  subscriberStudent1.setUser(user1);
	  subscriberStudent1.setHours(100);
	  
	  SubscriberStudent subscriberStudent2 = new SubscriberStudent();
	  User user2 = new User();
	  user2.setUserId(2);
	  subscriberStudent2.setUser(user2);
	  subscriberStudent2.setHours(120);
	  
	  ArrayList<SubscriberStudent> students = new ArrayList<SubscriberStudent>();
	  students.add(subscriberStudent1);
	  students.add(subscriberStudent2);
	  project.setSubscribersStudent(students);
	  
	  // Act
	  project.setMySubscribedHours(5);
	  
	  // Assert
	  Assert.assertEquals(0, project.getMySubscribedHours());
  }
  
  @Test
  public void test_myBackingPct_should_return_backingpct_of_user() {
	  // Arrange
	  Project project = new Project();
	  SubscriberDocent subscriberDocent1 = new SubscriberDocent();
	  User user1 = new User();
	  user1.setUserId(1);
	  subscriberDocent1.setUser(user1);
	  subscriberDocent1.setBackingPct(90);
	  
	  SubscriberDocent subscriberDocent2 = new SubscriberDocent();
	  User user2 = new User();
	  user2.setUserId(2);
	  subscriberDocent2.setUser(user2);
	  subscriberDocent2.setBackingPct(50);
	  
	  ArrayList<SubscriberDocent> docents = new ArrayList<SubscriberDocent>();
	  docents.add(subscriberDocent1);
	  docents.add(subscriberDocent2);
	  project.setSubscribersDocent(docents);
	  
	  // Act
	  project.setMyBackingPct(2);
	  
	  // Assert
	  Assert.assertEquals(50, project.getMyBackingPct());
  }
  
  @Test
  public void test_myBackingPct_should_return_0_if_not_backing() {
	  // Arrange
	  Project project = new Project();
	  SubscriberDocent subscriberDocent1 = new SubscriberDocent();
	  User user1 = new User();
	  user1.setUserId(1);
	  subscriberDocent1.setUser(user1);
	  subscriberDocent1.setBackingPct(90);
	  
	  SubscriberDocent subscriberDocent2 = new SubscriberDocent();
	  User user2 = new User();
	  user2.setUserId(2);
	  subscriberDocent2.setUser(user2);
	  subscriberDocent2.setBackingPct(50);
	  
	  ArrayList<SubscriberDocent> docents = new ArrayList<SubscriberDocent>();
	  docents.add(subscriberDocent1);
	  docents.add(subscriberDocent2);
	  project.setSubscribersDocent(docents);
	  
	  // Act
	  project.setMyBackingPct(9);
	  
	  // Assert
	  Assert.assertEquals(0, project.getMyBackingPct());
  }
  
  @Test
  public void test_project_endate_should_equal_startdate_plus_duration() {
	  // Arrange
	  Project project = new Project();
	  project.setStartDate(new Date());
	  project.setDuration(1000);
	 
	  // Act
	  project.getEndDate();

	  // Assert
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(project.getStartDate());
	  cal.add(Calendar.MINUTE, 1000);

	  Assert.assertEquals(cal.getTime(), project.getEndDate());
  }
  
  @Test
  public void test_project_endate_should_return_null_when_no_startDate() {
	  // Arrange
	  Project project = new Project();
	  project.setStartDate(null);
	  project.setDuration(1000);
	 
	  // Act
	  project.getEndDate();

	  // Assert
	  Assert.assertEquals(null, project.getEndDate());
  }
  
  @Test
  public void test_number_of_likes_should_return_equal_array_size() {
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
	  project.getNumberOfLikes();
	  
	  // Assert
	  Assert.assertEquals(1, project.getNumberOfLikes());
  }
  
  @Test
  public void test_number_of_likes_should_return_0_when_no_likes() {
	  // Arrange
	  Project project = new Project();
	  
	  // Act
	  project.getNumberOfLikes();
	  
	  // Assert
	  Assert.assertEquals(0, project.getNumberOfLikes());
  }
  
  @Test
  public void test_student_enroll_and_asked_should_return_true() {
	  // Arrange
	  Project project = new Project();
	  
	  // 1. add wanted subscribers
	  ArrayList<WantedSubscriber> wanted = new ArrayList<WantedSubscriber>();
	  WantedSubscriber wantedsubscriber1 = new WantedSubscriber();
	  WantedSubscriber wantedsubscriber2 = new WantedSubscriber();
	  wantedsubscriber1.setNumber(5);
	  Department department1 = new Department();
	  department1.setDepartmentId(1);
	  wantedsubscriber1.setDepartment(department1);
	  wantedsubscriber2.setNumber(7);
	  Department department2 = new Department();
	  department2.setDepartmentId(2);
	  wantedsubscriber2.setDepartment(department2);
	  wanted.add(wantedsubscriber1);
	  wanted.add(wantedsubscriber2);
	  project.setWantedSubscribers(wanted);
	  
	  // 2. add students
	  SubscriberStudent subscriberStudent1 = new SubscriberStudent();
	  User user1 = new User();
	  user1.setUserId(1);
	  user1.setDepartment(department1);
	  subscriberStudent1.setUser(user1);
	  subscriberStudent1.setHours(100);
	  
	  SubscriberStudent subscriberStudent2 = new SubscriberStudent();
	  User user2 = new User();
	  user2.setUserId(2);
	  user2.setDepartment(department2);
	  subscriberStudent2.setUser(user2);
	  subscriberStudent2.setHours(120);
	
	  ArrayList<SubscriberStudent> students = new ArrayList<SubscriberStudent>();
	  students.add(subscriberStudent1);
	  students.add(subscriberStudent2);
	  project.setSubscribersStudent(students);
	  
	  // Act
	  project.updateCanSubscribe(9, 1);
	  
	  // Assert
	  Assert.assertEquals(true, project.canSubscribe);
  }

  @Test
  public void test_student_enroll_department_not_asked_should_return_false() {
	  // Arrange
	  Project project = new Project();
	  
	  // 1. add wanted subscribers
	  ArrayList<WantedSubscriber> wanted = new ArrayList<WantedSubscriber>();
	  WantedSubscriber wantedsubscriber1 = new WantedSubscriber();
	  WantedSubscriber wantedsubscriber2 = new WantedSubscriber();
	  wantedsubscriber1.setNumber(5);
	  Department department1 = new Department();
	  department1.setDepartmentId(1);
	  wantedsubscriber1.setDepartment(department1);
	  wantedsubscriber2.setNumber(7);
	  Department department2 = new Department();
	  department2.setDepartmentId(2);
	  wantedsubscriber2.setDepartment(department2);
	  wanted.add(wantedsubscriber1);
	  wanted.add(wantedsubscriber2);
	  project.setWantedSubscribers(wanted);
	  
	  // 2. add students
	  SubscriberStudent subscriberStudent1 = new SubscriberStudent();
	  User user1 = new User();
	  user1.setUserId(1);
	  user1.setDepartment(department1);
	  subscriberStudent1.setUser(user1);
	  subscriberStudent1.setHours(100);
	  
	  SubscriberStudent subscriberStudent2 = new SubscriberStudent();
	  User user2 = new User();
	  user2.setUserId(2);
	  user2.setDepartment(department2);
	  subscriberStudent2.setUser(user2);
	  subscriberStudent2.setHours(120);
	
	  ArrayList<SubscriberStudent> students = new ArrayList<SubscriberStudent>();
	  students.add(subscriberStudent1);
	  students.add(subscriberStudent2);
	  project.setSubscribersStudent(students);
	  
	  // Act
	  project.updateCanSubscribe(9, 1);
	  
	  // Assert
	  Assert.assertEquals(true, project.canSubscribe);
  }

  @Test
  public void test_student_enroll_and_department_asked_but_full_should_return_false() {
	  // Arrange
	  Project project = new Project();
	  
	  // 1. add wanted subscribers
	  ArrayList<WantedSubscriber> wanted = new ArrayList<WantedSubscriber>();
	  WantedSubscriber wantedsubscriber1 = new WantedSubscriber();
	  WantedSubscriber wantedsubscriber2 = new WantedSubscriber();
	  wantedsubscriber1.setNumber(1);
	  Department department1 = new Department();
	  department1.setDepartmentId(1);
	  wantedsubscriber1.setDepartment(department1);
	  wantedsubscriber2.setNumber(7);
	  Department department2 = new Department();
	  department2.setDepartmentId(2);
	  wantedsubscriber2.setDepartment(department2);
	  wanted.add(wantedsubscriber1);
	  wanted.add(wantedsubscriber2);
	  project.setWantedSubscribers(wanted);
	  
	  // 2. add students
	  SubscriberStudent subscriberStudent1 = new SubscriberStudent();
	  User user1 = new User();
	  user1.setUserId(1);
	  user1.setDepartment(department1);
	  subscriberStudent1.setUser(user1);
	  subscriberStudent1.setHours(100);
	  
	  SubscriberStudent subscriberStudent2 = new SubscriberStudent();
	  User user2 = new User();
	  user2.setUserId(2);
	  user2.setDepartment(department2);
	  subscriberStudent2.setUser(user2);
	  subscriberStudent2.setHours(120);
	
	  ArrayList<SubscriberStudent> students = new ArrayList<SubscriberStudent>();
	  students.add(subscriberStudent1);
	  students.add(subscriberStudent2);
	  project.setSubscribersStudent(students);
	  
	  // Act
	  project.updateCanSubscribe(9, 1);
	  
	  // Assert
	  Assert.assertEquals(false, project.canSubscribe);
  }
  
  @Test
  public void test_student_enroll_but_already_enrolled_should_return_false() {
	  // Arrange
	  Project project = new Project();
	  
	  // 1. add wanted subscribers
	  ArrayList<WantedSubscriber> wanted = new ArrayList<WantedSubscriber>();
	  WantedSubscriber wantedsubscriber1 = new WantedSubscriber();
	  WantedSubscriber wantedsubscriber2 = new WantedSubscriber();
	  wantedsubscriber1.setNumber(1);
	  Department department1 = new Department();
	  department1.setDepartmentId(1);
	  wantedsubscriber1.setDepartment(department1);
	  wantedsubscriber2.setNumber(7);
	  Department department2 = new Department();
	  department2.setDepartmentId(2);
	  wantedsubscriber2.setDepartment(department2);
	  wanted.add(wantedsubscriber1);
	  wanted.add(wantedsubscriber2);
	  project.setWantedSubscribers(wanted);
	  
	  // 2. add students
	  SubscriberStudent subscriberStudent1 = new SubscriberStudent();
	  User user1 = new User();
	  user1.setUserId(1);
	  user1.setDepartment(department1);
	  subscriberStudent1.setUser(user1);
	  subscriberStudent1.setHours(100);
	  
	  SubscriberStudent subscriberStudent2 = new SubscriberStudent();
	  User user2 = new User();
	  user2.setUserId(2);
	  user2.setDepartment(department2);
	  subscriberStudent2.setUser(user2);
	  subscriberStudent2.setHours(120);
	
	  ArrayList<SubscriberStudent> students = new ArrayList<SubscriberStudent>();
	  students.add(subscriberStudent1);
	  students.add(subscriberStudent2);
	  project.setSubscribersStudent(students);
	  
	  // Act
	  project.updateCanSubscribe(1, 1);
	  
	  // Assert
	  Assert.assertEquals(false, project.canSubscribe);
  }
} 
