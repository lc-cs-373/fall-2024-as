//LetrecExp:top//
//LetrecExp:import//
import java.util.*;

// <exp>:LetrecExp ::= LETREC <letrecDecls> IN <exp>
public class LetrecExp extends Exp /*LetrecExp:class*/ {

    public static final String $className = "LetrecExp";
    public static final String $ruleString =
        "<exp>:LetrecExp ::= LETREC <letrecDecls> IN <exp>";

    public LetrecDecls letrecDecls;
    public Exp exp;

    public LetrecExp(LetrecDecls letrecDecls, Exp exp) {
//LetrecExp:init//
        this.letrecDecls = letrecDecls;
        this.exp = exp;
    }

    public static LetrecExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:LetrecExp", scn$.lno);
        scn$.match(Token.Match.LETREC, trace$);
        LetrecDecls letrecDecls = LetrecDecls.parse(scn$, trace$);
        scn$.match(Token.Match.IN, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new LetrecExp(letrecDecls, exp);
    }

    public Val eval(Env env) {
      Env nenv = letrecDecls.addBindings(env); // new bindings
      return exp.eval(nenv);
    }
    
    public Type evalType(TypeEnv tenv) {
      TypeEnv ntenv = letrecDecls.addTypeBindings(tenv);
      return exp.evalType(ntenv);
    }
    
    public String toString() {
      return " ...LetrecExp... ";
    }

//LetrecExp//
}
