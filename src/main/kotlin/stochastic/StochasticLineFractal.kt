package stochastic

import java.awt.Color
import java.awt.Graphics
import java.util.*

/**
 * Фрактал, необходимый для создания "хаотичных" линий-веток
 */
class StochasticLineFractal(
    val depth: Int = 5,
    val branches: Int = 2,
    val maxBranchLength: Int = 100,
    private val color: Color = Color.WHITE
) {
    private val random = Random()

    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = color
        (1..branches).forEach { _ ->
            draw(g, x, y, 0)
        }
    }

    private fun draw(g: Graphics, x: Int, y: Int, currentDepth: Int) {
        if (currentDepth == depth) {
            return
        }
        val colorScale = 0xFF / depth

        g.color = Color(
            color.red - colorScale * currentDepth,
            color.green - colorScale * currentDepth,
            color.blue - colorScale * currentDepth
        )

        (1..branches).forEach { _ ->
            val toX = x + random.nextInt(maxBranchLength + 1) - (maxBranchLength / 2)
            val toY = y + random.nextInt(maxBranchLength + 1) - (maxBranchLength / 2)
            g.drawLine(x, y, toX, toY)
            draw(g, toX, toY, currentDepth + 1)
        }

    }

}