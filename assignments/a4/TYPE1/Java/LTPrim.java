//LTPrim:top//
//LTPrim:import//
import java.util.*;

// <prim>:LTPrim ::= LTP
public class LTPrim extends Prim /*LTPrim:class*/ {

    public static final String $className = "LTPrim";
    public static final String $ruleString =
        "<prim>:LTPrim ::= LTP";



    public LTPrim() {
//LTPrim:init//

    }

    public static LTPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:LTPrim", scn$.lno);
        scn$.match(Token.Match.LTP, trace$);
        return new LTPrim();
    }

    public String toString() {
      return "<?";
    }
    
    public Val apply(Val [] va) {
      int i0 = va[0].intVal().val;
      int i1 = va[1].intVal().val;
      return new BoolVal(i0 < i1);
    }
    
    public ProcType definedType() {
      return Type.ii_b;
    }

//LTPrim//
}
