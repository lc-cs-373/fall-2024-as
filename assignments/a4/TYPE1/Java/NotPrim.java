//NotPrim:top//
//NotPrim:import//
import java.util.*;

// <prim>:NotPrim ::= NOTOP
public class NotPrim extends Prim /*NotPrim:class*/ {

    public static final String $className = "NotPrim";
    public static final String $ruleString =
        "<prim>:NotPrim ::= NOTOP";



    public NotPrim() {
//NotPrim:init//

    }

    public static NotPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:NotPrim", scn$.lno);
        scn$.match(Token.Match.NOTOP, trace$);
        return new NotPrim();
    }

    public String toString() {
      return "not";
    }
    
    public Val apply(Val [] va) {
      boolean b0 = va[0].boolVal().val;
      return new BoolVal(!b0);
    }
    
    public ProcType definedType() {
      return Type.b_b;
    }

//NotPrim//
}
