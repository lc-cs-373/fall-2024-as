//FalseExp:top//
//FalseExp:import//
import java.util.*;

// <exp>:FalseExp ::= FALSE
public class FalseExp extends Exp /*FalseExp:class*/ {

    public static final String $className = "FalseExp";
    public static final String $ruleString =
        "<exp>:FalseExp ::= FALSE";



    public FalseExp() {
//FalseExp:init//

    }

    public static FalseExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:FalseExp", scn$.lno);
        scn$.match(Token.Match.FALSE, trace$);
        return new FalseExp();
    }

    public Val eval(Env env) {
      return new BoolVal(false);
    }
    
    public Type evalType(TypeEnv tenv) {
      return Type.boolType;
    }

//FalseExp//
}
