package decide.datastructures;

import decide.Constants;

public class LogicalConnectorMatrix {
    public enum LCMValue {
        ANDD,
        ORR,
        NOTUSED,
    }

    public LCMValue[][] matrix = new LCMValue[Constants.MATRIX_SIZE][Constants.MATRIX_SIZE];
}
