#include <stdio.h>
#include <stdlib.h>
#include "mul.c"

int main(int argc, char** argv) {

  int a = atoi(argv[1]);
  int b = atoi(argv[2]);
  int expected = atoi(argv[3]);

  int res = mul(a,b);

  printf("mul(%d, %d) =  %d\n", a, b, res);
  if (expected == res) {
    printf("OK\n");
    return EXIT_SUCCESS;
  }
  else {
    printf("FAILED\n");
    return EXIT_FAILURE;
  }
}
