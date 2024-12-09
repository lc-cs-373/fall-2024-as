//AndPrim:top//
//AndPrim:import//
import java.util.*;

// <prim>:AndPrim ::= ANDOP
public class AndPrim extends Prim /*AndPrim:class*/ {

    public static final String $className = "AndPrim";
    public static final String $ruleString =
        "<prim>:AndPrim ::= ANDOP";



    public AndPrim() {
//AndPrim:init//

    }

    public static AndPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:AndPrim", scn$.lno);
        scn$.match(Token.Match.ANDOP, trace$);
        return new AndPrim();
    }

    public String toString() {
      return "and";
    }
    
    public Val apply(Val [] va) {
      boolean b0 = va[0].boolVal().val;
      boolean b1 = va[1].boolVal().val;
      return new BoolVal(b0 && b1);
    }
    
    public ProcType definedType() {
      return Type.bb_b;
    }

//AndPrim//
}
