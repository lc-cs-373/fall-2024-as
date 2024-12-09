#TypeExps:top#
#TypeExps:import#

# <typeExps> **= <typeExp> +COMMA
class TypeExps(): #TypeExps:class#

    className = "TypeExps"
    ruleString = "<typeExps> **= <typeExp> +COMMA"
    typeExpList = None

    def __init__(typeExpList):
        #TypeExps:init#
        self.typeExpList = typeExpList

#TypeExps#
