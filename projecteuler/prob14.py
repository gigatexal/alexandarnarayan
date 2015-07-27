def isEven(num):
	return num % 2 == 0

"""
pick a start number
one less than a million
run collatz sequence until at 1
append each item of the sequence to an array
run next sequence
append each item of this sequence to an array
if len of this sequence is not greater than the previous one, keep previous
repeat
"""
sequence = []


def isEven(num):
	return num % 2 == 0

def nextSeqCollatz(num):
	if isEven(num):
		return (num / 2)
	else:
		return (3 * num) + 1 	


def makeSeq(start):
	seq = []
	seq.append(start)
	while start != 1:
		collatz = nextSeqCollatz(start)
		seq.append(collatz)
		start = collatz
	return len(seq), seq[0], seq


#del a[:]
START = 999999

nums = (makeSeq(x) for x in xrange(START,1,-1))

def getKey(item):
	return item[0]

a = sorted(nums, key=getKey, reverse=True)

print a[0]
