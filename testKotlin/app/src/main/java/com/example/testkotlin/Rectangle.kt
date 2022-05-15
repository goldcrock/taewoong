package com.example.testkotlin

class Rectangle(width: Int, height: Int) {
    val width = width
    val height = height
    val isSquare: Boolean
        get() = width == height

}