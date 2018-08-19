package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.tables.TitleTable;

public class TitleTest {

	//Creation Test
	@Test
	public void test1() {
		assertEquals(true,TitleTable.getInstance().createtitle("9789875506558", "Othello"));
	}
	@Test
	public void test2(){
		assertEquals(false,TitleTable.getInstance().createtitle("9781442668584", "By the Grace of God"));
	}
	//Deletion Test
	@Test
	public void test3(){
		assertEquals("success",TitleTable.getInstance().delete("9789875506558"));
	}
	@Test
	public void test4(){
		assertEquals("Active Loan Exists",TitleTable.getInstance().delete("9781442668584"));
	}
	@Test
	public void test5(){
		assertEquals("The Title Does Not Exist",TitleTable.getInstance().delete("21390"));
	}
}
