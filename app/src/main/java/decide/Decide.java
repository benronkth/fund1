package decide;

import decide.datastructures.ConditionsMetVector;
import decide.datastructures.FinalUnlockingVector;
import decide.datastructures.LogicalConnectorMatrix;
import decide.datastructures.Parameters;
import decide.datastructures.Point;
import decide.datastructures.PreliminaryUnlockingMatrix;
import decide.datastructures.PreliminaryUnlockingVector;
import decide.lic.AbstractLIC;
import decide.lic.LIC0;
import decide.lic.LIC1;
import decide.lic.LIC10;
import decide.lic.LIC11;
import decide.lic.LIC12;
import decide.lic.LIC13;
import decide.lic.LIC14;
import decide.lic.LIC2;
import decide.lic.LIC3;
import decide.lic.LIC4;
import decide.lic.LIC5;
import decide.lic.LIC6;
import decide.lic.LIC7;
import decide.lic.LIC8;
import decide.lic.LIC9;

public class Decide {

    static AbstractLIC[] lics = new AbstractLIC[] {
        new LIC0(),
        new LIC1(),
        new LIC2(),
        new LIC3(),
        new LIC4(),
        new LIC5(),
        new LIC6(),
        new LIC7(),
        new LIC8(),
        new LIC9(),
        new LIC10(),
        new LIC11(),
        new LIC12(),
        new LIC13(),
        new LIC14(),
    }; 
    
    public static boolean decide(Point[] points, Parameters params, LogicalConnectorMatrix lcm, PreliminaryUnlockingVector puv ) {
        if (points.length < 2 || points.length > 100) {
            return false;
        }
        ConditionsMetVector cmv = new ConditionsMetVector();
        for (int i = 0; i < lics.length; i++) {
            cmv.matrix[i] = lics[i].compute(points, params);
        }
        
        PreliminaryUnlockingMatrix pum = new PreliminaryUnlockingMatrix(cmv, lcm);
        FinalUnlockingVector fuv = new FinalUnlockingVector(pum, puv);
        return fuv.shouldLaunch();
    }
}
