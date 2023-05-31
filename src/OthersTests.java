import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OthersTests {

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

    @Tag("GamePerso2")
    @org.junit.jupiter.api.Test
    void gamePerso2() {
        /*
        The 1st getCurrentTurn checks if the current turn is white when the game starts
        And the other 2 checks if it gets correctly updated.
         */
    assertEquals(g.getCurrentTurn(), Side.WHITE);
    g.move(4, 6, 4, 4);
    assertEquals(g.getCurrentTurn(), Side.BLACK);
    g.move(4, 1, 4, 3);
    assertEquals(g.getCurrentTurn(), Side.WHITE);
    g.move(6, 7, 5, 5);
    g.move(1, 0, 2, 2);
        /*
        The 1st assertFalse(g.move(...)) checks whether you can move a null Piece
        The 2nd one checks whether you can move a Piece which is not your color
        The 3rd one checks whether you can move a Piece which is your color and in a correct location,
            but to an incorrect location
        The 4th one checks whether you can move a Piece which is your color and in a correct location,
            but there is a another Piece blocking the way
        The 5th one checks for out of bounds scenario
         */
    assertFalse(g.move(2, 4, 2, 3));
    assertFalse(g.move(4, 0, 4, 1));
    assertFalse(g.move(1, 7, 2, 4));
    assertFalse(g.move(3, 7, 3, 2));
    assertFalse(g.move(10, 0, 0, 10));
    g.move(5, 7, 2, 4);
    g.move(6, 0, 5, 2);
    g.move(3, 6, 3, 4);
    g.move(4, 3, 3, 4);
    g.move(4, 7, 5, 7);
    g.move(5, 0, 2, 3);
    g.move(4, 4, 4, 3);
    g.move(3, 1, 3, 3);
    g.move(4, 3, 5, 2);
    g.move(3, 3, 2, 4);
    g.move(3, 7, 4, 7);
    // There are a few checks for isInCheck along the test
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(4, 0, 5, 0);
    g.move(2, 7, 6, 3);
    g.move(6, 1, 5, 2);
    g.move(6, 3, 7, 2);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(5, 0, 6, 0);
    g.move(1, 7, 2, 5);
    g.move(2, 0, 6, 4);
    g.move(2, 5, 4, 4);
    g.move(1, 1, 1, 2);
    g.move(2, 6, 2, 5);
    g.move(2, 2, 4, 3);
    g.move(4, 7, 3, 7);
    g.move(0, 1, 0, 3);
    g.move(5, 5, 4, 3);
    g.move(6, 4, 3, 7);
    g.move(4, 3, 3, 1);
    g.move(2, 3, 4, 1);
    g.move(4, 4, 5, 2);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(4, 3, 3, 1);
    g.move(2, 3, 4, 1);
    g.move(4, 4, 5, 2);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(4, 1, 5, 2);
    g.move(0, 7, 3, 7);
    g.move(1, 2, 1, 3);
    g.move(3, 7, 4, 7);
    g.move(1, 3, 1, 4);
    g.move(4, 7, 4, 0);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(3, 0, 4, 0);
    g.move(3, 1, 5, 2);
    g.move(6, 0, 6, 1);
    assertTrue(g.isInCheck(Side.BLACK));
    assertFalse(g.isInCheck(Side.WHITE));
    g.move(7, 2, 6, 1);
    // Here it checks whether the game still continues after there is a winner
    assertEquals(g.getCurrentTurn(), Side.WHITE);
    g.move(4, 0, 4, 1);
    assertEquals(g.getCurrentTurn(), Side.WHITE);
    g.move(4, 0, 3, 0);
    assertEquals(g.getCurrentTurn(), Side.WHITE);

    String[] solutions = new String[]{
            "WHITE♙ at 4, 6 to 4, 4",
            "BLACK♟ at 4, 1 to 4, 3",
            "WHITE♘ at 6, 7 to 5, 5",
            "BLACK♞ at 1, 0 to 2, 2",
            "WHITE♗ at 5, 7 to 2, 4",
            "BLACK♞ at 6, 0 to 5, 2",
            "WHITE♙ at 3, 6 to 3, 4",
            "BLACK♟ at 4, 3 captures ♙ at 3, 4",
            "WHITE♔ at 4, 7 to 5, 7",
            "BLACK♝ at 5, 0 to 2, 3",
            "WHITE♙ at 4, 4 to 4, 3",
            "BLACK♟ at 3, 1 to 3, 3",
            "WHITE♙ at 4, 3 captures ♞ at 5, 2",
            "BLACK♟ at 3, 3 captures ♗ at 2, 4",
            "WHITE♕ at 3, 7 to 4, 7",
            "BLACK is in check",
            "BLACK♚ at 4, 0 to 5, 0",
            "WHITE♗ at 2, 7 to 6, 3",
            "BLACK♟ at 6, 1 captures ♙ at 5, 2",
            "WHITE♗ at 6, 3 to 7, 2",
            "BLACK is in check",
            "BLACK♚ at 5, 0 to 6, 0",
            "WHITE♘ at 1, 7 to 2, 5",
            "BLACK♝ at 2, 0 to 6, 4",
            "WHITE♘ at 2, 5 to 4, 4",
            "BLACK♟ at 1, 1 to 1, 2",
            "WHITE♙ at 2, 6 to 2, 5",
            "BLACK♞ at 2, 2 to 4, 3",
            "WHITE♕ at 4, 7 to 3, 7",
            "BLACK♟ at 0, 1 to 0, 3",
            "WHITE♘ at 5, 5 captures ♞ at 4, 3",
            "BLACK♝ at 6, 4 captures ♕ at 3, 7",
            "WHITE♘ at 4, 3 to 3, 1",
            "BLACK♝ at 2, 3 to 4, 1",
            "WHITE♘ at 4, 4 captures ♟ at 5, 2",
            "BLACK is in check",
            "BLACK♝ at 4, 1 captures ♘ at 5, 2",
            "WHITE♖ at 0, 7 captures ♝ at 3, 7",
            "BLACK♟ at 1, 2 to 1, 3",
            "WHITE♖ at 3, 7 to 4, 7",
            "BLACK♟ at 1, 3 to 1, 4",
            "WHITE♖ at 4, 7 to 4, 0",
            "BLACK is in check",
            "BLACK♛ at 3, 0 captures ♖ at 4, 0",
            "WHITE♘ at 3, 1 captures ♝ at 5, 2",
            "BLACK is in check",
            "BLACK♚ at 6, 0 to 6, 1",
            "BLACK is in check",
            "WHITE♗ at 7, 2 captures ♚ at 6, 1",
            "WHITE has won"
    };
    // Here it checks whether you have the correct moveHistory list
    assertEquals(g.moveHistory().length, solutions.length);
    for (int i = 0; i < g.moveHistory().length; i++) {
        if(!solutions[i].equals(g.moveHistory()[i])){
            fail("Move history is not correct! Expected: " + solutions[i] + " Actual: " + g.moveHistory()[i] + " at index " + i);
        }
    }
}
    @Tag("weird_behaviour")
    @org.junit.jupiter.api.Test
    void weirdTest(){
        assertTrue(g.move(5, 6, 5, 4));
        assertEquals(g.getCurrentTurn(), Side.BLACK);
        assertTrue(g.move(4,1,4,2));
        assertEquals(g.getCurrentTurn(), Side.WHITE);

        assertTrue(g.move(1, 7, 0, 5));
        assertEquals(g.getCurrentTurn(), Side.BLACK);

        assertTrue(g.move(3,0,7,4));
        assertEquals(g.getCurrentTurn(), Side.WHITE);

        assertTrue(g.move(1,6,1,5));
        assertEquals(g.getCurrentTurn(), Side.BLACK);

        assertTrue(g.move(7,4,4,7));
    }

    @Tag("GamePerso5")
    @org.junit.jupiter.api.Test
    void gamePerso5() {
        g.move(4, 6, 4, 4);
        g.move(3, 1, 3, 3);
        g.move(4, 4, 3, 3);
        g.move(3, 0, 3, 3);
        g.move(1, 7, 2, 5);
        g.move(3, 3, 3, 0);
        g.move(3, 6, 3, 4);
        g.move(1, 0, 2, 2);
        g.move(6, 7, 5, 5);
        g.move(2, 0, 6, 4);
        g.move(3, 4, 3, 3);
        g.move(2, 2, 4, 3);
        g.move(5, 5, 4, 3);
        g.move(6, 4, 3, 7);
        g.move(5, 7, 1, 3);
        g.move(2, 1, 2, 2);
        g.move(3, 3, 2, 2);
        g.move(3, 0, 2, 1);
        g.move(2, 2, 1, 1);
        g.move(4, 0, 3, 0);
        g.move(4, 3, 5, 1);
        g.move(3, 0, 3, 1);
        g.move(1, 3, 3, 1);
        String[] solutions = new String[]{
                "WHITE♙ at 4, 6 to 4, 4",
                "BLACK♟ at 3, 1 to 3, 3",
                "WHITE♙ at 4, 4 captures ♟ at 3, 3",
                "BLACK♛ at 3, 0 captures ♙ at 3, 3",
                "WHITE♘ at 1, 7 to 2, 5",
                "BLACK♛ at 3, 3 to 3, 0",
                "WHITE♙ at 3, 6 to 3, 4",
                "BLACK♞ at 1, 0 to 2, 2",
                "WHITE♘ at 6, 7 to 5, 5",
                "BLACK♝ at 2, 0 to 6, 4",
                "WHITE♙ at 3, 4 to 3, 3",
                "BLACK♞ at 2, 2 to 4, 3",
                "WHITE♘ at 5, 5 captures ♞ at 4, 3",
                "BLACK♝ at 6, 4 captures ♕ at 3, 7",
                "WHITE♗ at 5, 7 to 1, 3",
                "BLACK is in check",
                "BLACK♟ at 2, 1 to 2, 2",
                "WHITE♙ at 3, 3 captures ♟ at 2, 2",
                "BLACK♛ at 3, 0 to 2, 1",
                "WHITE♙ at 2, 2 captures ♟ at 1, 1",
                "BLACK is in check",
                "BLACK♚ at 4, 0 to 3, 0",
                "WHITE♘ at 4, 3 captures ♟ at 5, 1",
                "BLACK is in check",
                "BLACK♚ at 3, 0 to 3, 1",
                "BLACK is in check",
                "WHITE♗ at 1, 3 captures ♚ at 3, 1",
                "WHITE has won"
        };
        assertEquals(g.moveHistory().length, solutions.length);
        for (int i = 0; i < g.moveHistory().length; i++) {
            if(!solutions[i].equals(g.moveHistory()[i])){
                fail("Move history is not correct! Expected: " + solutions[i] + " Actual: " + g.moveHistory()[i] + " at index " + i);
            }
        }
    }

    @Tag("score:0")
    @org.junit.jupiter.api.Test
    void pawnCheckTest() {
        assertTrue(g.move(4, 6, 4, 4));
        assertTrue(g.move(3, 1, 3, 3));
        // WHITE pawn captures BLACK pawn
        assertTrue(g.move(4, 4, 3, 3));
        assertTrue(g.move(2, 1, 2, 3));
        assertTrue(g.move(3, 3, 3, 2));
        assertTrue(g.move(2, 3, 2, 4));
        // WHITE checks BLACK
        assertTrue(g.move(3, 2, 3, 1));
        assertTrue(g.isInCheck(Side.BLACK));
        assertFalse(g.isInCheck(Side.WHITE));
        // BLACK moves while still in check
        assertTrue(g.move(2, 4, 2, 5));
        assertTrue(g.isInCheck(Side.BLACK));
        assertFalse(g.isInCheck(Side.WHITE));
        // WHITE pawn captures BLACK king
        assertTrue(g.move(3, 1, 4, 0));

        // check if the message "WHITE has won" is correctly displayed
        String lastMessage = g.moveHistory()[g.moveHistory().length-1];
        System.out.println(lastMessage);
        assertTrue(lastMessage.equals("WHITE has won"));
    }





}
