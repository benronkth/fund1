package decide.datastructures;

import decide.Constants;

public class PreliminaryUnlockingMatrix {
    public boolean[][] matrix = new boolean[Constants.MATRIX_SIZE][Constants.MATRIX_SIZE];

    // Create a PUM from a CMV and LCM
    public PreliminaryUnlockingMatrix(ConditionsMetVector cmv, LogicalConnectorMatrix lcm) {
        for (int i = 0; i < Constants.MATRIX_SIZE; i++) {
            for (int j = 0; j < Constants.MATRIX_SIZE; j++) {
                LogicalConnectorMatrix.LCMValue value = lcm.matrix[i][j];
                boolean firstLIC = cmv.matrix[i];
                boolean secondLIC = cmv.matrix[j];
                boolean result = false;
                switch (value) {
                    case ANDD:
                        result = firstLIC && secondLIC;
                        break;
                    case ORR:
                        result = firstLIC || secondLIC;
                        break;
                    case NOTUSED:
                        result = true;
                        break;
                }
                this.matrix[i][j] = result;
            }
        }
    }
}
