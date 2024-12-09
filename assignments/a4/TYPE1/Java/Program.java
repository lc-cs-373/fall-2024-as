//Program:top//
//Program:import//
import java.util.*;

public abstract class Program extends _Start /*Program:class*/ {

    public static final String $className = "Program";
    public static Program parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case DEFINE:
            return Define.parse(scn$,trace$);
        case DECLARE:
            return Declare.parse(scn$,trace$);
        case SUBOP:
        case SUB1OP:
        case MULOP:
        case IF:
        case FALSE:
        case ADD1OP:
        case LETREC:
        case LTP:
        case LET:
        case EQP:
        case DIVOP:
        case LEP:
        case DOT:
        case ANDOP:
        case ZEROP:
        case NEP:
        case TRUE:
        case LBRACE:
        case PROC:
        case ADDOP:
        case GTP:
        case NOTOP:
        case VAR:
        case SET:
        case GEP:
        case LIT:
        case OROP:
            return Eval.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Program cannot begin with " + t$.errString()
            );
        }
    }

    public static Env env = Env.initEnv(); // top-level value environment
    public static TypeEnv tenv = TypeEnv.initTypeEnv(); // top-level type env

//Program//
}
