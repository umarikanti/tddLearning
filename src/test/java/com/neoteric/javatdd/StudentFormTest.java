package com.neoteric.javatdd;

import com.neoteric.javatdd.student.StudentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


//@ExtendWith(MockitoExtension.class)

public class StudentFormTest {
private StudentService studentServiceMoke;
//Student student= new Student();

    @Test
    public  void testAddWithNormalValues(){

        //Arrange
       when(studentServiceMoke.add(1,2)).thenReturn(3) ;
       //Act
       Integer result = studentServiceMoke.add(1,2);
        //Assert
        assertEquals(3, result);

    }




    @Test
    public void testAddWithZeroValues() {
        // Arrange
        when(studentServiceMoke.add(0, 0)).thenReturn(0);

        // Act
        int result = studentServiceMoke.add(0, 0);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testAddWithNegativeValues() {
        // Arrange
        when(studentServiceMoke.add(-1, -2)).thenReturn(-3);

        // Act
        int result = studentServiceMoke.add(-1, -2);

        // Assert
        assertEquals(-3, result);
    }

    @Test
    public void testAddWithMixedValues() {
        // Arrange
        when(studentServiceMoke.add(-1, 2)).thenReturn(1);

        // Act
        int result = studentServiceMoke.add(-1, 2);

        // Assert
        assertEquals(1, result);
    }

}
