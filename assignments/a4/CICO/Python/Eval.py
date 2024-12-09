#Eval:top#
#Eval:import#

# <program>:Eval ::= <exp>
class Eval(Program): #Eval:class#

    className = "Eval"
    ruleString = "<program>:Eval ::= <exp>"
    exp = None

    def __init__(exp):
        #Eval:init#
        self.exp = exp

#Eval#
