N, ch = raw_input().split(' ')
N = int(N)

N = N - 1
n = 1
while N - 2 * (n + 2) >= 0:
    n += 2
    N -= 2 * n

for i in range(n, 1, -2):
    print ' ' * ((n - i) / 2)  + ch * i
for i in range(1, n + 1, 2):
    print ' ' * ((n - i) / 2) + ch * i
print N