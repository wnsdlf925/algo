def solution(N):
    visited = [False]*(N+1)
    duplicate = set()
    answer = []


    def checked():
        temp = 0
        for index, value in enumerate(visited):
            if value:
                temp+=index
        
        return temp

    def dfs(num,count,start,fin):
        
        check = checked()
        if check > 10:
            return
 
        if num == count:
            if check == 10:
                
                temp = []
                for index, value in enumerate(visited):
                    if value:
                        temp.append(index)
                if tuple(temp) not in duplicate:
                    duplicate.add(tuple(temp))
                    answer.append((temp))
            return
        

        for i in range(start,fin+1):
            if visited[i] == False:
                visited[i] = True
                dfs(num,count+1,start+1,N)
                visited[i] = False
        return


    for i in range(1,N+1):
        dfs(i,0,1,N)
    answer.sort()
    return answer

# def dfs(start,fin):

#     return

print(solution(5))