package decide.datastructures;

import decide.Constants;

public class PreliminaryUnlockingVector {
    public boolean[] matrix = new boolean[Constants.MATRIX_SIZE];

    public PreliminaryUnlockingVector() {}

    public static PreliminaryUnlockingVector allTrue() {
        PreliminaryUnlockingVector puv = new PreliminaryUnlockingVector();
        for (int i = 0; i < puv.matrix.length; i++) {
            puv.matrix[i] = true;
        }
        return puv;
    }
}
