int ppcm (int x, int y) {
  int p, mincm = 0;

  if (x % y == 0) {
    return y;
  }
  if (y % x == 0) {
    return x;
  }

  p = x*y;
  while((p >= x) && (p >= y)) {
    if ((p%x==0) && (p%y == 0)) {
      mincm = p;
    }
    p = p-1;
  }

  return mincm;

}