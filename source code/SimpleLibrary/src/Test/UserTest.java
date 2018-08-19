package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.tables.UserTable;

public class UserTest {

	//Creation Tests
	@Test
	//Successfully create a user
	public void test1() {
		assertEquals(true,UserTable.getInstance().createuser("Marcus@carleton.ca", "Marcus"));
	}
	@Test 
	//Fail to create a user (already exists)
	public void test2(){
		assertEquals(false,UserTable.getInstance().createuser("Yu@carleton.ca", "Yu"));
	
	}
	//Deletion Tests
	@Test
	//Successfully delete a user
	public void test3(){
		assertEquals("success",UserTable.getInstance().delete(1));
	}
	//Fail to delete a user
	public void test4(){
		assertEquals("The User Does Not Exist",UserTable.getInstance().delete(92));		
	}
	public void test5(){
		assertEquals("Active Loan Exists",UserTable.getInstance().delete(1));
	}
	public void test6(){
		assertEquals("Outstanding Fee Exists", UserTable.getInstance().delete(0));
	}
	
}
