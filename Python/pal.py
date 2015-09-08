#pal 196

THENUM = 3932472453326071578739224 

def isPal(num):
	return num == reverseNum(num) 

def reverseNum(num):
	return int(str(num)[::-1])

def genNum(num):
	return num + reverseNum(num)


def genPals(num):
	while True:
		possPal = genNum(num)
		num = possPal
		yield possPal	
		
possiblePalindromes = genPals(THENUM)

pals = (x for x in possiblePalindromes)

count = 0
for i in pals:
	
	if isPal(i):
		print i
		break
	

