import sys
FILE = sys.argv[1]

def getWords(filename):
	'''
	:param filename: a utf-8 encoded file
	:return: a list
	'''
	from string import punctuation

	words = []
	try:
		with open(filename,'r') as currFile:
			wordslist = currFile.read().split()
			for currWord in wordslist:
				word = ''
				# 'word not in list' not as robust as a regular expression
				# but this method is often faster
				# than the object based regular expression method
				#
				# Cleanup words of punctuation:
				# currWord[-1] if else... checks punctuation and returns
				# the word minus the punctuation if found
				if not currWord[-1] in punctuation:
					word += currWord
				else:
					word += currWord[:-1]
				words.append(word.lower())

	except FileNotFoundError:
		print(FILE + " is not found. Please check the filename or verify the file exists")

	return words


def countWords(listOfWords):
	'''
	:param listOfWords: a list of str elements
	:return: a Counter object counting the number of words
	         given a list ['a','bee'] for example
	         would return a Counter('a':1,'bee': 2) object
	'''
	from collections import Counter
	return Counter(listOfWords)



def main():
	from string import ascii_lowercase
	#using a generator expressions here to save on memory
	words = ((word, value) for (word, value) in sorted(countWords(getWords(FILE)).items()))

	rowLetter = ((num*letter) for num in range(1,999) for letter in ascii_lowercase)

	for word,freq in words:
		print(next(rowLetter) + ': ' + word + ' ' + str(freq))



main()












