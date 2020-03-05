package PetRock;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by u0139221 on 2/21/2020.
 */
public class PetRockTest {
    @Test
    public void getName() throws Exception {
       PetRock rocky = new PetRock("Rocky");
        assertEquals("Rocky",rocky.getName());
    }

}