package deterministic

import java.awt.Color
import java.awt.Graphics

class CirclesLineFractal(
    val radius: Int = 200,
    val minRadius: Int = 2,
    private val color: Color = Color.WHITE
) {

    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = color
        drawHelper(g, x, y, radius)
    }

    private fun drawHelper(g: Graphics, x: Int, y: Int, radius: Int) {
        if (radius <= minRadius) {
            return
        }

        val radiusHalf = radius.div(2)

        g.drawOval(x - radiusHalf, y - radiusHalf, radius, radius)

        drawHelper(g, x + radiusHalf, y, radiusHalf)
        drawHelper(g, x - radiusHalf, y, radiusHalf)
    }

}