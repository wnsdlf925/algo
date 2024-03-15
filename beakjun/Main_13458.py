N = int(input())
A = list(map(int,input().split()))
b, c = map(int, input().split())

answer = int(len(A))

for i in A:
    i-=b
    if i>0:
        if i%c != 0:
            answer += int((i)/c)+1

        else:
            answer += int((i)/c)

print(answer)