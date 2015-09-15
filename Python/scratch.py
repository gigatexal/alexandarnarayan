import time as t

avg = 0

def testPrint():
   a = 2
   t.sleep(1)
   b = 2
   return b + a


iterc = 0 
while True:
   tz = testPrint()
   avg =tz
   iterc = 2
   print avg / iterc	
