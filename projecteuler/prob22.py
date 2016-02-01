"""
https://projecteuler.net/problem=22
"""

with open('names.txt','r') as names:
	data = names.read()
names.close()

def numerics(elem):
	val = []
	for el in elem:
		val.append(ord(el)-64)

	return sum(val)		

sanitized = sorted(str(data).replace('"','').split(','))

scores = 0

for i,name in enumerate(sanitized, start=1):
	#print (i), name, numerics(name), (i) * numerics(name)
	scores += (i) * numerics(name)	

print scores
