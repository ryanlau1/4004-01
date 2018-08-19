package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import server.logic.tables.LoanTable;

public class BorrowTest {
	//Testing Borrow
	@Test
	public void test() {
		assertEquals("success", LoanTable.getInstance().createloan(1, "9781442616899", "1", new Date()));
		assertEquals("The Item is Not Available", LoanTable.getInstance().createloan(1, "9781442668584", "1", new Date()));
		assertEquals("User Invalid", LoanTable.getInstance().createloan(15, "978142667181", "1", new Date()));
		assertEquals("ISBN Invalid", LoanTable.getInstance().createloan(1, "978142667181", "1", new Date()));
		assertEquals("Outstanding Fee Exists", LoanTable.getInstance().createloan(0, "9781442667181", "1", new Date()));
	}

}
