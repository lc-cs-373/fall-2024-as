//Formals:top//
//Formals:import//
import java.util.*;

// <formals> **= <VAR> COLON <typeExp> +COMMA
public class Formals /*Formals:class*/ {

    public static final String $className = "Formals";
    public static final String $ruleString =
        "<formals> **= <VAR> COLON <typeExp> +COMMA";

    public List<Token> varList;
    public List<TypeExp> typeExpList;

    public Formals(List<Token> varList, List<TypeExp> typeExpList) {
//Formals:init//
        this.varList = varList;
        this.typeExpList = typeExpList;
    }

    public static Formals parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<formals>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<TypeExp> typeExpList = new ArrayList<TypeExp>();
        // first trip through the parse
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case VAR:
            while(true) {
                varList.add(scn$.match(Token.Match.VAR, trace$));
                scn$.match(Token.Match.COLON, trace$);
                typeExpList.add(TypeExp.parse(scn$, trace$));
                t$ = scn$.cur();
                match$ = t$.match;
                if (match$ != Token.Match.COMMA)
                    break; // not a separator, so we're done
                scn$.match(match$, trace$);
            }
        } // end of switch
        return new Formals(varList, typeExpList);

    }

    public List<Type> formalTypeList() {
      List<String> stringVarList = new ArrayList<String>();
      for(Token t : varList) {
        stringVarList.add(t.toString());
      }
      TypeEnv.checkDuplicates(stringVarList);
      List<Type> typeList = new ArrayList<Type>();
      for (TypeExp texp : typeExpList)
        typeList.add(texp.toType());
      return typeList;
    }
    
    public TypeBindings declaredTypeBindings() {
      List<Type> formalTypeList = formalTypeList();
      return new TypeBindings(varList, formalTypeList);
    }
    
    public String toString() {
      String s = "";
      String sep = "";
      Iterator<Token> varIterator = varList.iterator();
      Iterator<TypeExp> typeIterator = typeExpList.iterator();
      while (varIterator.hasNext()) {
        s += sep +
          varIterator.next().toString() +
          ":" +
          typeIterator.next().toType();
        sep = ",";
      }
      return s;
    }

//Formals//
}
