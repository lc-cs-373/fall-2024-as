#Formals:top#
#Formals:import#

# <formals> **= <VAR> COLON <typeExp> +COMMA
class Formals(): #Formals:class#

    className = "Formals"
    ruleString = "<formals> **= <VAR> COLON <typeExp> +COMMA"
    varList = None
    typeExpList = None

    def __init__(varList, typeExpList):
        #Formals:init#
        self.varList = varList
        self.typeExpList = typeExpList

#Formals#
