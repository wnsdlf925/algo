def solution(n,k,cmd):

    table = [[0]*2 for _ in range(n+2)]
    stack = list()
    index = k+1 

    for i in range(len(table)):
        
        table[i][0] = i-1
        table[i][1] = i+1
    
    
    for i in range(len(cmd)):
        
        if cmd[i][0] == "D":
            for j in range(int(cmd[i][2])):
                index = table[index][1]
            
        elif cmd[i][0] == "U":
            for j in range(int(cmd[i][2])):
                index = table[index][0]

        elif cmd[i][0] == "C":
            stack.append(index)
            table[index+1][0] = table[index][0]
            table[index-1][1] = table[index][1]
            if index == n: index = table[k][0]
            else: index = table[k][1]
        elif cmd[i][0] == "Z":
            temp = stack.pop()
            table[temp+1][0] = temp
            table[temp-1][1] = temp
            if temp <= index: index += 1
        
        print(index)
        print(cmd[i])
        print(table)

        

    answer = ["O"]*n
    print(stack)
    for i in stack:
        answer[i-1] = "X"

  

    return "".join(answer)

print(solution(8,2,["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"]))