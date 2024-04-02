def solution(genres, plays):

    genres_dict = {}
    for i in range(len(genres)):
        genre = genres[i]

        if genre not in genres_dict:
            genres_dict[genre] = []

        genres_dict[genre].append((i,plays[i]))
    
    print(genres_dict)
    print(genres_dict["classic"][0][0])
   
    return 

print(solution(["classic", "pop", "classic", "classic", "pop"],[500, 600, 150, 800, 2500]))