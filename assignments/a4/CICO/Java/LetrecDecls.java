//LetrecDecls:top//
//LetrecDecls:import//
import java.util.*;

// <letrecDecls> **= <VAR> EQUALS <proc>
public class LetrecDecls /*LetrecDecls:class*/ {

    public static final String $className = "LetrecDecls";
    public static final String $ruleString =
        "<letrecDecls> **= <VAR> EQUALS <proc>";

    public List<Token> varList;
    public List<Proc> procList;

    public LetrecDecls(List<Token> varList, List<Proc> procList) {
//LetrecDecls:init//
        this.varList = varList;
        this.procList = procList;
    }

    public static LetrecDecls parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<letrecDecls>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Proc> procList = new ArrayList<Proc>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Match match$ = t$.match;
            switch(match$) {
            case VAR:
                varList.add(scn$.match(Token.Match.VAR, trace$));
                scn$.match(Token.Match.EQUALS, trace$);
                procList.add(Proc.parse(scn$, trace$));
                continue;
            default:
                return new LetrecDecls(varList, procList);
            }
        }

    }

    public Env addBindings(Env env) {
      Env nenv = env.extendEnvRef(null); // no bindings yet
      List<Val> valList = new ArrayList<Val>();
      for (Proc p : procList)
        valList.add(p.makeClosure(nenv));
      List<Ref> refList = Ref.valsToRefs(valList);
      Bindings bindings = new Bindings(varList, refList);
      nenv.replaceBindings(bindings);
      return nenv;
    }

//LetrecDecls//
}
