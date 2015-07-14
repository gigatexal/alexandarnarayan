
possibles  = [(x,y,z) for x in xrange(500) for y in xrange(500) for z in xrange(500) if x**2 + y**2 == z**2 and x+y+z == 1000]

answer = reduce(lambda x,y: x*y, possibles[0])

print answer

