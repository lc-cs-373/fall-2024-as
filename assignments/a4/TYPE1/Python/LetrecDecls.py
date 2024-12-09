#LetrecDecls:top#
#LetrecDecls:import#

# <letrecDecls> **= <VAR> EQUALS <proc>
class LetrecDecls(): #LetrecDecls:class#

    className = "LetrecDecls"
    ruleString = "<letrecDecls> **= <VAR> EQUALS <proc>"
    varList = None
    procList = None

    def __init__(varList, procList):
        #LetrecDecls:init#
        self.varList = varList
        self.procList = procList

#LetrecDecls#
