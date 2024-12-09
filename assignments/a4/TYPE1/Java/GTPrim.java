//GTPrim:top//
//GTPrim:import//
import java.util.*;

// <prim>:GTPrim ::= GTP
public class GTPrim extends Prim /*GTPrim:class*/ {

    public static final String $className = "GTPrim";
    public static final String $ruleString =
        "<prim>:GTPrim ::= GTP";



    public GTPrim() {
//GTPrim:init//

    }

    public static GTPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:GTPrim", scn$.lno);
        scn$.match(Token.Match.GTP, trace$);
        return new GTPrim();
    }

    public String toString() {
      return ">?";
    }
    
    public Val apply(Val [] va) {
      int i0 = va[0].intVal().val;
      int i1 = va[1].intVal().val;
      return new BoolVal(i0 > i1);
    }
    
    public ProcType definedType() {
      return Type.ii_b;
    }

//GTPrim//
}
