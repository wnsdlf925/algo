
def soultion(arr,target):

    newArr = {}
    for i in arr:
        newArr[i] = 1

    for i in range(len(arr)):
        if target-arr[i] in newArr:
            return True



    return False

print(soultion([1,2,3,4,8],6))