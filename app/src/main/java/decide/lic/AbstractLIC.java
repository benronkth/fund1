package decide.lic;

import decide.datastructures.Parameters;
import decide.datastructures.Point;

public abstract class AbstractLIC {

    public abstract boolean compute(Point[] points, Parameters parameters);
}
