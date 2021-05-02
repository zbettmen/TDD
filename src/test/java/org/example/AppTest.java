package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    private IntArray intArrays;
    @BeforeEach
    public void test(){
      int [] intArray = {1,2,2,4,5,5,6,1,4,10};
        intArrays = new IntArray(intArray);
  }

    @Test
    public void testGetAverage(){
        assertEquals(4.0,intArrays.getAverage());
    }

    @Test
    public void testFindPositions(){
        int[] positionTestArr = new int[]{4,5};
        assertArrayEquals(positionTestArr, intArrays.findPositions(5));
    }


    @Test
    public void testFindPositionEmpty(){
        intArrays.setArray(new int[]{});
        assertThrows(IllegalArgumentException.class,()->intArrays.findPositions(100000000));
    }


    @Test
    public void testAppendLast(){
        int[] resultExpected = {1,2,2,4,5,5,6,1,4,10,7};
        intArrays.appendLast(7);
        assertArrayEquals(resultExpected, intArrays.getIntArray());
    }

    @Test
    public void testInsertAt(){
        int[] expected = {1,2,2,4,7,5,5,6,1,4,10};
        intArrays.insertAt(4,7);
        assertArrayEquals(expected, intArrays.getIntArray());
    }
    @Test
    public void testInsertAtEmpty(){
        intArrays.setArray(new int[]{});
        intArrays.insertAt(0,100);
        int [] expected = {100};
        assertArrayEquals(expected,intArrays.getIntArray());
    }



    @Test
    public void testInsertAtPositionOutOfBounds(){
        assertThrows(ArrayIndexOutOfBoundsException.class,()-> intArrays.insertAt(13,0));
    }

    @Test
    public void testGetAt(){
        assertEquals(10, intArrays.getAt(9));
        assertEquals(4, intArrays.getAt(8));
    }

    @Test
    public void testGetAtPositionOutOfBounds(){
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> intArrays.getAt(10));
    }
    @Test
    public void testSetAt(){
        intArrays.setAt(7, 1);
        assertEquals(1, intArrays.getAt(7));
    }

    @Test
    public void testDeleteAt(){
        int[] testArr = {1,2,2,4,5,6,1,4,10};
        assertEquals(intArrays.deleteAt(5), 5);
        assertArrayEquals(testArr, intArrays.getIntArray());
    }

    @Test
    public void testDeleteAtNonExistingPosition(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> intArrays.deleteAt(99));
    }


}
