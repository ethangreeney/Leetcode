#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  const long long INF = (1LL << 60);

  int n;
  if (!(cin >> n)) return 0;

  vector<vector<long long>> d(n, vector<long long>(n));
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      string s;
      cin >> s;
      if (s == "INF" || s == "inf" || s == "-")
        d[i][j] = INF;
      else
        d[i][j] = stoll(s);
    }
  }

  for (int k = 0; k < n; ++k)
    for (int i = 0; i < n; ++i)
      for (int j = 0; j < n; ++j) {
        if (d[i][k] == INF || d[k][j] == INF) continue;
        d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
      }

  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if (d[i][j] >= INF / 2)
        cout << "INF";
      else
        cout << d[i][j];
      if (j + 1 < n) cout << ' ';
    }
    cout << '\n';
  }
  return 0;
}