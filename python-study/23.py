def solution(genres, plays):

    genre = {}
    musiclist = list()
    answer = []

    for i in range(len(genres)):
        if genres[i] in genre:
            genre[genres[i]] += plays[i]
        else:
            genre[genres[i]] = plays[i]

    genre = dict(sorted(genre.items(), key=lambda x: -x[1]))

    for i in range(len(genres)):
        musiclist.append(music(i,plays[i],genres[i]))

    musiclist = sorted(musiclist, key=lambda x: (-x.played, x.index))

    for i in genre: 
        count = 0
        for j in musiclist:
            if i == j.gen:
                answer.append(j.index)
                count += 1
                if count == 2:
                    break


    return answer

class music:
    def __init__(self, index, played, gen):
        self.index = index
        self.played = played
        self.gen = gen

    def __repr__(self) :
        return repr((self.index,self.played))


print(solution(["classic", "pop", "classic", "classic", "pop"],[500, 600, 150, 800, 2500]))
