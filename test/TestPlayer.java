import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPlayer {

    @Test
    public void testValid(){
        Player player = new Player(ChessColor.WHITE);
        assertTrue(player.inputValid("A,1 B,2"));
        assertTrue(player.inputValid("B,2 B,5"));
        assertTrue(player.inputValid("C,6 B,6"));
        assertTrue(player.inputValid("D,7 D,6"));
    }

    @Test
    public void testInvalid(){
        Player player = new Player(ChessColor.WHITE);
        assertFalse(player.inputValid("Z,3 B,9"));
        assertFalse(player.inputValid("G,1 J,11"));
        assertFalse(player.inputValid("G,9 J,7"));
    }




}
