def solution(arr):
    answer = list(set(arr))
    # answer = sorted(answer, key=lambda x:-x)
    answer.sort(key=lambda x : -x)
    return answer

print(solution([1,-5,2,4,3])) # 반환값 : [-5, 1, 2, 3, 4]
print(solution([2,1,1,3,2,5,4])) # 반환값 : [1, 1, 2, 2, 3, 4, 5]
print(solution([1,6,7])) # 반환값 : [1, 6, 7]


# sort와 sorted
# sort는 리스트 메소드 arr.sort(), arr.sort(key=lambda x : len(x)) , arr.sort(reverse = True)
# sorted는 내장 함수 sorted(arr), sorted(arr, key = lamda x: x), sorted(arr, reverse = True)
# 람다에서 reverse하려면 -(마이너스) 붙이면 됨 sorted(arr, key = lamda x: -x)
# 
# 
# 
