#include <stdlib.h>
#include <stdio.h>
#include "mystere.h"
#include <string.h>

void test_upcase_word(char* arg1, char* arg2, char* res) {
  upcase_word(arg1);
  upcase_word_2(arg2);
  if (strcmp(arg1, res) == 0) {
    printf("upcase_word OK\n");
  }
  else {
    printf("Found : %s, Expected : %s\n", arg1, res);
    printf("upcase_word FAILED\n");
  }
  
  if (strcmp(arg2, res) == 0) {
    printf("upcase_word_2 OK\n");
  }
  else {
    printf("Found : %s, Expected : %s\n", arg2, res);
    printf("upcase_word_2 FAILED\n");
  }
}



int main(int argc, char **argv) {

  /*test upcase*/
  if (argc == 4) {
    test_upcase_word(argv[1], argv[2], argv[3]);
  }
  
  /* test de months*/
  /*for (int i=1; i < 13; i++) {
    printf("%d\n", i);
    const char* res = malloc(sizeof(months(i)));
    res = months(i);
    printf("%s\n", res);
    }

  if (argc == 2) {
    printf("%s\n", argv[1]);
    int res = month_nth(argv[1]);
    printf("%d\n", res);
    }*/
     
  
  return 0;
}
