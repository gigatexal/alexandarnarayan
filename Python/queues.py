import multiprocessing as mp

def qIn(q):
	q.put('test')
#	q.close()

def main():
	q = mp.Queue()
	
	qIn(q)

	print q.get()



if __name__ == '__main__':
	main()
	
