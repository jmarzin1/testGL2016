int mul(int a, int b) {
  int m = 0;
  int neg=0;
  
  if (a<0 && b<0) {
    a*=-1;
    b*=-1;
  }
  else if (a<0) {
    a*= -1;
    neg = 1;
  }
  else if (b<0) {
    b*=-1;
    neg = 1;
  }
  
  while (b > 0) {
    if (b%2 ==1) {
      m = m+a;
      b-=1;
    }
    a = a * 2;
    b = b/2;
  }

  if (neg)
    return -m;
  else 
    return m;
}
