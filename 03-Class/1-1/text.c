#include <stdio.h>

typedef struct {
	int x, y, w, h;
	int font_size;
	char *str;
	char *font_face;
	char *font_style;
} Text;

void printText (Text * txt) {
	printf(""
		"text: %s\n"
		"font face: %s\n"
		"font style: %s\n"
		"font size: %d px\n"
		"position: (%d, %d)\n"
		"text box: %d x %d\n",
		txt->str,
		txt->font_face,
		txt->font_style,
		txt->font_size,
		txt->x, txt->y,
		txt->w, txt->h
	);
}

int main(void) {
	Text txt = {
		.x = 0,  .y = 0,
		.w = 10, .h = 1,
		.font_size = 16,
		.str = "Hello!",
		.font_face = "Liberations Sans",
		.font_style = "bold"
	};

	printText(&txt);

	return 0;
}

