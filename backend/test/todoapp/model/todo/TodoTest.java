package todoapp.model.todo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TodoTest {
    private Todo todo;

    @Before
    public void setUp() throws Exception {
        todo = new Todo();
    }

    @Test
    public void testGetStar() {
        todo.setImportance(2);
        assertEquals("★★", todo.getStar());
    }

}
