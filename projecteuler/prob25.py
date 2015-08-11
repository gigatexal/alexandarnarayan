def fib():
    a, b = 1, 1
    while True:
        yield a
        a, b = b, a + b

fibs = fib()

f = 0
count = 0
while True:
        someFib = str(next(fibs))
        count = count + 1
        if len(someFib) > 999:
                f = int(someFib)
                break

print count,f










