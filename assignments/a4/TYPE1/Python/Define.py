#Define:top#
#Define:import#

# <program>:Define ::= DEFINE <VAR> EQUALS <exp>
class Define(Program): #Define:class#

    className = "Define"
    ruleString = "<program>:Define ::= DEFINE <VAR> EQUALS <exp>"
    var = None
    exp = None

    def __init__(var, exp):
        #Define:init#
        self.var = var
        self.exp = exp

#Define#
