#ProcExp:top#
#ProcExp:import#

# <exp>:ProcExp ::= <proc>
class ProcExp(Exp): #ProcExp:class#

    className = "ProcExp"
    ruleString = "<exp>:ProcExp ::= <proc>"
    proc = None

    def __init__(proc):
        #ProcExp:init#
        self.proc = proc

#ProcExp#
