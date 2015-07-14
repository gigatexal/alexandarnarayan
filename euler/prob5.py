"""
if what is divided is even
when divided it leaves no remainder
"""
	
def divs(x):
	count = 0;
	for i in xrange(1,21):
		if x % i == 0:
			count = count + 1
	if count == 20:
		return True

	if count <> 20:
		return False




if __name__ == "__main__":
	for i in xrange(20,9999999999):
		if divs(i):
			print i
			break





