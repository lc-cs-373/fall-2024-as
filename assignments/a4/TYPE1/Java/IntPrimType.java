//IntPrimType:top//
//IntPrimType:import//
import java.util.*;

// <primType>:IntPrimType ::= INT
public class IntPrimType extends PrimType /*IntPrimType:class*/ {

    public static final String $className = "IntPrimType";
    public static final String $ruleString =
        "<primType>:IntPrimType ::= INT";



    public IntPrimType() {
//IntPrimType:init//

    }

    public static IntPrimType parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<primType>:IntPrimType", scn$.lno);
        scn$.match(Token.Match.INT, trace$);
        return new IntPrimType();
    }

    public Type toType() {
      return new IntType();
    }

//IntPrimType//
}
