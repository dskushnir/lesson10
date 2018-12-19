package ua.hillel.lesson10;


import org.junit.Test;

import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class MyListTest {
    @Test

            public void addTest() {
        MyList<String> list = new MyList<>();
        assertTrue(list.isEmpty());
        list.add("1");
        list.add("2");
        list.add("3");
        assertFalse(list.isEmpty());
        MyList.Node<String>tail=list.tail();
        assertEquals(tail.getValue(),"3");
        list.remove("2");
        list.iterate(System.out::println);
        System.out.println(list.get(1));
        assertTrue(list.size()==3);
        assertTrue(list.contains("3"));
        assertFalse(list.contains("4"));
        assertArrayEquals(new Object[]{"1","2","3"},list.toArray());

       /* for (String s : list){
            System.out.println(s);
        }
        */

            
        }
        

    }



        }
      
            
        }
       
            
        }
        
            
        }
        }


    }




}
