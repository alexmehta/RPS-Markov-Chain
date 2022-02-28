public class MarkovParent {
    public int getSize(Integer[] arr) {
        int s = 0;
        for (int j : arr) {
            s += j;
        }
        return s;
    }
    public int getMoveToBeat(int played) {
        if (played == RPS.ROCK) return RPS.PAPER;
        if (played == RPS.SCISSORS) return RPS.ROCK;
        return RPS.SCISSORS;
    }

    public int getOpp(int p, Integer[] arr){
        if (arr[RPS.ROCK]<=p) return RPS.ROCK;
        if (arr[RPS.ROCK]+arr[RPS.PAPER]<=p)return RPS.PAPER;
        return RPS.SCISSORS;
    }
}
