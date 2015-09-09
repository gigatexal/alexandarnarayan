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

def checkNum(q):
	num = q.get()
	if num % 2 == 0:
		print 'num was %d and is even', num
	
def populateQueue(q):
	while True:
		q.put(2)	

if __name__ == '__main__':
	manager = mp.Manager()
	queue = manager.Queue()
	pool = mp.Pool(processes=1)
	result = pool.apply(populateQueue,(queue,))	

	pool_a = mp.Pool(processes=12)
	
	pool.start()
	pool.join()

	pool_a.start()
	pool_a.join()

	
	result_a = pool.apply_async(checkNum,(queue,))
	print result_a.get()
	
	while True:
		print queue.qsize()		
	
