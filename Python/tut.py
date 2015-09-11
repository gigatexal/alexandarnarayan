#taken from http://sebastianraschka.com/Articles/2014_multiprocessing_intro.html

import multiprocessing as mp
import random
import string

# Define an output queue
output = mp.Queue()

# define a example function
def rand_string(length, output):
	""" Generates a random string of numbers, lower- and uppercase chars. """
#	count = 0
#	while count < 10:	
	count = 0
	while count < 1000000:	
		rand_str = ''.join(
			random.choice(
        		string.ascii_lowercase
        		+ string.ascii_uppercase
                	+ string.digits
			+ string.hexdigits
			+ string.octdigits  + str('_'))
        		for i in range(length)
			)
#	count +=1
		count +=1
	output.put(rand_str)

# Setup a list of processes that we want to run
processes = [mp.Process(target=rand_string, args=(random.randint(5,15), output)) for x in range(32)]

# Run processes
for p in processes:
    p.start()
# Exit the completed processes
for p in processes:
    p.join()

# Get process results from the output queue
# results = [output.get() for p in processes]
results = (output.get() for p in processes)

for result in results:
	print result,


