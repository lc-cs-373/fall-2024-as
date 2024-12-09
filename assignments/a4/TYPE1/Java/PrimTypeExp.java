//PrimTypeExp:top//
//PrimTypeExp:import//
import java.util.*;

// <typeExp>:PrimTypeExp ::= <primType>
public class PrimTypeExp extends TypeExp /*PrimTypeExp:class*/ {

    public static final String $className = "PrimTypeExp";
    public static final String $ruleString =
        "<typeExp>:PrimTypeExp ::= <primType>";

    public PrimType primType;

    public PrimTypeExp(PrimType primType) {
//PrimTypeExp:init//
        this.primType = primType;
    }

    public static PrimTypeExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<typeExp>:PrimTypeExp", scn$.lno);
        PrimType primType = PrimType.parse(scn$, trace$);
        return new PrimTypeExp(primType);
    }

    public Type toType() {
      return primType.toType();
    }

//PrimTypeExp//
}
