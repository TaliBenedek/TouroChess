package touro.chess;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class QueenPieceTest {

    @Test
    public void copy()
    {
        //given
        Location location = new Location(3,4);
        QueenPiece queen = new QueenPiece(location, PieceColor.Black);

        //when
        QueenPiece copy = (QueenPiece)queen.copy();

        //then
        assertEquals(queen.getLocation().getColumn(), copy.getLocation().getColumn());
        assertEquals(queen.getLocation().getRow(), copy.getLocation().getRow());
        assertEquals(queen.getColor(), copy.getColor());
    }

    @Test
    public void getMoves() {
        //given
        Location startLocation = new Location(2, 1);
        QueenPiece queenPiece = new QueenPiece(startLocation, PieceColor.White);
        List<Move> expectedMoveList = new ArrayList<>();
        expectedMoveList.add(new Move(startLocation, new Location(2,0),false)); //expected horizontal move
        expectedMoveList.add(new Move(startLocation, new Location(0,1),false)); //expected vertical move
        expectedMoveList.add(new Move(startLocation, new Location(3,2),false)); //expected diagonal up & right
        expectedMoveList.add(new Move(startLocation, new Location(1,0),false)); //expected diagonal down & left
        expectedMoveList.add(new Move(startLocation, new Location(3,0),false)); //expected diagonal up & left
        expectedMoveList.add(new Move(startLocation, new Location(1,2),false)); //expected diagonal down & right

        //when
        List<Move> moveList = queenPiece.getMoves();

        //then
        //check horizontal
        assertEquals(moveList.get(0).getTo().getColumn(),expectedMoveList.get(0).getTo().getColumn());
        assertEquals(moveList.get(0).getTo().getRow(),expectedMoveList.get(0).getTo().getRow());
        //check vertical
        assertEquals(moveList.get(8).getTo().getColumn(),expectedMoveList.get(1).getTo().getColumn());
        assertEquals(moveList.get(8).getTo().getRow(),expectedMoveList.get(1).getTo().getRow());
        //check up&right
        assertEquals(moveList.get(16).getTo().getColumn(),expectedMoveList.get(2).getTo().getColumn());
        assertEquals(moveList.get(16).getTo().getRow(),expectedMoveList.get(2).getTo().getRow());
        //check down&left
        assertEquals(moveList.get(21).getTo().getColumn(),expectedMoveList.get(3).getTo().getColumn());
        assertEquals(moveList.get(21).getTo().getRow(),expectedMoveList.get(3).getTo().getRow());
        //check up&left
        assertEquals(moveList.get(22).getTo().getColumn(),expectedMoveList.get(4).getTo().getColumn());
        assertEquals(moveList.get(22).getTo().getRow(),expectedMoveList.get(4).getTo().getRow());
        //check down&right
        assertEquals(moveList.get(23).getTo().getColumn(),expectedMoveList.get(5).getTo().getColumn());
        assertEquals(moveList.get(23).getTo().getRow(),expectedMoveList.get(5).getTo().getRow());
     }
}