def until(n, filter_func, v):
   if v == n: return []
   if filter_func(v): return [v] + until( n, filter_func, v+1 )
   else: return until(n, filter_func, v+1)

mult_3_5= lambda x: x%3==0 or x%5==0

print(until(999, lambda x: x%3==0 or x%5==0,0))


