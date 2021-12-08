package deterministic

import java.awt.Color
import java.awt.Graphics

/**
 * Набор Cantor представляет собой набор точек, лежащих на одном отрезке линии.
 * Троичный набор Кантора создается путем многократного удаления открытой средней трети из набора отрезков линии.
 */
class CantorSet(
    private val startLength: Int = 600,
    private val minLength: Int = 1,
    private val rectangleHeight: Int = 20,
    private val spaceHeight: Int = 20,
    private val color: Color = Color.WHITE
) {

    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = color
        drawHelper(g, x, y, startLength)
    }

    private fun drawHelper(g: Graphics, x: Int, y: Int, length: Int) {
        if (length <= minLength) {
            return
        }

        g.fillRect(x, y, length, rectangleHeight)

        val newY = y + (rectangleHeight + spaceHeight)

        drawHelper(g, x, newY, length / 3)
        drawHelper(g, x + (length * 2 / 3), newY, length / 3)
    }

}