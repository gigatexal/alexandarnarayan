import math

def is_prime(number):
    if number > 0:
	if number == 1:
	    return True
        if number == 2:
            return True
        if number % 2 == 0:
            return False
        for current in xrange(3, int(math.sqrt(number) + 1), 2):
            if number % current == 0: 
                return False
        return True
    return False



def nthPrime(nth):
	return (x for x in xrange(1,nth+1) if is_prime(x))

#this is such a hack, fix me
count = 0
sumOfPrimes = 0
for i in nthPrime(9999999):
	if i >= 2000000:
		break
	print count, i 
	count = count + 1
	sumOfPrimes += i

print sumOfPrimes-1


