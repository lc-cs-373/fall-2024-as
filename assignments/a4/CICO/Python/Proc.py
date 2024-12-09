#Proc:top#
#Proc:import#

# <proc> ::= PROC LPAREN <formals> RPAREN <exp>
class Proc(): #Proc:class#

    className = "Proc"
    ruleString = "<proc> ::= PROC LPAREN <formals> RPAREN <exp>"
    formals = None
    exp = None

    def __init__(formals, exp):
        #Proc:init#
        self.formals = formals
        self.exp = exp

#Proc#
