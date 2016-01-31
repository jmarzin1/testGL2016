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


char* verify(int i) {
  switch(i) {
  case 1:
    return "january";
    break;
  case 2:
    return "february";
    break;
  case 3:
    return "march";
    break;
  case 4:
    return "april";
    break;
  case 5:
    return "may";
    break;
  case 6:
    return "june";
    break;
  case 7:
    return "july";
    break;
  case 8:
    return "august";
    break;
  case 9:
    return "september";
    break;
  case 10:
    return "october";
    break;
  case 11:
    return "november";
    break;
  case 12:
    return "december";
    break;
  default:
    return "error";
    break;
  }
}

int verify_month(char *str) {
  if (strcmp(str, "january") == 0) {
    return 1;
  }
  else if (strcmp(str,"february") == 0) {
    return 2;
  }
  else if (strcmp(str,"march") == 0) {
    return 3;
  }
  else if (strcmp(str,"april") == 0) {
    return 4;
  }
  else if (strcmp(str,"may") == 0) {
    return 5;
  }
  else if (strcmp(str,"june") == 0) {
    return 6;
  }
  else if (strcmp(str,"july") == 0) {
    return 7;
  }
  else if (strcmp(str,"august") == 0) {
    return 8;
  }
  else if (strcmp(str,"september") == 0) {
    return 9;
  }
  else if (strcmp(str,"october") == 0) {
    return 10;
  }
  else if (strcmp(str,"november") == 0) {
    return 11;
  }
  else if (strcmp(str,"december") == 0) {
    return 12;
  }
  else {
    return 0;
  }
}

void test_months() {
  for (int i=1; i < 13; i++) {
    printf("Month %d\n", i);
    const char* res = malloc(sizeof(months(i)));
    res = months(i);
    printf("Found %s\n", res);
    if (strcmp(res, verify(i)) == 0) {
      printf("OK\n");
    }
    else {
      printf("Found : %s, Expected : %s\n", res, verify(i));
      printf("months FAILED\n");
    }
  }
}

void test_month_nth(char* arg) {
  printf("%s\n", arg);
  int res = month_nth(arg);
  if (verify_month(arg) == res) {
      printf("OK\n");
  }
  else {
    printf("Found : %d, Expected : %d\n", res, verify_month(arg));
    printf("FAILED\n");
  }
}

void test_triangle(float a, float b, float c, enum Triangle expected) {
  enum Triangle result = triangle(a,b,c);
  enum Triangle result2 = triangle_2(a,b,c);
  if (result == expected) {
    printf("OK\n");
  }
  else {
    printf("triangle FAILED\n");
    printf("Found %d, expected %d\n", result, expected);
  }
  if (result2 == expected) {
    printf("OK\n");
  }
  else {
    printf("triangle2 FAILED\n");
    printf("Found %d, expected %d\n", result2, expected);
  }
}

enum Triangle fill_enum(int arg) {
  switch(arg) {
  case 0:
    return DEGENERE;
    break;
  case 1:
    return SCALENE_AIGU;
    break;
  case 2:
    return SCALENE_OBTUS;
    break;
  case 3:
    return ISOCELE_AIGU;
    break;
  case 4:
    return ISOCELE_OBTUS;
    break;
  case 5:
    return EQUILATERAL;
    break;
  default:
    break;
  }
}

int main(int argc, char **argv) {

  /*test upcase*/
  if (argc == 4) {
    test_upcase_word(argv[1], argv[2], argv[3]);
  }
  
  /* test months*/
  if (argc == 1) {
    test_months();
  }

  /*test month_nth*/
  if (argc == 2) {
    test_month_nth(argv[1]);
  }

  /*test triangle*/
  if (argc == 5) {
    float a = atof(argv[1]);
    float b = atof(argv[2]);
    float c = atof(argv[3]);
    enum Triangle expected = fill_enum(atoi(argv[4]));
    test_triangle(a, b, c, expected);
  }
  
  return 0;
}
