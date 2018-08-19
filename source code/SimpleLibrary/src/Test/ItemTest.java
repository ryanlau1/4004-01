package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.tables.ItemTable;

public class ItemTest {

	//Creation
	@Test
	//Success
	public void test1() {
		assertEquals(true,ItemTable.getInstance().createitem("9781317594277"));
	}
	@Test
	//Failed, item exists
	public void test2(){
		assertEquals(false,ItemTable.getInstance().createitem("9781317594267"));
	}
	//Deletion
	@Test
	public void test3(){
		assertEquals("success", ItemTable.getInstance().delete("9781317594277", "1"));
	}
	@Test
	public void test4(){
		assertEquals("The Item Does Not Exist", ItemTable.getInstance().delete("9781317594277", "2"));
	}
	@Test
	public void test5(){
		assertEquals("Active Loan Exists", ItemTable.getInstance().delete("9781442668584", "1"));
	}
}
