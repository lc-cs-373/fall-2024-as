#Declare:top#
#Declare:import#

# <program>:Declare ::= DECLARE <VAR> COLON <typeExp>
class Declare(Program): #Declare:class#

    className = "Declare"
    ruleString = "<program>:Declare ::= DECLARE <VAR> COLON <typeExp>"
    var = None
    typeExp = None

    def __init__(var, typeExp):
        #Declare:init#
        self.var = var
        self.typeExp = typeExp

#Declare#
