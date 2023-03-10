package domain_objects;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountClassJUnitTests.class, CustomerClassJUnitTests.class, DeluxeRoomJUnitTestsTest.class,
		EmployeeClassJUnitTestsTest.class, ExecutiveSuiteJUnitTests.class, PaymentMethodJUnitTests.class,
		PresidentialSuiteJUnitTests.class, ReservationClassTest.class, StandardRoomJUnitTests.class,
		SuiteRoomJUnitTests.class })
public class DomainObjectsTestSuite {

}
