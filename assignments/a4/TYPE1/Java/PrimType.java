//PrimType:top//
//PrimType:import//
import java.util.*;

public abstract class PrimType /*PrimType:class*/ {

    public static final String $className = "PrimType";
    public static PrimType parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case INT:
            return IntPrimType.parse(scn$,trace$);
        case BOOL:
            return BoolPrimType.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "PrimType cannot begin with " + t$.errString()
            );
        }
    }

    public abstract Type toType();

//PrimType//
}
