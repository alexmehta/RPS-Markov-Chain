public class MarkovPlayer implements Player {
    int[][] m = new int[3][3];
    int p = -1;
    @Override
    public int getMove() {
        return getMoveToBeat(getOpp());
    }
    @Override
    public void saveLastRoundData(int yourMove, int o, int outcome) {
        if (p != -1) {
            m[p][o]++;
        }
        p = o;
    }
    private int getMoveToBeat(int played) {
        if (played == RPS.ROCK) return RPS.PAPER;
        if (played == RPS.SCISSORS) return RPS.ROCK;
        return RPS.SCISSORS;
    }
    private int getOpp() {
        if (p==-1)return 0;
        int n = getSize(m[p]);
        int rand = (int) (Math.random() * (n + 1));
        if (rand <= m[p][RPS.ROCK]) return RPS.ROCK;
        else if (rand <= m[p][RPS.ROCK] + m[p][RPS.PAPER]) return RPS.PAPER;
        else return RPS.SCISSORS;
    }
    private int getSize(int[] arr) {
        int s = 0;
        for (int j : arr) {
            s += j;
        }
        return s;
    }
}
