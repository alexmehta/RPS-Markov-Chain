public class BeatLastWinningMovePlayer implements Player {
    private int lastWinningMove;
    @Override
    public int getMove() {
        return getMoveToBeat(lastWinningMove);
    }
    private int getMoveToBeat(int prev) {
        if (prev == RPS.ROCK) return RPS.PAPER;
        if (prev == RPS.SCISSORS) return RPS.ROCK;
        return RPS.SCISSORS;
    }
    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        if(outcome==RPS.TIE) saveLastRoundData(yourMove,opponentMove,RPS.YOU);
        else this.lastWinningMove = outcome == RPS.OPPONENT ? opponentMove : yourMove;
    }
}
