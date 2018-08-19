package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import server.logic.tables.FeeTable;
import server.logic.tables.LoanTable;

public class FeeTest {
	//Testing Fee
	@Test
	public void test() {
		assertEquals("success", LoanTable.getInstance().createloan(1, "9781442667181", "1", new Date()));
		assertEquals("Borrowing Items Exist", FeeTable.getInstance().payfine(1));
		assertEquals("success", LoanTable.getInstance().createloan(2, "9781611687910", "1", new Date()));
		assertEquals("success", LoanTable.getInstance().renewal(2, "9781611687910", "1", new Date()));
	}

}
