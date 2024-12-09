//TrueExp:top//
//TrueExp:import//
import java.util.*;

// <exp>:TrueExp ::= TRUE
public class TrueExp extends Exp /*TrueExp:class*/ {

    public static final String $className = "TrueExp";
    public static final String $ruleString =
        "<exp>:TrueExp ::= TRUE";



    public TrueExp() {
//TrueExp:init//

    }

    public static TrueExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:TrueExp", scn$.lno);
        scn$.match(Token.Match.TRUE, trace$);
        return new TrueExp();
    }

    public Val eval(Env env) {
      return new BoolVal(true);
    }
    
    public Type evalType(TypeEnv tenv) {
      return Type.boolType;
    }

//TrueExp//
}
