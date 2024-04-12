import sys
sys.setrecursionlimit(1000000)

def solution(nodeinfo):
    

    input_node = []
    tree = Tree()
    answer =[[],[]]
    
    for i in range(len(nodeinfo)):
        input_node.append((nodeinfo[i][0],nodeinfo[i][1],i+1))

    input_node = sorted(input_node, key= lambda x: -x[1])

    for i in input_node:
        tree.insertNode(i[0],i[2])

    root = tree.getRoot()
    postOrder(root,answer)
    preOrder(root, answer)

    
    
    return answer


class Node:

    def __init__(self,value,index):
        self.right = None
        self.left = None
        self.value = value
        self.index = index
        

class Tree:
    def __init__(self):

        self.root = None

    def insertNode(self, value,index):

        if self.root == None:
            self.root = Node(value,index)
        else:
            cur = self.root
            while True:
                if cur.value > value:
                    if cur.left == None:
                        cur.left = Node(value,index)
                        break
                    else:
                        cur = cur.left

                else:
                    if cur.right == None:
                        cur.right = Node(value,index)
                        break
                    else:
                        cur = cur.right
        return self.root
    def getRoot(self):
        return self.root

def preOrder(root, answer):
    if root != None:
        answer[0].append(root.index)
        preOrder(root.left,answer)
        preOrder(root.right,answer)
    else: return


    
def postOrder(root ,answer):
    if root != None:
        postOrder(root.left,answer)
        postOrder(root.right,answer)
        answer[1].append(root.index)

    else: return



print(solution([[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]))

# 파이썬은 재귀의 한도가 1000로 되어있어서
# import sys
# sys.setrecursionlimit(1000000) 
# 재귀를 더 타야한다면 이걸 써야함


