package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import server.logic.handler.InputHandler;

public class InputOutputHandlerTest {
	InputHandler test = new InputHandler();
	
	//Testing first login
	@Test
	public void firstTest() {
		assertEquals("Who Are you?Clerk or User?", test.processInput("hi", 0).getOutput());
		//Login to clerk
		assertEquals("Please Input The Password:",(test.processInput("clerk", 1)).getOutput());
		//Testing clerk login
		assertEquals("Wrong Password!Please Input The Password:",(test.processInput("admim", 14)).getOutput());
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item, Monitor System.",(test.processInput("admin", 14)).getOutput());
		//Login to user
		assertEquals("Please Input Username and Password:'username,password'",(test.processInput("user", 1)).getOutput());
		//Testing user login		
		assertEquals("Wrong Password!Please Input Username and Password:'username,password'",(test.processInput("yu@carleton.ca,Yuu", 15)).getOutput());
		assertEquals("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.",(test.processInput("yu@carleton.ca,yu", 15)).getOutput());
		assertEquals("Your input should in this format:'username,password'",(test.processInput("jack", 15)).getOutput());
		assertEquals("The User Does Not Exist!Please The Username and Password:'username,password'",(test.processInput("jack@carleton.ca,jack", 15)).getOutput());
				
	}
	//Testing User Operations
	@Test
	public void secondTest(){
		assertEquals("Please Input User Info:'useremail,ISBN,copynumber'",(test.processInput("borrow", 3)).getOutput());
		assertEquals("Please Input Title Info:'useremail,ISBN,copynumber'",(test.processInput("renew", 3)).getOutput());
		assertEquals("Please Input Item Info:'useremail,ISBN,copynumber'",(test.processInput("return", 3)).getOutput());
		assertEquals("Please Input User Info:'useremail'",(test.processInput("pay fine", 3)).getOutput());
	}
	//Testing Clerk operations
	@Test
	public void thirdTest(){
		//Create
		assertEquals("Please Input User Info:'username,password'",(test.processInput("create user", 2)).getOutput());
		assertEquals("Please Input Title Info:'ISBN,title'",(test.processInput("create title", 2)).getOutput());
		assertEquals("Please Input Item Info:'ISBN'",(test.processInput("create item", 2)).getOutput());
		//Delete
		assertEquals("Please Input User Info:'useremail'",(test.processInput("delete user", 2)).getOutput());
		assertEquals("Please Input Title Info:'ISBN'",(test.processInput("delete title", 2)).getOutput());
		assertEquals("Please Input Item Info:'ISBN,copynumber'",(test.processInput("delete item", 2)).getOutput());
	}
	//Testing main menu and log out Operations
	@Test
	public void fourthTest(){
		//Main menu
		String messageClerk = "What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item, Monitor System.";
		String messageUser = "What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.";
		assertEquals(messageClerk,(test.processInput("main menu", 2)).getOutput());
		assertEquals(messageUser,(test.processInput("main menu", 3)).getOutput());	
		assertEquals(messageClerk,(test.processInput("main menu", 4)).getOutput());
		assertEquals(messageClerk,(test.processInput("main menu", 5)).getOutput());
		assertEquals(messageClerk,(test.processInput("main menu", 6)).getOutput());
		assertEquals(messageClerk,(test.processInput("main menu", 7)).getOutput());
		assertEquals(messageClerk,(test.processInput("main menu", 8)).getOutput());
		assertEquals(messageClerk,(test.processInput("main menu", 9)).getOutput());
		assertEquals(messageUser,(test.processInput("main menu", 10)).getOutput());
		assertEquals(messageUser,(test.processInput("main menu", 11)).getOutput());
		assertEquals(messageUser,(test.processInput("main menu", 12)).getOutput());
		assertEquals(messageUser,(test.processInput("main menu", 13)).getOutput());
		assertEquals(messageClerk,(test.processInput("main menu", 16)).getOutput());
		
		//Log out
		assertEquals("Successfully Log Out!",(test.processInput("log out",2)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",3)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",4)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",5)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",6)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",7)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",8)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",9)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",10)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",11)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",12)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",13)).getOutput());
		assertEquals("Successfully Log Out!",(test.processInput("log out",16)).getOutput());
	}
	//Testing Clerk commands
	@Test
	public void fifthTest(){
		//Creating Title
		assertEquals("Success!",(test.processInput("9789875506558, Othello",5)).getOutput());
		assertEquals("The Title Already Exists!",(test.processInput("9789875506558, Othello",5)).getOutput());
		assertEquals("Your input should in this format:'ISBN,title',ISBN should be a 13-digit number",(test.processInput("978987550655, Othello",5)).getOutput());
		
		//Creating User
		assertEquals("Success!",(test.processInput("john@carleton.ca,john", 4)).getOutput());
		assertEquals("The User Already Exists!",(test.processInput("john@carleton.ca,john", 4)).getOutput());
		assertEquals("Your input should in this format:'username,password'",(test.processInput("john", 4)).getOutput());
		
		//Creating Title
		assertEquals("Success!",(test.processInput("9789875506558", 6)).getOutput());
		assertEquals("The Title Does Not Exists!",(test.processInput("9789875506555", 6)).getOutput());
		assertEquals("Your input should in this format:'ISBN',ISBN should be a 13-digit number", (test.processInput("978987550655", 6)).getOutput());
		
		//Deleting Title
		assertEquals("Success!",(test.processInput("9789875506558", 8)).getOutput());
		assertEquals("The Title Does Not Exist!", (test.processInput("9789875506989", 8)).getOutput());
		assertEquals("Your input should in this format:'ISBN',ISBN should be a 13-digit number", (test.processInput("9", 8)).getOutput());
		
		//Deleting User
		assertEquals("Success!",(test.processInput("john@carleton.ca", 7)).getOutput());
		assertEquals("The User Does Not Exist!",(test.processInput("justin@carleton.ca", 7)).getOutput());
		assertEquals("Your input should in this format:'useremail'",(test.processInput("justin", 7)).getOutput());
		
		//Deleting Item
		assertEquals("Success!",(test.processInput("9781442616899,1", 9)).getOutput());
		assertEquals("Your input should in this format:'ISBN,copynumber',ISBN should be a 13-digit number",(test.processInput("978142616899,1", 9)).getOutput());
		assertEquals("Active Loan Exists!",(test.processInput("9781442668584,1", 9)).getOutput());
		assertEquals("The Item Does Not Exist!", (test.processInput("9781444403404,1", 9)).getOutput());
	}
	//Testing User commands
	@Test
	public void sixthTest(){
		//Borrow
		assertEquals("Success!",(test.processInput("yu@carleton.ca,9781611687910,1", 10)).getOutput());
		assertEquals("The User Does Not Exist!",(test.processInput("frank@carleton.ca,9781611687910,1", 10)).getOutput());
		assertEquals("Copynumber Invalid!",(test.processInput("yu@carleton.ca,9781611687910,5", 10)).getOutput());
		assertEquals("ISBN Invalid!",(test.processInput("yu@carleton.ca,1281611687450,1", 10)).getOutput());
		assertEquals("The Item is Not Available!",(test.processInput("michelle@carleton.ca,9781611687910,1", 10)).getOutput());
		assertEquals("Outstanding Fee Exists!", (test.processInput("Zhibo@carleton.ca,9781442667181,1", 10)).getOutput());
		
		//Renew
		assertEquals("Success!",(test.processInput("yu@carleton.ca,9781611687910,1", 11)).getOutput());
		assertEquals("The User Does Not Exist!",(test.processInput("jam@carleton.ca,9781611687910,1", 11)).getOutput());
		assertEquals("Outstanding Fee Exists!",(test.processInput("Zhibo@carleton.ca,9781442667181,1", 11)).getOutput());
		assertEquals("Renewed Item More Than Once for the Same Loan!",(test.processInput("yu@carleton.ca,9781611687910,1", 11)).getOutput());
		
		//Return
		assertEquals("Success!",(test.processInput("yu@carleton.ca,9781611687910,1", 12)).getOutput());
		assertEquals("The Loan Does Not Exist!",(test.processInput("yu@carleton.ca,9781611687410,1", 12)).getOutput());
		
		//Pay Fine
		assertEquals("Borrowing Items Exist!",(test.processInput("zhibo@carleton.ca",13)).getOutput());
		assertEquals("Success!",(test.processInput("yu@carleton.ca", 13).getOutput()));
	}

}
