package com.rental;

import com.vehicleRental.Truck;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TruckTest extends TestCase {

    private Truck truck;

    public TruckTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        truck = new Truck("T1", "Volvo HNL", 800.0); // Concrete Truck for testing
    }

    public static Test suite() {
        return new TestSuite(TruckTest.class);
    }

    public void testConstructorAndGetters() {
        assertEquals("Vehicle ID should be 'T1'", "T1", truck.getVehicleId());
        assertEquals("Model should be 'Volvo HNL'", "Volvo HNL", truck.getModel());
        assertEquals("Base rental rate should be 800.0", 800.0, truck.getBaseRentalRate());
        assertTrue("The truck should be available by default.", truck.isAvailable());
    }

    public void testCalculateRentalCost() {
        int rentalDays = 4;
        double expectedCost = 800.0 * rentalDays * 1.5; // Apply 50% additional charge for trucks
        assertEquals("The rental cost should be calculated correctly.", expectedCost, truck.calculateRentalCost(rentalDays));
    }

    public void testIsAvailableForRental() {
        assertTrue("The truck should be available for rental by default.", truck.isAvailableForRental());
        truck.setAvailable(false);
        assertFalse("The truck should not be available when availability is set to false.", truck.isAvailableForRental());
    }

    public void testToString() {
        String expectedString = "Vehicle ID: T1, Model: Volvo HNL, Base Rental Rate: 800.0 Cedis ";
        assertEquals("The toString method should return the correct vehicle details.", expectedString, truck.toString());
    }
}
