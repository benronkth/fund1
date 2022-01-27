package decide.datastructures;

import decide.Constants;

public class FinalUnlockingVector {
    public boolean[] matrix = new boolean[Constants.MATRIX_SIZE];

    // Create a FUV from a PUM and PUV
    public FinalUnlockingVector(PreliminaryUnlockingMatrix pum, PreliminaryUnlockingVector puv) {
        for (int i = 0; i < Constants.MATRIX_SIZE; i++) {
            if (!puv.matrix[i]) {
                this.matrix[i] = true;
            } else {
                boolean sum = true;
                for (int j = 0; j < Constants.MATRIX_SIZE; j++) {
                    if (i == j) {
                        continue;
                    }
                    sum = sum && pum.matrix[i][j];
                }
                this.matrix[i] = sum;
            }
        }
    }

    public boolean shouldLaunch() {
        for (int i = 0; i < matrix.length; i++) {
            if (!matrix[i]) {
                return false;
            }
        }
        return true;
    }
}
