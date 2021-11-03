#include <stdio.h>
#include <stdlib.h>

struct rect {
	int x, y, w, h;
};

struct rect * rect_new (void)
{
	struct rect *r = malloc(sizeof *r);

	r->x = r->y = r->w = r->h = 0;
	
	return r;
}

void rect_drag (struct rect *r, int dx, int dy)
{
	r->x += dx;
	r->y += dy;
}

void rect_print (struct rect *r)
{
	printf("x: %d\ny: %d\nw: %d\nh: %d\n\n",
		r->x,
		r->y,
		r->w,
		r->h
	);
}
