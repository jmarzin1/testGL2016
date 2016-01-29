#include <stdlib.h>
#include <stdio.h>
#include "ppcm.c"

void test(int x, int y, int result) {
  int pc = ppcm(x, y);
  if (pc == result) {
    printf("PASSED\n");
  }
  else {
    printf("FAILED: found %d instead of %d \n", pc, result);
  }
}


/* void lancer_test() { */
/*   test(2,3,6); */
/*   test(3,3,3); */
/*   test(0,0,0); */
/*   test(0,6,0); */
/*   test(-2,-3,6); */
/*   test(4,6,12); */
/* } */


int main(int argc, char** argv) {
   if (argc == 4) {
     test(atoi(argv[1]), atoi(argv[2]), atoi(argv[3]));
  }
  else {
    printf("Il faut 3 entiers en paramètres : x, y et résultat\n");
  }
}

