package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import server.logic.tables.LoanTable;

public class RenewTest {
	//Testing Renew
	@Test
	public void test() {
		assertEquals("success", LoanTable.getInstance().renewal(1, "9781442667181", "1", new Date()));
		assertEquals("The loan does not exist", LoanTable.getInstance().renewal(60, "9781611687910", "1", new Date()));
		assertEquals("Outstanding Fee Exists", LoanTable.getInstance().renewal(0, "9781442668584", "1", new Date()));
		assertEquals("Renewed Item More Than Once for the Same Loan", LoanTable.getInstance().renewal(1, "9781442667181", "1", new Date()));
		
	}

}
