//Eval:top//
//Eval:import//
import java.util.*;

// <program>:Eval ::= <exp>
public class Eval extends Program /*Eval:class*/ {

    public static final String $className = "Eval";
    public static final String $ruleString =
        "<program>:Eval ::= <exp>";

    public Exp exp;

    public Eval(Exp exp) {
//Eval:init//
        this.exp = exp;
    }

    public static Eval parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<program>:Eval", scn$.lno);
        Exp exp = Exp.parse(scn$, trace$);
        return new Eval(exp);
    }

    public String toString() {
      exp.evalType(Program.tenv); // type check first
      return exp.eval(Program.env).toString();
    }

//Eval//
}
