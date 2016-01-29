int mul(int a, int b) {
  int m = 0;

  while (b > 0) {
    if (b%2 ==1) {
      m = m+a;
      b-=1;
    }
    a = a * 2;
    b = b/2;
  }

  return m;
}
