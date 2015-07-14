
def sumOfSquares(x):
	return sum(x**2 for x in xrange(x+1))

def squareOfSum(x):
	return sum(x for x in xrange(x+1))**2

print squareOfSum(100) - sumOfSquares(100)
