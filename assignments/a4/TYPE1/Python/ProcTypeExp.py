#ProcTypeExp:top#
#ProcTypeExp:import#

# <typeExp>:ProcTypeExp ::= LBRACK <typeExps> RARROW <typeExp> RBRACK
class ProcTypeExp(TypeExp): #ProcTypeExp:class#

    className = "ProcTypeExp"
    ruleString = "<typeExp>:ProcTypeExp ::= LBRACK <typeExps> RARROW <typeExp> RBRACK"
    typeExps = None
    typeExp = None

    def __init__(typeExps, typeExp):
        #ProcTypeExp:init#
        self.typeExps = typeExps
        self.typeExp = typeExp

#ProcTypeExp#
