#include <stdio.h>
#include <stdlib.h>
#include "mul.c"

int main(int argc, char** argv) {

  int a = atoi(argv[1]);
  int b = atoi(argv[2]);

  int res = mul(a,b);

  printf("mul(%d, %d) =  %d\n", a, b, res);
  return 0;
}
