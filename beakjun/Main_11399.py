N = int(input())
P = list(map(int,input().split()))

answer = 0
temp = 0

P.sort()

for i in range(N):
    temp += P[i]
    answer += temp
    

print(answer)

