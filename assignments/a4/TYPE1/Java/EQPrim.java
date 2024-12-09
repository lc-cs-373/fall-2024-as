//EQPrim:top//
//EQPrim:import//
import java.util.*;

// <prim>:EQPrim ::= EQP
public class EQPrim extends Prim /*EQPrim:class*/ {

    public static final String $className = "EQPrim";
    public static final String $ruleString =
        "<prim>:EQPrim ::= EQP";



    public EQPrim() {
//EQPrim:init//

    }

    public static EQPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:EQPrim", scn$.lno);
        scn$.match(Token.Match.EQP, trace$);
        return new EQPrim();
    }

    public String toString() {
      return "=?";
    }
    
    public Val apply(Val [] va) {
      int i0 = va[0].intVal().val;
      int i1 = va[1].intVal().val;
      return new BoolVal(i0 == i1);
    }
    
    public ProcType definedType() {
      return Type.ii_b;
    }

//EQPrim//
}
