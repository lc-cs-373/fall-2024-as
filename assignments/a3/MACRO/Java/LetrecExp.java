//LetrecExp:top//
//LetrecExp:import//
import java.util.*;

// <exp>:LetrecExp ::= LETREC <letDecls> IN <exp>
public class LetrecExp extends Exp /*LetrecExp:class*/ {

    public static final String $className = "LetrecExp";
    public static final String $ruleString =
        "<exp>:LetrecExp ::= LETREC <letDecls> IN <exp>";

    public LetDecls letDecls;
    public Exp exp;

    public LetrecExp(LetDecls letDecls, Exp exp) {
//LetrecExp:init//
        this.letDecls = letDecls;
        this.exp = exp;
    }

    public static LetrecExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:LetrecExp", scn$.lno);
        scn$.match(Token.Match.LETREC, trace$);
        LetDecls letDecls = LetDecls.parse(scn$, trace$);
        scn$.match(Token.Match.IN, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new LetrecExp(letDecls, exp);
    }

    public Val eval(Env env) {
        env = letDecls.addLetrecBindings(env);
        return exp.eval(env);
    }

//LetrecExp//
}
