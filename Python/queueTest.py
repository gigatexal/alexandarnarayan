""""
from the docs:
from multiprocessing import Pool

def f(x):
    return x*x

if __name__ == '__main__':
    pool = Pool(processes=4)              # start 4 worker processes
    result = pool.apply_async(f, [10])    # evaluate "f(10)" asynchronously
    print result.get(timeout=1)           # prints "100" unless your computer is *very* slow
    print pool.map(f, range(10))          # prints "[0, 1, 4,..., 81]"
"""

import multiprocessing as mp
import time as time
import random as rnd


def checkNum(q):
	num = q.get()
	if num % 2 == 0:
		print 'num was %d and is even', num
	
def populateQueue(q):
	mult = int(q.get())
	for i in xrange(11):
		q.put(i) * mult
	q.close()

if __name__ == '__main__':
	
	manager = mp.Manager()
	queue = manager.Queue()
	
	pool = mp.Pool(processes=4)

	pool.apply_async(populateQueue, (queue,))

	while True:
		print queue.get()
		if queue.qsize() == 0:
			break


	
