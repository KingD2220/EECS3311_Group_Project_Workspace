package Reservation_logic_Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import business_logic.ReservationLogic;
import persistence.Database;
import persistence.RealDatabase;

public class ReservationLogicIntegration {
	private ReservationLogic reservationLogic;
	@Before
	public void setUp() {
		Database database = new RealDatabase();
		reservationLogic = new ReservationLogic(database);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
