#Macro:top#
#Macro:import#

# <macro> ::= MACRO LPAREN <formals> RPAREN <exp>
class Macro(): #Macro:class#

    className = "Macro"
    ruleString = "<macro> ::= MACRO LPAREN <formals> RPAREN <exp>"
    formals = None
    exp = None

    def __init__(formals, exp):
        #Macro:init#
        self.formals = formals
        self.exp = exp

#Macro#
