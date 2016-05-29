package com.tanviprojects.codingchallenge.vehicleservice.repository;

import com.tanviprojects.codingchallenge.vehicleservice.model.Vehicle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class InMemoryVehicleRepositoryTest {
    private InMemoryVehicleRepository subject;
    private Vehicle fakeVehicle1, fakeVehicle2, fakeVehicle3,testVehicle1, testVehicle2, testVehicle3, testVehicle4;
    private ConcurrentMap<Integer, Vehicle> mockedStore;
    private Collection<Vehicle> allVehicles;

    @Before
    public void setUp() {
        mockedStore = mock(ConcurrentMap.class);
        subject = new InMemoryVehicleRepository(mockedStore);
        fakeVehicle1 = mock(Vehicle.class);
        fakeVehicle2 = mock(Vehicle.class);
        fakeVehicle3 = mock(Vehicle.class);
        allVehicles = new ArrayList<>();
        allVehicles.add(fakeVehicle1);
        allVehicles.add(fakeVehicle2);
        allVehicles.add(fakeVehicle3);
        testVehicle1 = new Vehicle(1, 12, "a", "a");
        testVehicle2 = new Vehicle(2, 13, "aw", "aw");
        testVehicle3 = new Vehicle(3, 14, "asd", "asd");
        testVehicle4 = new Vehicle(1, 15, "asdf", "asdf");
    }

    @Test
    public void testGet() {
        when(mockedStore.get(anyInt())).thenReturn(fakeVehicle1);
        Vehicle returnedVehicle = subject.get(1);
        assertEquals("get must return appropriate vehicle", fakeVehicle1, returnedVehicle);
    }

    @Test
    public void testGetStoreEmpty() {
        when(mockedStore.get(anyInt())).thenReturn(null);
        Vehicle returnedVehicle = subject.get(1);
        assertNull("when the store is empty get null", returnedVehicle);
    }

    @Test
    public void testGetAllStoreNonEmpty() {
        when(mockedStore.values()).thenReturn(allVehicles);
        Collection<Vehicle> allReturned = subject.getAll();
        assertEquals("get all should return all the vehicles", allVehicles, allReturned);
    }

    @Test
    public void testGetAllStoreNonEmptyClear() {
        when(mockedStore.values()).thenReturn(allVehicles);
        Collection<Vehicle> allReturned = subject.getAll();
        allReturned.clear();
        assertNotEquals("get all should no written a reference to it's internal data structure", allVehicles, allReturned);
    }

    @Test
    public void testGetAllStoreEmpty() {
        allVehicles.clear();
        when(mockedStore.values()).thenReturn(allVehicles);
        Collection<Vehicle> returned = subject.getAll();
        assertNotNull("returned collection should not be null", returned);
        assertTrue("returned collection should be empty", returned.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testUpdateIdNotPresent() {
        when(fakeVehicle1.getId()).thenReturn(1);
        when(mockedStore.containsKey(1)).thenReturn(false);
        subject.update(fakeVehicle1);
    }

    @Test
    public void testUpdateIdPresent() {
        when(fakeVehicle1.getId()).thenReturn(1);
        when(mockedStore.containsKey(1)).thenReturn(true);
        subject.update(fakeVehicle1);
        verify(mockedStore).put(1, fakeVehicle1);
    }

    @Test
    public void testCreateIdExists() {
        subject.create(testVehicle1);
        subject.create(testVehicle2);
        subject.create(testVehicle3);
        subject.delete(3);
        assertEquals("created object should get highest id", 4, subject.create(testVehicle4).getId());
    }

    @Test
    public void testDeleteIdExists() {
        when(mockedStore.remove(5)).thenReturn(fakeVehicle1);
        assertTrue("if id exists, delete should return true", subject.delete(5));
    }

    @Test
    public void testDeleteIdDoesNotExist() {
        when(mockedStore.remove(5)).thenReturn(null);
        assertFalse("if id does not exist, delete should return false", subject.delete(5));
    }
}
