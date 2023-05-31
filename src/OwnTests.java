import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.*;

public class OwnTests {
    Game g;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        g = new Game();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        g.reset();
    }

    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void GameInitTest() {
        assertNotNull(g.b);
        assertEquals(g.getCurrentTurn(), Side.WHITE);
    }

    @Tag("score:2")
    @org.junit.jupiter.api.Test
    void PawnMoveTest1() {
        int startX = 3;
        int startY = 1;
        //check constructor
        assertNotNull(g.b.get(startX,startY).x);
        assertNotNull(g.b.get(startX,startY).y);
        assertNotNull(g.b.get(startX,startY).board);
        assertNotNull(g.b.get(startX,startY).getSide());

        //check symbol
        String symbol= "♟";
        assertTrue(g.b.get(startX,startY) instanceof Pawn);

        assertTrue(g.b.get(startX,startY).canMove(3,2));
        assertTrue(g.b.get(startX,startY).canMove(3,3));

        assertEquals(g.b.get(startX,startY).getSymbol(), symbol);
        assertFalse(g.b.get(startX,startY).canMove(2,0));
        assertFalse(g.b.get(startX,startY).canMove(2,1));
        assertFalse(g.b.get(startX,startY).canMove(2,2));
        assertFalse(g.b.get(startX,startY).canMove(2,3));
        assertFalse(g.b.get(startX,startY).canMove(2,4));
        assertFalse(g.b.get(startX,startY).canMove(2,5));
        assertFalse(g.b.get(startX,startY).canMove(2,6));
        assertFalse(g.b.get(startX,startY).canMove(2,7));
}
    @Tag("score:3")
    @org.junit.jupiter.api.Test
    void canMoveTest3() {
    assertTrue(g.canMove(1, 7, 0, 5, g.getCurrentTurn()));
    assertTrue(g.canMove(1, 7, 2, 5, g.getCurrentTurn()));
    assertTrue(g.canMove(6, 7, 5, 5, g.getCurrentTurn()));
    assertTrue(g.canMove(6, 7, 7, 5, g.getCurrentTurn()));
}
}
