#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <gccore.h>
#include <wiiuse/wpad.h>
#include <SDL/SDL.h>
#include <SDL/SDL_image.h>
#include <SDL/SDL_ttf.h>

char output[] = "video";
static u32 *xfb;
static GXRModeObj *rmode;
SDL_Surface *screen;

void initvideo() {
	WPAD_Init();
	VIDEO_Init();
	rmode = VIDEO_GetPreferredMode(NULL);
	xfb = MEM_K0_TO_K1(SYS_AllocateFramebuffer(rmode));
	console_init(xfb,20,20,rmode->fbWidth,rmode->xfbHeight,rmode->fbWidth*VI_DISPLAY_PIX_SZ);
	VIDEO_Configure(rmode);
	VIDEO_SetNextFramebuffer(xfb);
	VIDEO_SetBlack(FALSE);
	VIDEO_Flush();
	VIDEO_WaitVSync();
	if(rmode->viTVMode&VI_NON_INTERLACE)
		VIDEO_WaitVSync();
}

void initsdl() {
	/* Check */
	if(SDL_Init(SDL_INIT_VIDEO | SDL_INIT_AUDIO) < 0) {
		fprintf(stderr, "Unable to init SDL: %s\n", SDL_GetError());
		SDL_Delay(5000);
		exit(EXIT_FAILURE);
	}
	WPAD_Init();
	
	/* Clean...*/
	atexit(SDL_Quit);
	SDL_ShowCursor(SDL_DISABLE);
	
	/* Make screen */
	screen = SDL_SetVideoMode(640, 480, 16, SDL_DOUBLEBUF);
	if(!screen) {
		fprintf(stderr, "Unable to set vide: %s\n", SDL_GetError());
		SDL_Delay(5000);
		exit(EXIT_FAILURE);
	}
}

void updatevideo() {
	VIDEO_WaitVSync();
}

void updatesdl() {
	SDL_Flip(screen);
}
	
void quitvideo() {
	exit(EXIT_SUCCESS);
}
	
void quitsdl() {
	SDL_Quit();
	exit(EXIT_SUCCESS);
}

void init() {
	(strcmp(output, "video") == 0) ? initvideo() : initsdl();
}

void update() {
	(strcmp(output, "video") == 0) ? updatevideo() : updatesdl();
}

void quit() {
	(strcmp(output, "video") == 0) ? quitvideo() : quitsdl();
}

void clearscreen() {
	int i;
	for(i=0; i<30; ++i)
		printf("\n");
}

int main(int argc, char** argv) {
	init();
	
	printf("\x1b[5;5H");
	printf("Hello World!\n");
	printf("\x1b[2;0H");

	while(1) {
		WPAD_ScanPads();
		u32 pressed = WPAD_ButtonsDown(0);
		if(pressed & WPAD_BUTTON_HOME)
			quit();
		else if(pressed & WPAD_BUTTON_A)
			printf("Button A pressed.\n");
		else if(pressed & WPAD_BUTTON_B)
			clearscreen();
		update();
	}
	return 0;
}
