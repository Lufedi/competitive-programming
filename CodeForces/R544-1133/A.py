from sys import stdin
def main():
	h1,s1 = [int(x) for x in stdin.readline().strip().split(":")]
	h2,s2 = [int(x) for x in stdin.readline().strip().split(":")]
	totalMinutes = (((h2-h1)*60)+(s2-s1)) // 2
	hr = h1+(totalMinutes//60)
	sr = s1+(totalMinutes%60)
	if sr >=  60:
		hr+=1
		sr= sr % 60
	print(f"{hr:02d}:{sr:02d}")
main()