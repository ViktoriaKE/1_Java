package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the {@link Container} class.
 */
public class ContainerTest {

    private Container<String> container;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @BeforeEach
    public void setUp() {
        container = new Container<>();
    }

    /**
     * Tests the {@link Container#add(Object)} and {@link Container#size()} methods.
     */
    @Test
    public void testAddAndSize() {
        container.add("one");
        container.add("two");
        container.add("three");

        assertEquals(3, container.size());
    }

    /**
     * Tests the {@link Container#get(int)} method.
     */
    @Test
    public void testGet() {
        container.add("one");
        container.add("two");
        container.add("three");

        assertEquals("one", container.get(0));
        assertEquals("two", container.get(1));
        assertEquals("three", container.get(2));

        assertThrows(IndexOutOfBoundsException.class, () -> container.get(3));
    }

    /**
     * Tests the {@link Container#remove(int)} method.
     */
    @Test
    public void testRemove() {
        container.add("one");
        container.add("two");
        container.add("three");

        container.remove(1);

        assertEquals(2, container.size());
        assertEquals("one", container.get(0));
        assertEquals("three", container.get(1));

        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(2));
    }

    /**
     * Tests the {@link Container#iterator()} method.
     */
    @Test
    public void testIterator() {
        container.add("one");
        container.add("two");
        container.add("three");

        Iterator<String> iterator = container.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("one", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("two", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("three", iterator.next());
        assertFalse(iterator.hasNext());

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    /**
     * Tests the {@link Container#toString()} method.
     */
    @Test
    public void testToString() {
        container.add("one");
        container.add("two");
        container.add("three");

        assertEquals("[one, two, three]", container.toString());
    }

    /**
     * Tests the {@link Container#hashCode()} method.
     */
    @Test
    public void testHashCode() {
        container.add("one");
        container.add("two");
        container.add("three");

        int hashCode1 = container.hashCode();

        container.add("four");

        int hashCode2 = container.hashCode();

        assertNotEquals(hashCode1, hashCode2);
    }
}
