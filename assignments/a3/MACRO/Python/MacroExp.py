#MacroExp:top#
#MacroExp:import#

# <exp>:MacroExp ::= <macro>
class MacroExp(Exp): #MacroExp:class#

    className = "MacroExp"
    ruleString = "<exp>:MacroExp ::= <macro>"
    macro = None

    def __init__(macro):
        #MacroExp:init#
        self.macro = macro

#MacroExp#
