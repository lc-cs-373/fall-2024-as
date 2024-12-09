#PrimTypeExp:top#
#PrimTypeExp:import#

# <typeExp>:PrimTypeExp ::= <primType>
class PrimTypeExp(TypeExp): #PrimTypeExp:class#

    className = "PrimTypeExp"
    ruleString = "<typeExp>:PrimTypeExp ::= <primType>"
    primType = None

    def __init__(primType):
        #PrimTypeExp:init#
        self.primType = primType

#PrimTypeExp#
