#SeqExp:top#
#SeqExp:import#

# <exp>:SeqExp ::= LBRACE <exp> <seqExps> RBRACE
class SeqExp(Exp): #SeqExp:class#

    className = "SeqExp"
    ruleString = "<exp>:SeqExp ::= LBRACE <exp> <seqExps> RBRACE"
    exp = None
    seqExps = None

    def __init__(exp, seqExps):
        #SeqExp:init#
        self.exp = exp
        self.seqExps = seqExps

#SeqExp#
