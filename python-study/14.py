def solution(n,k,cmd):

    table = [[0]*2 for _ in range(n+2)]
    stack = list()
    index = k+1 

    for i in range(len(table)):
        
        table[i][0] = i-1
        table[i][1] = i+1
    
    
    for i in range(len(cmd)):
        
        if cmd[i][0] == "D":
            a, b = cmd[i].split()
            for j in range(int(b)):
                index = table[index][1]
            
        elif cmd[i][0] == "U":
            a, b = cmd[i].split()
            for j in range(int(b)):
                index = table[index][0]

        elif cmd[i][0] == "C":
            stack.append(index)
            table[table[index][1]][0] = table[index][0]
            table[table[index][0]][1] = table[index][1]
            index=table[index][0] if n<table[index][1] else table[index][1]


        elif cmd[i][0] == "Z":
            temp = stack.pop()
            table[table[temp][1]][0] = temp
            table[table[temp][0]][1] = temp
           
        
        print(cmd[i])
        print(index)
        print(table)
        print(stack)
        print()

        

    answer = ["O"]*n
    print(stack)
    for i in stack:
        answer[i-1] = "X"

  

    return "".join(answer)

# print(solution(8,2,["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"]))
print(solution(8, 2, ["C", "C", "C", "C", "Z"]))