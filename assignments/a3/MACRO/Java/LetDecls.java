//LetDecls:top//
//LetDecls:import//
import java.util.*;

// <letDecls> **= <VAR> EQUALS <exp>
public class LetDecls /*LetDecls:class*/ {

    public static final String $className = "LetDecls";
    public static final String $ruleString =
        "<letDecls> **= <VAR> EQUALS <exp>";

    public List<Token> varList;
    public List<Exp> expList;

    public LetDecls(List<Token> varList, List<Exp> expList) {
        // check for duplicates during parsing
        Env.checkDuplicates(varList, " in let/letrec LHS identifiers");
//LetDecls:init//
        this.varList = varList;
        this.expList = expList;
    }

    public static LetDecls parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<letDecls>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Exp> expList = new ArrayList<Exp>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Match match$ = t$.match;
            switch(match$) {
            case VAR:
                varList.add(scn$.match(Token.Match.VAR, trace$));
                scn$.match(Token.Match.EQUALS, trace$);
                expList.add(Exp.parse(scn$, trace$));
                continue;
            default:
                return new LetDecls(varList, expList);
            }
        }

    }

    // LetDecls has two fields:
    //   List<Token> varList
    //   List<Exp> expList
    //   The parser guarantees that these lists have the same size
    
    public Env addBindings(Env env) {
        Rands rands = new Rands(expList);
        // evaluate the operand expressions in the enclosing env.
        List<Val> valList = rands.evalRands(env);
        Bindings bindings = new Bindings(varList, valList);
        return env.extendEnv(bindings);
    }
    
    public Env addLetrecBindings(Env env) {
        env = env.extendEnv(new Bindings(varList.size()));
        Iterator<Token> varIter = varList.iterator();
        Iterator<Exp> expIter = expList.iterator();
        while (varIter.hasNext()) {
            String str = varIter.next().toString();
            Exp exp = expIter.next();
            // evaluate the operand expression in the letrec env.
            Val val = exp.eval(env);
            // and add the binding to the current env
            env.add(new Binding(str, val));
        }
        return env;
    }
    
    public String toString() {
        return "... LetDecls ...";
    }

//LetDecls//
}
