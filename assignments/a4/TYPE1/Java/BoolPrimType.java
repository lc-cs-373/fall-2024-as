//BoolPrimType:top//
//BoolPrimType:import//
import java.util.*;

// <primType>:BoolPrimType ::= BOOL
public class BoolPrimType extends PrimType /*BoolPrimType:class*/ {

    public static final String $className = "BoolPrimType";
    public static final String $ruleString =
        "<primType>:BoolPrimType ::= BOOL";



    public BoolPrimType() {
//BoolPrimType:init//

    }

    public static BoolPrimType parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<primType>:BoolPrimType", scn$.lno);
        scn$.match(Token.Match.BOOL, trace$);
        return new BoolPrimType();
    }

    public Type toType() {
      return new BoolType();
    }

//BoolPrimType//
}
