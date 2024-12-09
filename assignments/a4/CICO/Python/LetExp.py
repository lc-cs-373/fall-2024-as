#LetExp:top#
#LetExp:import#

# <exp>:LetExp ::= LET <letDecls> IN <exp>
class LetExp(Exp): #LetExp:class#

    className = "LetExp"
    ruleString = "<exp>:LetExp ::= LET <letDecls> IN <exp>"
    letDecls = None
    exp = None

    def __init__(letDecls, exp):
        #LetExp:init#
        self.letDecls = letDecls
        self.exp = exp

#LetExp#
