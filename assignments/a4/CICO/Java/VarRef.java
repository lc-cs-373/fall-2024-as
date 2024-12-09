public class VarRef extends Ref {

    public Val val; // for copy-in
    public Ref ref; // for copy-out

    public VarRef(Ref ref) {
        this.val = ref.deRef(); // local copy
        this.ref = ref;         // where to copy out
    }

    public Val deRef() {
        return val;
    }

    public Val setRef(Val v) {
        return val = v;
    }

    public void copyOut() {
        ref.setRef(val);
    }

}