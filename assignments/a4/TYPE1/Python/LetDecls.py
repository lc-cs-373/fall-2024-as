#LetDecls:top#
#LetDecls:import#

# <letDecls> **= <VAR> EQUALS <exp>
class LetDecls(): #LetDecls:class#

    className = "LetDecls"
    ruleString = "<letDecls> **= <VAR> EQUALS <exp>"
    varList = None
    expList = None

    def __init__(varList, expList):
        #LetDecls:init#
        self.varList = varList
        self.expList = expList

#LetDecls#
