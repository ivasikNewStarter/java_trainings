package main;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestingTest {
     Testing t = new Testing();
      int a =2;
      int b =2;

    @org.junit.jupiter.api.Test
    void testadding() {
        assertEquals(4,t.adding(a,b));
    }

    @Test
    @Disabled
    void testcheckVolumeTrue (){
        int min = 3;
        int max = 7;
        int number = 4;
        assertTrue(t.checkVolume(min,max,number));
    }
    @Test
    @Disabled
    void testcheckVolumeFalse (){
        int min = 3;
        int max = 7;
        int number1= 2;
        int number2 = 9;
        assertFalse(t.checkVolume(min,max,number1));
        assertFalse(t.checkVolume(min,max,number2));
    }
}