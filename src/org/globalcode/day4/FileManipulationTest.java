package org.globalcode.day4;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class FileManipulationTest {

    @Test
    public void countWordInString(){
        assertEquals("Count in String",FileManipulation.countWordsInString("This is   Ama."), 3);
    }

    @Test
    public void countWordsMoreThan5Characters(){
        assertEquals("Count for Words more than 5 characters",FileManipulation.countWordsMoreThan5Characters("This is Ama."), 0);
    }
}