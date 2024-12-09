//SetExp:top//
//SetExp:import//
import java.util.*;

// <exp>:SetExp ::= SET <VAR> EQUALS <exp>
public class SetExp extends Exp /*SetExp:class*/ {

    public static final String $className = "SetExp";
    public static final String $ruleString =
        "<exp>:SetExp ::= SET <VAR> EQUALS <exp>";

    public Token var;
    public Exp exp;

    public SetExp(Token var, Exp exp) {
//SetExp:init//
        this.var = var;
        this.exp = exp;
    }

    public static SetExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:SetExp", scn$.lno);
        scn$.match(Token.Match.SET, trace$);
        Token var = scn$.match(Token.Match.VAR, trace$);
        scn$.match(Token.Match.EQUALS, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new SetExp(var, exp);
    }

    public Val eval(Env env) {
      Val v = exp.eval(env);
      Ref ref = env.applyEnvRef(var);
      return ref.setRef(v);
    }

//SetExp//
}
