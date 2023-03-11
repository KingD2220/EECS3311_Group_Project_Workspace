package application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountsControllerJUnitTests.class, ReservationControllerTest.class })
public class ApplicationTestSuite {

}
