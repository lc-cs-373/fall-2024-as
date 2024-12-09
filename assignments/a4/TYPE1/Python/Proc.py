#Proc:top#
#Proc:import#

# <proc> ::= PROC LPAREN <formals> RPAREN COLON <typeExp> <exp>
class Proc(): #Proc:class#

    className = "Proc"
    ruleString = "<proc> ::= PROC LPAREN <formals> RPAREN COLON <typeExp> <exp>"
    formals = None
    typeExp = None
    exp = None

    def __init__(formals, typeExp, exp):
        #Proc:init#
        self.formals = formals
        self.typeExp = typeExp
        self.exp = exp

#Proc#
