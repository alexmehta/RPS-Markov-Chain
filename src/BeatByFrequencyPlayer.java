import java.util.Arrays;

public class BeatByFrequencyPlayer implements Player {
    int[] times = new int[3];
    int total = 0;

    @Override
    public int getMove() {
        System.out.println(Arrays.toString(times));
        System.out.println(getOppMove());
        return getMoveToBeat(getOppMove());
    }

    private int getMoveToBeat(int played) {
        if (played == RPS.ROCK) return RPS.PAPER;
        if (played == RPS.SCISSORS) return RPS.ROCK;
        return RPS.SCISSORS;
    }
    public int getOppMove(){
        double p = Math.random() * total + 1;
        if (times[RPS.ROCK] >= p) return RPS.ROCK;
        else if ((times[RPS.PAPER] + times[RPS.ROCK]) >= p) return RPS.PAPER;
        else return RPS.SCISSORS;
    }
    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        total++;
        times[opponentMove]++;

    }
}
