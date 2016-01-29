#include <stdio.h>
#include <stdlib.h>
#include "ppcm.c"

int main(int argc, char** argv) {
  int a = atoi(argv[1]);
  int b = atoi(argv[2]);
  
  int res = ppcm(a,b);

  printf("PPCM(%d,%d) = %d \n", a, b, res);

  if (res == atoi(argv[3])) {
    printf("SUCCESS\n");
  }
  else {
    printf("FAILED\n");
  }
  
  return 0;

}
