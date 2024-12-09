#AppExp:top#
#AppExp:import#

# <exp>:AppExp ::= DOT <exp> LPAREN <rands> RPAREN
class AppExp(Exp): #AppExp:class#

    className = "AppExp"
    ruleString = "<exp>:AppExp ::= DOT <exp> LPAREN <rands> RPAREN"
    exp = None
    rands = None

    def __init__(exp, rands):
        #AppExp:init#
        self.exp = exp
        self.rands = rands

#AppExp#
