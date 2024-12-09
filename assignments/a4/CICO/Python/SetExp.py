#SetExp:top#
#SetExp:import#

# <exp>:SetExp ::= SET <VAR> EQUALS <exp>
class SetExp(Exp): #SetExp:class#

    className = "SetExp"
    ruleString = "<exp>:SetExp ::= SET <VAR> EQUALS <exp>"
    var = None
    exp = None

    def __init__(var, exp):
        #SetExp:init#
        self.var = var
        self.exp = exp

#SetExp#
