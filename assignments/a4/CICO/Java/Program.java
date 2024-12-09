//Program:top//
//Program:import//
import java.util.*;

public abstract class Program extends _Start /*Program:class*/ {

    public static final String $className = "Program";
    public static Program parse(Scan scn$, Trace trace$) {
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
            return Eval.parse(scn$,trace$);
        case DEFINE:
            return Define.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Program cannot begin with " + t$.errString()
            );
        }
    }

    public static Env env = Env.initEnv(); // the initial environment

//Program//
}
