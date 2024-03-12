a = input()

flag = False

for i in range(len(a)//2):
    if a[i]!=a[len(a)-(i+1)]:
        flag = True
        break

print(0 if flag else 1)
