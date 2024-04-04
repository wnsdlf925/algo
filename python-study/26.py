

def solution(nodes):

    tree = [0 for _ in range(len(nodes)+1)]
    answer = list()

    for i in range(1,len(nodes)+1):
        tree[i] = nodes[i-1]
    answer.append(preOrder(tree,1))
    answer.append(inOrder(tree,1))
    answer.append(postOrder(tree,1))
   
    return answer

def preOrder(nodes, index):
    
    if index < len(nodes):
        answer = str(index)+" "
        answer += preOrder(nodes, index*2)
        answer += preOrder(nodes, (index*2)+1)

        return answer

    else: return ""
    
    


def inOrder(nodes, index):
    global answer
    if index < len(nodes):
        answer = inOrder(nodes, index*2)
        answer += str(index)+" "
        answer += inOrder(nodes, (index*2)+1)
    
        return answer

    else: return ""


def postOrder(nodes, index):
    global answer
    if index < len(nodes):
        answer = postOrder(nodes, index*2)
        answer += postOrder(nodes, (index*2)+1)
        answer += str(index)+" "
    
        return answer

    else: return ""

print(solution([1,2,3,4,5,6,7]))
