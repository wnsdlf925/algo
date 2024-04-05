
class node:

    def __init__(self, value):
        self.left = None
        self.right = None
        self.value = value
        
    def setLeft(self, left):
        self.left = left

    def setRight(self, right):
        self.right = right

class Tree:

    def __init__(self):
        self.root = None

    def insert(self, num):
        if self.root == None:
            self.root = node(num)
        else:
            cur = self.root
            while True:
                if cur.value > num:
                    if cur.left == None:
                        cur.left = node(num)
                        break
                    else:
                        cur = cur.left
                else:
                    if cur.right == None:
                        cur.right = node(num)
                        break
                    else:
                        cur = cur.right
    def find(self, num):
        cur = self.root
        while cur.value != num:
            if cur.value > num:
                cur = cur.left
            else:
                cur = cur.right

            if not cur: return False
        
        return True
        

def solution(lst, search_lst):
    answer = []
    tree = Tree()
    for i in lst:
        tree.insert(i)

    for i in search_lst:
        answer.append(tree.find(i))

    return answer

print(solution([5, 3, 8, 4, 2, 1, 7, 10], [1, 2, 5, 6])) # [True, True, True, False]
print(solution([1, 3, 5, 7, 9], [2, 4, 6, 8, 10])) # [False, False, False, False, False] 