/* By Zoff <http://forum.ubuntu-it.org> */
#include <stdio.h>
#define BUFFER_SIZE 1024

void print_binary_bite(unsigned char n){
    int i;
    static char bin[9];
    
    for(i=7; i>=0; i--){
        bin[i] = n%2+'0';
        n/=2;
    }
    bin[8]='\0';
    
    printf("%s",bin);
}

int main(int argc, char** argv){
    
    int i,nread;
    FILE* todump;
    unsigned char buffer[BUFFER_SIZE];
    
    if(argc<2){
        printf("Usage: %s filename\n",argv[0]);
        return 1;
    }
    
    todump = fopen(argv[1],"rb");
    if(!todump){
        printf("Impossibile aprire il file: '%s'\n",argv[1]);
        return 1;
    }
    
    while((nread=fread(buffer,sizeof(unsigned char),BUFFER_SIZE,todump))>0){
        for(i=0;i<nread;i++){
            print_binary_bite(buffer[i]);
        }
    }
    printf("\n");
    fclose(todump);
    
    return 0;
}
