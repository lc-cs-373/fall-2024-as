//Rands:top//
//Rands:import//
import java.util.*;

// <rands> **= <exp> +COMMA
public class Rands /*Rands:class*/ {

    public static final String $className = "Rands";
    public static final String $ruleString =
        "<rands> **= <exp> +COMMA";

    public List<Exp> expList;

    public Rands(List<Exp> expList) {
//Rands:init//
        this.expList = expList;
    }

    public static Rands parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<rands>", scn$.lno);
        List<Exp> expList = new ArrayList<Exp>();
        // first trip through the parse
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case SUB1OP:
        case LBRACE:
        case LETREC:
        case LET:
        case DIVOP:
        case VAR:
        case LIT:
        case ADD1OP:
        case SUBOP:
        case DOT:
        case ZEROP:
        case ADDOP:
        case SET:
        case PROC:
        case MULOP:
        case IF:
            while(true) {
                expList.add(Exp.parse(scn$, trace$));
                t$ = scn$.cur();
                match$ = t$.match;
                if (match$ != Token.Match.COMMA)
                    break; // not a separator, so we're done
                scn$.match(match$, trace$);
            }
        } // end of switch
        return new Rands(expList);

    }

    public String toString() {
      String s = "";   // the string to return
      String sep = ""; // no separator for the first expression
      // get all of the expressions in the expression list
      for (Exp e : expList) {
        s += sep + e;
        sep = ",";   // commas separate the rest of the expressions
      }
      return s;
    }
    
    // use each expression's evalRef method to build
    // a List<Ref> object
    public List<Ref> evalRandsRef(Env env) {
      List<Ref> refList = new ArrayList<Ref>();
      for (Exp exp : expList)
        refList.add(exp.evalRef(env));
      return refList;
    }
    
    public List<Val> evalRands(Env env) {
      List<Val> valList = new ArrayList<Val>();
      for (Exp e : expList)
        valList.add(e.eval(env));
      return valList;
    }

//Rands//
}
