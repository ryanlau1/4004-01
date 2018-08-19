package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BorrowTest.class, FeeTest.class, RenewTest.class, ReturnTest.class })
public class Suite2 {

}
