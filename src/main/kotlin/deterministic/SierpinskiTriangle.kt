package deterministic

import java.awt.Color
import java.awt.Graphics
import kotlin.math.sqrt

/**
 * Треугольник Серпинского — фрактал, один из двумерных аналогов множества Кантора.
 * Середины сторон равностороннего треугольника соединяются отрезками. Получаются
 * 4 новых треугольника. Из исходного треугольника удаляется внутренность срединного треугольника.
 * Получается множество, состоящее из 3 оставшихся треугольников «первого ранга».
 * Поступая точно так же с каждым из треугольников первого ранга, получим множество,
 * состоящее из 9 равносторонних треугольников второго ранга. Продолжая этот процесс бесконечно,
 * получим бесконечную последовательность, пересечение членов которой есть треугольник Серпинского.
 */
class SierpinskiTriangle(private val color: Color = Color.WHITE) {

    fun draw(g: Graphics, n: Int, x: Float, y: Float, size: Float) {
        if (n == 0) {
            return
        }

        g.color = color

        val x1: Float = x
        val y1: Float = y
        val x2: Float = x1 + size
        val y2: Float = y1
        val x3: Float = x1 + size / 2f
        val y3: Float = (y1 + sqrt(3.0) * size / 2f).toFloat()

        g.drawLine(x1.toInt(), y1.toInt(), x2.toInt(), y2.toInt())
        g.drawLine(x1.toInt(), y1.toInt(), x3.toInt(), y3.toInt())
        g.drawLine(x2.toInt(), y2.toInt(), x3.toInt(), y3.toInt())

        draw(g, n - 1, x1, y1, size / 2f)
        draw(g, n - 1, (x1 + x2) / 2f, (y1 + y2) / 2f, size / 2f)
        draw(g, n - 1, (x1 + x3) / 2f, (y1 + y3) / 2f, size / 2f)
    }

}