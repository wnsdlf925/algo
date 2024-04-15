def solution(nums):

    answer = 0
    phone = set()

    for i in nums:
        phone.add(i)
    
    if len(phone) < len(nums)//2:
        answer = len(phone)
    else: answer = len(nums)//2

    return answer


print(solution([3,1,2,3]))