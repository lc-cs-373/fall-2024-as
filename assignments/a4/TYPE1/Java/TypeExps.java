//TypeExps:top//
//TypeExps:import//
import java.util.*;

// <typeExps> **= <typeExp> +COMMA
public class TypeExps /*TypeExps:class*/ {

    public static final String $className = "TypeExps";
    public static final String $ruleString =
        "<typeExps> **= <typeExp> +COMMA";

    public List<TypeExp> typeExpList;

    public TypeExps(List<TypeExp> typeExpList) {
//TypeExps:init//
        this.typeExpList = typeExpList;
    }

    public static TypeExps parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<typeExps>", scn$.lno);
        List<TypeExp> typeExpList = new ArrayList<TypeExp>();
        // first trip through the parse
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case LBRACK:
        case INT:
        case BOOL:
            while(true) {
                typeExpList.add(TypeExp.parse(scn$, trace$));
                t$ = scn$.cur();
                match$ = t$.match;
                if (match$ != Token.Match.COMMA)
                    break; // not a separator, so we're done
                scn$.match(match$, trace$);
            }
        } // end of switch
        return new TypeExps(typeExpList);

    }

//TypeExps//
}
