possibles = max((x*y for x in xrange(100,1000) for y in xrange(x,1000) if str(x*y) == str(x*y)[::-1]))

print possibles

	
