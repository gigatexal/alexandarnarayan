def fib():
    a, b = 0, 1
    while True:
        yield a
        a, b = b, a + b


f = [next(fib()) for x in range(10)]

print f
