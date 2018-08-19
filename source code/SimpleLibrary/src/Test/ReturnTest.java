package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import server.logic.tables.LoanTable;

public class ReturnTest {
	//Testing Return
	@Test
	public void test() {
		assertEquals("success", LoanTable.getInstance().returnItem(0, "9781442668584", "1", new Date()));
		assertEquals("The Loan Does Not Exist", LoanTable.getInstance().returnItem(5, "9781442668584", "2", new Date()));
	}
}
