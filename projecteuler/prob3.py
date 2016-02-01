import math

def is_prime(number):
    if number > 1:
        if number == 2:
            return True
        if number % 2 == 0:
            return False
        for current in xrange(3, int(math.sqrt(number) + 1), 1):
		if number % current == 0: 
        		return False
        return True
    return False

"""
use a generator
"""
def get_primes(num):
	while True:
		if is_prime(num):
			yield num
		num = num + 1

x = 0
primes = get_primes(3)
while x < 600851475143:
	factor = primes.next()
	if 600851475143 % factor == 0:
		print factor
	if x >= 600851475143:
		break
	x = x + 1




	



