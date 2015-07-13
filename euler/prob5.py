"""
if what is divided is even
"""
def isEven(x):
	if x % 2 == 0:
		return True

def byTwenty(x):
	for i in xrange(1,21):	
		if not isEven(x % i):
			return False
			break
		#needs work:
val = 0	
for i in xrange(20,99999999):
	found = byTwenty(i)
	if found:
		print i

