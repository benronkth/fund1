package decide.datastructures;

import decide.Constants;

public class LogicalConnectorMatrix {
    public enum LCMValue {
        NOTUSED,
        ANDD,
        ORR,
    }

    public LCMValue[][] matrix = new LCMValue[Constants.MATRIX_SIZE][Constants.MATRIX_SIZE];

    public LogicalConnectorMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = LCMValue.NOTUSED;
            }
        }
    }
}
