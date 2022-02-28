import java.util.ArrayDeque;

public class PlayToBeatInfrequentPlays implements Player{
    public PlayToBeatInfrequentPlays(int n) {
        N = n;
    }

    @Override
    public int getMove() {
        truncate();
        int rock = 0;
        int paper =0 ;
        int scissors  =0;
        for (Integer move : moves) {
            switch(move){
                case RPS.ROCK:
                    rock++;
                    continue;
                case RPS.PAPER:
                    paper++;
                    continue;
                case RPS.SCISSORS:
                    scissors++;

            }
        }
        return getMoveToBeat(getInfrequent(rock,paper,scissors));
    }

    private int getInfrequent(int rock, int paper, int scissors) {
       int e =  Math.min(rock,Math.min(paper,scissors));
        if (e==rock){
            return RPS.ROCK;
        }else if (e==paper){
            return RPS.PAPER;
        }else return RPS.SCISSORS;

    }

    private int getMoveToBeat(int played) {
        if (played == RPS.ROCK) return RPS.PAPER;
        if (played == RPS.SCISSORS) return RPS.ROCK;
        return RPS.SCISSORS;
    }
    public void truncate(){
        while(moves.size()>N){
           moves.removeLast();
        }
    }
    int N;
   java.util.ArrayDeque<Integer> moves = new ArrayDeque<>();
    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        moves.addFirst(opponentMove);
    }
}
