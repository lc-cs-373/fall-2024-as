//ProcTypeExp:top//
//ProcTypeExp:import//
import java.util.*;

// <typeExp>:ProcTypeExp ::= LBRACK <typeExps> RARROW <typeExp> RBRACK
public class ProcTypeExp extends TypeExp /*ProcTypeExp:class*/ {

    public static final String $className = "ProcTypeExp";
    public static final String $ruleString =
        "<typeExp>:ProcTypeExp ::= LBRACK <typeExps> RARROW <typeExp> RBRACK";

    public TypeExps typeExps;
    public TypeExp typeExp;

    public ProcTypeExp(TypeExps typeExps, TypeExp typeExp) {
//ProcTypeExp:init//
        this.typeExps = typeExps;
        this.typeExp = typeExp;
    }

    public static ProcTypeExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<typeExp>:ProcTypeExp", scn$.lno);
        scn$.match(Token.Match.LBRACK, trace$);
        TypeExps typeExps = TypeExps.parse(scn$, trace$);
        scn$.match(Token.Match.RARROW, trace$);
        TypeExp typeExp = TypeExp.parse(scn$, trace$);
        scn$.match(Token.Match.RBRACK, trace$);
        return new ProcTypeExp(typeExps, typeExp);
    }

    public Type toType() {
      List<Type> paramTypeList = new ArrayList<Type>();
      for (TypeExp te : typeExps.typeExpList)
        paramTypeList.add(te.toType());
      Type returnType = typeExp.toType();
      return new ProcType(paramTypeList, returnType);
    }

//ProcTypeExp//
}
