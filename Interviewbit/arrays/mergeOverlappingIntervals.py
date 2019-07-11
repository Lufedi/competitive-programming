# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
         self.start = s
         self.end = e
    def __repr__(self):
        return  f'({self.start},{self.end})'
class Solution:
    # @param intervals, a list of Intervals
    # @return a list of Interval

    def sortInput(self, intervals):
        tuples = []
        for pair in intervals:
            tuples.append((pair.start, pair.end))
        tuples.sort()
        res = []
        for pair in tuples:
            res.append(Interval(pair[0], pair[1]))
        return res

    def merge(self, intervals):
        INF = 100000000000000
        intervals.append(Interval(INF, INF))
        res  = []
        intervals = self.sortInput(intervals)
        low = intervals[0].start
        high = intervals[0].end
        for i in range(len(intervals) - 1):
            print(high)
            if  high >= intervals[i+1].start:
                high = max(intervals[i+1].end, high)
            else:
                res.append(Interval(low, high))
                low = intervals[i+1].start
                high = intervals[i+1].end
        return res
def create(l):
    s = []
    for a in l:
        s.append(Interval(a[0],a[1]))
    return s
c = Solution()
print(c.merge(create([(1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6)])))
