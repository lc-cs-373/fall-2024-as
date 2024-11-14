#LetrecExp:top#
#LetrecExp:import#

# <exp>:LetrecExp ::= LETREC <letDecls> IN <exp>
class LetrecExp(Exp): #LetrecExp:class#

    className = "LetrecExp"
    ruleString = "<exp>:LetrecExp ::= LETREC <letDecls> IN <exp>"
    letDecls = None
    exp = None

    def __init__(letDecls, exp):
        #LetrecExp:init#
        self.letDecls = letDecls
        self.exp = exp

#LetrecExp#
