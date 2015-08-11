def fib():
    a, b = 0, 1
    while True:
        yield a
        a, b = b, a + b

fibs = fib()

f = [next(fibs) for x in range(10)]

print f
