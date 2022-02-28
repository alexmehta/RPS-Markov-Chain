

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

class State {
    Object[] prevmove;
    boolean wonLastMove;

    public State(Object[] prevmove, boolean wonLastMove) {
        this.prevmove =  prevmove;
        this.wonLastMove = wonLastMove;
    }

    public Object[] getPrevmove() {
        return prevmove;
    }

    public void setPrevmove(Object[] prevmove) {
        this.prevmove = prevmove;
    }

    public void setPrevmove(Integer[] prevmove) {
        this.prevmove = prevmove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return isWonLastMove() == state.isWonLastMove() && Arrays.equals(getPrevmove(), state.getPrevmove());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(isWonLastMove());
        result = 31 * result + Arrays.hashCode(getPrevmove());
        return result;
    }

    public boolean isWonLastMove() {
        return wonLastMove;
    }

    public void setWonLastMove(boolean wonLastMove) {
        this.wonLastMove = wonLastMove;
    }
}

public class AdvancedStatePlayer extends MarkovParent implements Player {
    HashMap<State, Integer[]> states = new HashMap<>();
    State last = null;

    @Override
    public int getMove() {
        if (states == null) return 0;
        if (!states.containsKey(last)){
            states.put(last,new Integer[]{0,0,0});
        }
        int r = (int) (Math.random() * (getSize(states.get(last)) + 1));
        return getMoveToBeat(getOpp(r, states.get(last)));
    }
    final static int N = 2;
    ArrayDeque<Integer> keepLastN = new ArrayDeque<>();
    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
       State state =  new State(keepLastN.toArray(),outcome==RPS.YOU);
        Integer[] arr;
        if (states.containsKey(state)){
            arr = states.get(state);
        }else{
            arr = new Integer[]{0,0,0};
        }
        arr[opponentMove]++;
        states.put(state,arr) ;
        if (keepLastN.size()>N){
              keepLastN.removeLast();
          }
          keepLastN.add(opponentMove);
    }
}
