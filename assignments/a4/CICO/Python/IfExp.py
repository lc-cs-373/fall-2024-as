#IfExp:top#
#IfExp:import#

# <exp>:IfExp ::= IF <exp>testExp THEN <exp>trueExp ELSE <exp>falseExp
class IfExp(Exp): #IfExp:class#

    className = "IfExp"
    ruleString = "<exp>:IfExp ::= IF <exp>testExp THEN <exp>trueExp ELSE <exp>falseExp"
    testExp = None
    trueExp = None
    falseExp = None

    def __init__(testExp, trueExp, falseExp):
        #IfExp:init#
        self.testExp = testExp
        self.trueExp = trueExp
        self.falseExp = falseExp

#IfExp#
