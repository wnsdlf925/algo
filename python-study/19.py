def polynomial_hash(str):
    p = 31
    m = 1_000_000_007
    hash_value = 0
    for char in str:
        hash_value = (hash_value * p + ord(char))%m
    return hash_value

def solution(strList,queryList): 
    hash_list = [polynomial_hash(str) for str in strList]

    result = []

    for query in queryList:
        query_hash = polynomial_hash(query)
        if query_hash in hash_list:
            result.append(True)
        else: result.append(False)
    return result