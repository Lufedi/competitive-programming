#include <cstdio>
#include <cmath>
#include <vector>
#include <algorithm>

struct P {
  double x, y;
};

bool cmp(P a, P b) {
  return a.x < b.x;
};

double sqr(double n) {
  return n * n;
}

double dis(P a, P b) {
  return sqr(a.x - b.x) + sqr(a.y - b.y);
}

int main() {
  int n;
  while (scanf("%d", &n) && n) {
    P p[10000];
    for(int i = 0; i < n; i++){
      scanf("%lf%lf", &p[i].x, &p[i].y);
    }

    std::sort(p, p + n, cmp);
    double min = dis(p[0], p[1]);
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n && sqr(p[j].x - p[i].x) < min; j++)
        if (dis(p[j], p[i]) < min) min = dis(p[j], p[i]);
    min = sqrt(min);
    if (min > 10000.0 || fabs(min - 10000.0) < 0.00001) puts("INFINITY");
    else printf("%.4lf\n", min);
  }
  return 0;
}
