#SeqExps:top#
#SeqExps:import#

# <seqExps> **= SEMI <exp>
class SeqExps(): #SeqExps:class#

    className = "SeqExps"
    ruleString = "<seqExps> **= SEMI <exp>"
    expList = None

    def __init__(expList):
        #SeqExps:init#
        self.expList = expList

#SeqExps#
