/** Test for Selection.java
 *  
 *  Selection team: Zhou/ Luo/ Graber/ Dr.fenwick
 *
 *  version:1.0
 *
 *  author: Yuanbo Zhou
 *
 */

import static org.junit.jupiter.api.Assertion.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.*;

public class SelectionTest {
    
    static Scanner sc = new Scanner(System.in);

    @Test
    public void testUserName() {

        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine(); 
        assertEquals("yuanboz",username);
       
        
    }
}
