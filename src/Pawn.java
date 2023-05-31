//version 11pm
public class Pawn extends Piece{
    public Pawn(int x, int y, Side side, Board board) {

        //call super constructor of superclass Piece
        super(x, y, side, board);
    }
    @Override
    public boolean canMove(int destX, int destY) {
        //move on empty board

        //not move forward
        if(getSide()==Side.WHITE && destY-y>0){return false;}

        if(getSide()==Side.BLACK && destY-y<0){return false;}

        //diagonal capture
        if(Math.abs(destX-this.x)==1 && Math.abs(destY-this.y)==1){
            if(board.get(destX,destY)==null){return false;}
            return true;}

        //two steps for first move
        if(Math.abs(destY-y)==2 && destX==x){

            //not pawn's first move
            if(y!=1 && y!= 6 ){return false;}

            //pawn's first move
            else{
                //has a piece at destination
                if(board.get(destX,destY)!=null){return false;}

                //does not have piece at the destination
                return true;}
        }

        //regular step
        if ((this.x == destX && this.y + 1 == destY) || (this.x == destX && this.y - 1 == destY)){
            //has a piece at destination
            if(board.get(destX,destY)!=null){return false;}

            //does not have piece at the destination
            return true;
        }
        //false if no above conditions is met
        return false;
    }

    @Override
    public String getSymbol() {return this.getSide() == Side.BLACK ? "♟" : "♙";}
}

