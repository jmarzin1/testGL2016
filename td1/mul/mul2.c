int mul(int a, int b) {
  int m;

  while (b > 0) {
    if (b%2 == 1)
      m = m-a;
    a = a*2;
    b = b/2;
  }
  return m;
}
