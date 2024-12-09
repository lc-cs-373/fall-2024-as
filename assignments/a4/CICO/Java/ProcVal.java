import java.util.*;

public class ProcVal extends Val {

  public Formals formals;
  public Exp body;
  public Env env;

  public ProcVal(Formals formals, Exp body, Env env) {
    this.formals = formals;
    this.body = body;
    this.env = env;
  }

  public Val apply(List<Ref> refList) {
    Bindings bindings = new Bindings(formals.varList, refList);
    Env nenv = env.extendEnvRef(bindings);
    Val val = body.eval(nenv);
  for (Ref varref: refList){
    varref.copyOut();
  }
return val;
  }

  public ProcVal procVal() {
    return this;
  }

  public String toString() {
    return "proc";
  }

}