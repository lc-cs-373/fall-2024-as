//Define:top//
//Define:import//
import java.util.*;

// <program>:Define ::= DEFINE <VAR> EQUALS <exp>
public class Define extends Program /*Define:class*/ {

    public static final String $className = "Define";
    public static final String $ruleString =
        "<program>:Define ::= DEFINE <VAR> EQUALS <exp>";

    public Token var;
    public Exp exp;

    public Define(Token var, Exp exp) {
//Define:init//
        this.var = var;
        this.exp = exp;
    }

    public static Define parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<program>:Define", scn$.lno);
        scn$.match(Token.Match.DEFINE, trace$);
        Token var = scn$.match(Token.Match.VAR, trace$);
        scn$.match(Token.Match.EQUALS, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Define(var, exp);
    }

    // notice that calling toString triggers a modification
    // of the initial environment
    public String toString() {
      Val val = exp.eval(Program.env);
      Program.env.addFirst(new Binding(var.toString(), new ValRef(val)));
      return var.toString(); // return *something*
    }

//Define//
}
