//TypeExp:top//
//TypeExp:import//
import java.util.*;

public abstract class TypeExp /*TypeExp:class*/ {

    public static final String $className = "TypeExp";
    public static TypeExp parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case LBRACK:
            return ProcTypeExp.parse(scn$,trace$);
        case INT:
        case BOOL:
            return PrimTypeExp.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "TypeExp cannot begin with " + t$.errString()
            );
        }
    }

    public abstract Type toType();

//TypeExp//
}
