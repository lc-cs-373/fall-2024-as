#LetrecExp:top#
#LetrecExp:import#

# <exp>:LetrecExp ::= LETREC <letrecDecls> IN <exp>
class LetrecExp(Exp): #LetrecExp:class#

    className = "LetrecExp"
    ruleString = "<exp>:LetrecExp ::= LETREC <letrecDecls> IN <exp>"
    letrecDecls = None
    exp = None

    def __init__(letrecDecls, exp):
        #LetrecExp:init#
        self.letrecDecls = letrecDecls
        self.exp = exp

#LetrecExp#
