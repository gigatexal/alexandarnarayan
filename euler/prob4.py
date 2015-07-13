"""
palindrom
999x999 eg. in two digits 99x901 
99x91 = 9009

"""
def is_palindrome(i):
    return str(i) == str(i)[::-1]

# what's the max?
max_p = 0

# multiply all numbers `i` between 100 and 998, with all between i+1 and 999
for i in xrange(100, 999):
    for j in xrange(i+1, 1000):
        p = i * j
        if is_palindrome(p) and p > max_p:
            max_p = p

print max_p

				








