def solution(id_list, report, k):
    
    id_report_num = dict()
    id_list_report = dict()
    answer = []

    for i in id_list:
        id_report_num[i] = 0
        id_list_report[i] = []
    
    for i in report:
        a,b = i.split()
        if b not in id_list_report[a]:
            id_report_num[b] += 1
            id_list_report[a].append(b)

    for i in id_list_report:
        count = 0
        for j in id_list_report[i]:
            if id_report_num[j] >= k:
                count += 1
        answer.append(count)

    return answer

print(solution(["muzi", "frodo", "apeach", "neo"],["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],2))