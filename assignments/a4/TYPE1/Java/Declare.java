//Declare:top//
//Declare:import//
import java.util.*;

// <program>:Declare ::= DECLARE <VAR> COLON <typeExp>
public class Declare extends Program /*Declare:class*/ {

    public static final String $className = "Declare";
    public static final String $ruleString =
        "<program>:Declare ::= DECLARE <VAR> COLON <typeExp>";

    public Token var;
    public TypeExp typeExp;

    public Declare(Token var, TypeExp typeExp) {
//Declare:init//
        this.var = var;
        this.typeExp = typeExp;
    }

    public static Declare parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<program>:Declare", scn$.lno);
        scn$.match(Token.Match.DECLARE, trace$);
        Token var = scn$.match(Token.Match.VAR, trace$);
        scn$.match(Token.Match.COLON, trace$);
        TypeExp typeExp = TypeExp.parse(scn$, trace$);
        return new Declare(var, typeExp);
    }

    // calling toString may trigger a modificaiton
    // of the top-level type environment
    public String toString() {
      TypeEnv tenv = Program.tenv; // top-level type environment
      Type varType; // variable's declared type
      String sym = var.toString();
      try {
        // look up the variable in the top-level type environment
        varType = tenv.applyTypeEnv(sym);
      } catch (RuntimeException e) {
        // no type binding -- must be a new type declaration
        // that we add to the top-level type environment
        varType = typeExp.toType();
        tenv.add(new TypeBinding(sym, varType)); // type binding
        return sym + ":" + varType;
      }
      throw new RuntimeException(sym + ": duplicate variable declaration: ");
    }

//Declare//
}
